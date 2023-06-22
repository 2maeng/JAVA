package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDAO {
	// SQL 쿼리문
	private final String sql_INSERT_REPLY = "INSERT INTO REPLY (CNUM, MID, COMMENT,CREATEDT) VALUES (?, ?, ?,NOW())";
//	private final String sql_SELECTALL_RECENCY = "SELECT NUM,CNUM,MID,COMMENT,CREATEDT,VERIFY FROM REPLY ORDER BY NUM DESC";
	private final String sql_SELECTALL_CHAMP = "SELECT NUM,CNUM,MID,COMMENT,CREATEDT,VERIFY FROM REPLY WHERE CNUM=?";
	private final String sql_SELECTALL_MEMBER = "SELECT NUM,CNUM,MID,COMMENT,CREATEDT,VERIFY FROM REPLY WHERE MID=?";
	private final String sql_SELECTALL_CHECK = "SELECT NUM,CNUM,MID,COMMENT,CREATEDT,VERIFY FROM REPLY WHERE VERIFY=?";
	private final String sql_SELECTONE = "SELECT NUM,CNUM,MID,COMMENT,CREATEDT,VERIFY FROM REPLY WHERE CNUM=? AND MID=?";
	private final String sql_UPDATE = "UPDATE REPLY SET COMMENT=? WHERE NUM=?";
	private final String sql_UPDATE_CHECK= "UPDATE REPLY SET VERIFY=? WHERE NUM=?";
	private final String sql_DELETE_REPLY = "DELETE FROM REPLY WHERE NUM=?";
	// JDBC(자바 데이터베이스 커넥트) 도구
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ReplyDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean insert(ReplyVO inrVO) { // DB에 객체정보 저장
		try { // 의도하지 않은 프로그램종료 예방
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();
			// SQL 쿼리문을 입력하는 저장공간 생성
			pstmt = conn.prepareStatement(sql_INSERT_REPLY);
//			System.out.println("로그 : rDAO : insert : pstmt에 insert 넣어서 실행1");
			// SQL 쿼리문 수정
			pstmt.setInt(1, inrVO.getcNum());
			pstmt.setString(2, inrVO.getmId());
			pstmt.setString(3, inrVO.getComment());

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();
//			System.out.println("로그 : rDAO : insert : pstmt에 insert 넣어서 실행1");

			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);

			// 검색 결과 리턴
			if (result >= 1) {
//				System.out.println("로그 : rDAO : insert : pstmt에 insert 성공 반환 전");
				return true;
			}

		} catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
//			System.out.println("로그 : rDAO : insert : pstmt에 insert 넣어서 실행1");
			e.printStackTrace(); // 예외정보 출력
			return false;
		}
//		System.out.println("로그 : rDAO : insert : pstmt에 insert실행시 실패반환 전");
		return false; // 저장 실패
	} // insert

	public ArrayList<ReplyVO> selectAll(ReplyVO inrVO) { // 목록 검색
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>(); // 정보들을 저장할 배열

		try { // 예외처리
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문을 입력하는 저장공간 생성
			if(inrVO.getSelect()!=null) {

				if (inrVO.getSelect().equals("챔피언 검색")) { // 이름 검색일 경우
					// SQL 쿼리문 입력
					pstmt = conn.prepareStatement(sql_SELECTALL_CHAMP);
//					System.out.println("로그 : rDAO : SELECTALL : 챔피언 검색 : pstmt에 SELECTALL 넣어서 실행1");
					// SQL 쿼리문 수정
					pstmt.setInt(1, inrVO.getcNum());

				} else if (inrVO.getSelect().equals("회원 검색")) { // 라인 검색일 경우
					// SQL 쿼리문 입력
					pstmt = conn.prepareStatement(sql_SELECTALL_MEMBER);
//					System.out.println("로그 : rDAO : SELECTALL : 회원 검색 : pstmt에 SELECTALL 넣어서 실행1");
					// SQL 쿼리문 수정
					pstmt.setString(1, inrVO.getmId());

				} else if (inrVO.getSelect().equals("미확인댓글 검색")) { // 티어 검색일 경우
					// SQL 쿼리문 입력
					pstmt = conn.prepareStatement(sql_SELECTALL_CHECK);
//					System.out.println("로그 : rDAO : SELECTALL : 미확인댓글 검색 : pstmt에 SELECTALL 넣어서 실행1");
					// SQL 쿼리문 수정
					pstmt.setBoolean(1, false);

				}
			}

			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();
//			System.out.println("로그 : rDAO : SELECTALL : pstmt에 SELECTALL 넣어서 실행2");
			// 가져온 정보 저장용 객체
			ReplyVO outrVO;
			while (rs.next()) {
				// 가져온 정보 저장한 객체 생성
				outrVO = new ReplyVO(rs.getInt("NUM"), rs.getInt("CNUM"), rs.getString("MID"), rs.getString("COMMENT"),
						rs.getTimestamp("CREATEDT"), rs.getBoolean("VERIFY"));
				// 생성한 객체를 배열에 저장
				list.add(outrVO);
			}
//			System.out.println("로그 : rDAO : SELECTALL : pstmt에 SELECTALL 데이터 추가 후");
			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

			// 검색 결과 리턴
//			System.out.println("로그 : rDAO : SELECTALL : pstmt에 SELECTALL LIST 반환 전");
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : rDAO : SELECTALL : pstmt에 SELECTALL 예외발생시 실패 반환 전");
		}
		// 예외가 발생했을 경우
//		System.out.println("로그 : rDAO : SELECTALL : pstmt에 SELECTALL 실패 반환 전");
		return null;

	}

	public ReplyVO selectOne(ReplyVO inrVO) { // 하나의 객체 정보 검색
		ReplyVO outrVO = null; // 저장할 공간
		try { // 예외방지
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_SELECTONE);
//			System.out.println("로그 : rDAO : SELECTONE : pstmt에 SELECTONE넣어서 실행 1");
			// SQL 쿼리문 수정
			pstmt.setInt(1, inrVO.getcNum());
			pstmt.setString(2, inrVO.getmId());

			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();
			System.out.println("로그 : rDAO : SELECTONE : pstmt에 SELECTONE넣어서 실행 2");

			// 가져온 정보 저장
			if (rs.next()) {
				outrVO = new ReplyVO(rs.getInt("NUM"), rs.getInt("CNUM"), rs.getString("MID"), rs.getString("COMMENT"),
						rs.getTimestamp("CREATEDT"), rs.getBoolean("VERIFY"));
			}
//			System.out.println("로그 : rDAO : SELECTONE : pstmt에 SELECTONE 데이터 추가 후");

			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : rDAO : SELECTONE : pstmt에 SELECTONE에서 예외 발생시 null반환 전");
			return null;
		}

		// 검색 결과 리턴
//		System.out.println("로그 : rDAO : SELECTONE : pstmt에 SELECTONE 성공 OUTRVO 반환 전");
		return outrVO;
	}

	public boolean update(ReplyVO inrVO) {

		try { // 예외처리
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문 입력
			if(inrVO.getSelect().equals("댓글 수정")) {
				
			pstmt = conn.prepareStatement(sql_UPDATE);
//			System.out.println("로그 : rDAO : UPDATE : pstmt에 UPDATE 넣고 실행1");
			// SQL 쿼리문 수정
			pstmt.setString(1, inrVO.getComment());
			pstmt.setInt(2, inrVO.getNum());
			}else if(inrVO.getSelect().equals("댓글 확인")) {
				pstmt = conn.prepareStatement(sql_UPDATE_CHECK);
//			System.out.println("로그 : rDAO : UPDATE : pstmt에 UPDATE 넣고 실행1");
				// SQL 쿼리문 수정
				pstmt.setBoolean(1, true);
				pstmt.setInt(2, inrVO.getNum());
				
			}
			

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();
//			System.out.println("로그 : rDAO : UPDATE : pstmt에 UPDATE 넣고 실행1");

			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);

			// 검색 결과 리턴
			if (result == 1) {
//				System.out.println("로그 : rDAO : UPDATE : pstmt에 UPDATE실행 성공시 반환 전");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : rDAO : UPDATE : pstmt에 UPDATE실행 예외발생시 실패 반환 전");
			return false;
		}
//		System.out.println("로그 : rDAO : UPDATE : pstmt에 UPDATE실행 시 실패 반환 전");
		return false;
	}

	public boolean delete(ReplyVO inrVO) {

		try { // 의도하지 않은 프로그램종료 예방
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_DELETE_REPLY);
//			System.out.println("로그 : rDAO : DELETE : pstmt에 delete에 delete 넣고 실행 1");
			// SQL 쿼리문 수정
			pstmt.setInt(1, inrVO.getNum());

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();
//			System.out.println("로그 : rDAO : DELETE : pstmt에 delete에 delete 넣고 실행 2");

			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);

			// 성공 리턴
			if (result >= 1) {
//				System.out.println("로그 : rDAO : DELETE : pstmt에 delete에 delete 성공시 반환 전");
				return true;
			}
		} catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
//			System.out.println("로그 : rDAO : DELETE : pstmt에 delete에 delete 실패시 반환 전");
			e.printStackTrace(); // 예외정보 출력
			return false;
		}		
//		System.out.println("로그 : rDAO : DELETE : pstmt에 delete에 delete 실패시 반환 전");
		return false;
	}

}
