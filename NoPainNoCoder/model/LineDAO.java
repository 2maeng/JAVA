package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LineDAO {
	// SQL 쿼리문
	private final String sql_INSERTLINE = "INSERT INTO LINE (LINE) VALUES (?)";
	private final String sql_SELECTALL = "SELECT NUM,LINE FROM LINE";
	// JDBC(자바 데이터베이스 커넥트) 도구
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public LineDAO() {
		final String url_line = "https://www.op.gg/champions"; // 크롤링할 주소
		final String firstPL = "button.e14ouzjd6"; // 첫번째 가공
		final int maxCL = 5; // 크롤링해올 정보 개수
		ArrayList<String> Lines = new ArrayList<String>(); // 크롤링한 정보 저장용 배열
		Lines = Crawling.crawringName(url_line, firstPL, maxCL);
		LineVO lVO = new LineVO(0,"");
		
		// 크롤링해온 정보 DB에 저장
		for (String lineVO : Lines) {
			lVO.setLine(lineVO);
			this.insert(lVO);
		}
	}

	public boolean insert(LineVO inlVO) {

		try {
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();
			// SQL 쿼리문 저장
			pstmt = conn.prepareStatement(sql_INSERTLINE);
			// SQL 쿼리문 수정
			pstmt.setString(1, inlVO.getLine());

			// SQL 쿼리문 실행
			pstmt.executeUpdate();
			
			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);
			
		// 예외처리
		} catch (SQLException e) {
//			System.out.println(" 로그: LineDAO: insert: SQLException 발생");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<LineVO> selectAll(LineVO inlVO) {
		ArrayList<LineVO> list = new ArrayList<LineVO>(); // 객체들을 저장할 배열

		try {
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();

			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_SELECTALL);

			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();

			// 가져온 정보 저장용 객체
			LineVO outlVO;
			while (rs.next()) {
				// 가져온 정보 저장한 객체 생성
				outlVO = new LineVO(rs.getInt("NUM"), rs.getString("LINE"));
				// 생성한 객체를 배열에 저장
				list.add(outlVO);
			}

			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

			// 검색 결과 리턴
			return list;

		} catch (SQLException e) { // 예외처리
//			System.out.println(" 로그: LineDAO: selectALL: SQLException 발생");
			e.printStackTrace();
		}

		// 모종의 이유로 예외가 생겼을 경우
		return null;
	}

//	private LineVO selectOne() {
//		return null;
//	}
//	
//	private boolean update() {
//		return false;
//	}
//	
//	private boolean delete() {
//		return false;
//	}

}
