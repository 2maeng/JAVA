package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ChampDAO {
	// SQL 쿼리문
	private final String sql_INSERT_CHAMPION = "INSERT INTO CHAMPION (NAME, LINE, TIER) VALUES (?, ?, ?)";
	private final String sql_SELECTALL = "SELECT NUM,NAME,LINE,TIER,WINCNT,PICKCNT FROM CHAMPION";
	private final String sql_SELECTALL_NAME = "SELECT NUM,NAME,LINE,TIER,WINCNT,PICKCNT FROM CHAMPION WHERE NAME LIKE ?";
	private final String sql_SELECTALL_LINE = "SELECT NUM,NAME,LINE,TIER,WINCNT,PICKCNT FROM CHAMPION WHERE LINE=?";
	private final String sql_SELECTALL_TIER = "SELECT NUM,NAME,LINE,TIER,WINCNT,PICKCNT FROM CHAMPION WHERE TIER=?";
	private final String sql_SELECTALL_LINETIER = "SELECT NUM,NAME,LINE,TIER,WINCNT,PICKCNT FROM CHAMPION WHERE LINE=? AND TIER=?";
	private final String sql_SELECTONE = "SELECT NUM,NAME,LINE,TIER,WINCNT,PICKCNT FROM CHAMPION WHERE NUM=?";
	private final String sql_UPDATE_NAME = "UPDATE CHAMPION SET NAME=? WHERE NUM=?";
	private final String sql_UPDATE_TIER = "UPDATE CHAMPION SET TIER=? WHERE NUM=?";
	private final String sql_UPDATE_GAME = "UPDATE CHAMPION SET WINCNT=?, PICKCNT=? WHERE NUM=?";
	private final String sql_DELETE_CHAMPION = "DELETE FROM CHAMPION WHERE NUM=?";
	// JDBC(자바 데이터베이스 커넥트) 도구
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ChampDAO() { // 생성자
		final int maxCC = 20; // 최대 크롤링 개수
		final int resultC = 5; // 생성 개수
		// 크롤링할 주소들
		final String url_top = "https://www.op.gg/champions?region=global&tier=platinum_plus&position=top";
		final String url_jungle = "https://www.op.gg/champions?region=global&tier=platinum_plus&position=jungle";
		final String url_mid = "https://www.op.gg/champions?region=global&tier=platinum_plus&position=mid";
		final String url_bot = "https://www.op.gg/champions?region=global&tier=platinum_plus&position=adc";
		final String url_sup = "https://www.op.gg/champions?region=global&tier=platinum_plus&position=support";
		// 필요한 정보 취사 1번 기준
		final String firstPC = "a > Strong";

		// 크롤링 결과 저장
		ArrayList<String> Top = Crawling.crawringName(url_top, firstPC, maxCC);
		ArrayList<String> Jungle = Crawling.crawringName(url_jungle, firstPC, maxCC);
		ArrayList<String> Mid = Crawling.crawringName(url_mid, firstPC, maxCC);
		ArrayList<String> Bot = Crawling.crawringName(url_bot, firstPC, maxCC);
		ArrayList<String> Sup = Crawling.crawringName(url_sup, firstPC, maxCC);

		ArrayList<Integer> check = new ArrayList<Integer>(); // 저장한 객체의 index 확인용 배열
		ArrayList<String> champ = new ArrayList<String>(); // 저장용 보조 배열
		Random rand = new Random(); // 랜덤 객체
		ChampVO cVO = new ChampVO(0); // 저장용 객체
		for (int i = 0; i < resultC; i++) { // 생성 예정인 개수만큼 반복
			int index; // 저장할 정보의 인덱스번호
			while (true) { // 정지시킬때까지 무한반복
				index = rand.nextInt(20); // 인덱스번호 랜덤생성
				int count = 0; // 중복검사 확인용 카운트
				for (int j = 0; j < check.size(); j++) { // 중복검사용
					if (check.get(j) == index) { // 중복이라면
						break; // 중복검사용 반복문 정지
					}
					count++; // 중복검사 카운트 증가
				}
				if (count == check.size()) { // 중복검사가 성공적으로 완료되었다면
					break; // while문 정지
				}
			} // while

			// 라인별 목록에서 생성된 index번호에 해당하는 챔프 정보 보조 배열에 저장
			champ.add(Top.get(index));
			champ.add(Jungle.get(index));
			champ.add(Mid.get(index));
			champ.add(Bot.get(index));
			champ.add(Sup.get(index));

			for (int j = 0; j < champ.size(); j++) { // 보조배열에 저장된 챔프수만큼 반복
				cVO.setName(champ.get(j)); // 챔프 이름 저장
				cVO.setLine(j + 1); // 챔프 라인 저장
				cVO.setTier(i + 1); // 챔프 티어 저장
//				System.out.println(" 로그: cDAO: 생성자 insert 직전");
				this.insert(cVO); // 저장된 챔프 정보 DB에 생성
			}
			champ.clear(); // 보조배열 비우기
			check.add(index); // 생성한 인덱스 저장 (중복검사용)
		}

	}

	public boolean insert(ChampVO incVO) { // DB에 객체정보 저장
		ChampVO cVO = new ChampVO("", incVO.getLine());
		cVO.setSelect("라인 검색");
		ArrayList<ChampVO> champNames = this.selectAll(cVO);
		for (ChampVO tmpcVO : champNames) {
			if (incVO.getName().equals(tmpcVO.getName())) { // 이름중복이라면
//				System.out.println(" 로그: cDAO: insert: 이름중복");
				return false;
			}
		}
		try { // 의도하지 않은 프로그램종료 예방
				// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문을 입력하는 저장공간 생성
			pstmt = conn.prepareStatement(sql_INSERT_CHAMPION);
			// SQL 쿼리문 수정
			pstmt.setString(1, incVO.getName());
			pstmt.setInt(2, incVO.getLine());
			pstmt.setInt(3, incVO.getTier());

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();

			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);

			// 검색 결과 리턴
			if (result >= 1) {
				return true;
			}

		} catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
//			System.out.println(" 로그: ChampDAO: insert: SQLException 발생");
			e.printStackTrace(); // 예외정보 출력
		}
		return false; // 저장 실패
	} // insert

	public ArrayList<ChampVO> selectAll(ChampVO incVO) { // 목록 검색
		ArrayList<ChampVO> list = new ArrayList<ChampVO>(); // 정보들을 저장할 배열

		try { // 예외처리
				// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문을 입력하는 저장공간 생성
			if (incVO.getSelect().equals("이름 검색")) { // 이름 검색일 경우
				if (incVO.getName().equals("")) { // 만약 검색 내용이 없다면 == 전체출력
					// SQL 쿼리문 입력
					pstmt = conn.prepareStatement(sql_SELECTALL);
				} else {
					// SQL 쿼리문 입력
					pstmt = conn.prepareStatement(sql_SELECTALL_NAME);
					// SQL 쿼리문 수정
					pstmt.setString(1, "%" + incVO.getName() + "%");
				}

			} else if (incVO.getSelect().equals("라인 검색")) { // 라인 검색일 경우
				// SQL 쿼리문 입력
				pstmt = conn.prepareStatement(sql_SELECTALL_LINE);
				// SQL 쿼리문 수정
				pstmt.setInt(1, incVO.getLine());
//				System.out.println(" 로그: cDAO: insert: 라인 검색  sql문 수정 완료");

			} else if (incVO.getSelect().equals("티어 검색")) { // 티어 검색일 경우
				// SQL 쿼리문 입력
				pstmt = conn.prepareStatement(sql_SELECTALL_TIER);
				// SQL 쿼리문 수정
				pstmt.setInt(1, incVO.getTier());

			} else if (incVO.getSelect().equals("라인티어 검색")) { // 라인,티어 검색일 경우
				// SQL 쿼리문 입력
				pstmt = conn.prepareStatement(sql_SELECTALL_LINETIER);
				// SQL 쿼리문 수정
				pstmt.setInt(1, incVO.getLine());
				pstmt.setInt(2, incVO.getTier());

			}
			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();

			// 가져온 정보 저장용 객체
			ChampVO outcVO;
			while (rs.next()) {
				// 가져온 정보 저장한 객체 생성
				outcVO = new ChampVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("LINE"), rs.getInt("TIER"),
						rs.getInt("WINCNT"), rs.getInt("PICKCNT"));
				// 생성한 객체를 배열에 저장
				list.add(outcVO);
			}

			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

			// 검색 결과 리턴
			return list;

		} catch (SQLException e) {
//			System.out.println(" 로그: ChampDAO: selectAll: SQLException 발생");
			e.printStackTrace();
		}
		// 예외가 발생했을 경우
		return null;

	}

	public ChampVO selectOne(ChampVO incVO) { // 하나의 객체 정보 검색

		ChampVO cVO = null; // 저장할 공간
		try { // 예외방지
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_SELECTONE);
			// SQL 쿼리문 수정
			pstmt.setInt(1, incVO.getNum());

			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();

			// 가져온 정보 저장
			if (rs.next()) {
				cVO = new ChampVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("LINE"), rs.getInt("TIER"),
						rs.getInt("WINCNT"), rs.getInt("PICKCNT"));
			}

			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

		} catch (SQLException e) {
//			System.out.println(" 로그: ChampDAO: selectOne: SQLException 발생");
			e.printStackTrace();
		}

		// 검색 결과 리턴
		return cVO;
	}

	public boolean update(ChampVO incVO) {

		try { // 예외처리
				// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문을 입력하는 저장공간 생성
			if (incVO.getSelect().equals("이름 변경")) { // 이름 검색일 경우
				// SQL 쿼리문 입력
				pstmt = conn.prepareStatement(sql_UPDATE_NAME);
				// SQL 쿼리문 수정
				pstmt.setString(1, incVO.getName());
				pstmt.setInt(2, incVO.getNum());

			} else if (incVO.getSelect().equals("티어 변경")) { // 티어 검색일 경우
				// SQL 쿼리문 입력
				pstmt = conn.prepareStatement(sql_UPDATE_TIER);
				// SQL 쿼리문 수정
				pstmt.setInt(1, incVO.getTier());
				pstmt.setInt(2, incVO.getNum());

			} else if (incVO.getSelect().equals("게임")) { // 라인,티어 검색일 경우
				// SQL 쿼리문 입력
				pstmt = conn.prepareStatement(sql_UPDATE_GAME);
				// SQL 쿼리문 수정
				pstmt.setInt(1, incVO.getWinCnt());
				pstmt.setInt(2, incVO.getPickCnt());
				pstmt.setInt(3, incVO.getNum());

			}

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();

			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

			// 검색 결과 리턴
			if (result >= 1) {
				return true;
			}
		} catch (SQLException e) {
//			System.out.println(" 로그: ChampDAO: update: SQLException 발생");
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(ChampVO incVO) {

		try { // 의도하지 않은 프로그램종료 예방
				// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문을 입력하는 저장공간 생성
			pstmt = conn.prepareStatement(sql_DELETE_CHAMPION);
			// SQL 쿼리문 수정
			pstmt.setInt(1, incVO.getNum());

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();

			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);

			// 성공 리턴
			if (result >= 1) {
				return true;
			}

		} catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
//			System.out.println(" 로그: ChampDAO: delete: SQLException 발생");
			e.printStackTrace(); // 예외정보 출력
		}

		return false;
	}

}
