package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// 회원가입 쿼리문
	final String sql_insert = "INSERT INTO MEMBER (MID,MPW,MNAME) VALUES(?, ?, ?)";

	// 비번변경, 이름변경 쿼리문
	final String sql_update_MPW = "UPDATE MEMBER SET MPW = ? WHERE MID = ?";
	final String sql_update_NAME = "UPDATE MEMBER SET NAME = ? WHERE MID = ?";
	// 관리자 -> 경고 카운트
	final String sql_update_WARN_UP = "UPDATE MEMBER SET WARNCNT = WARNCNT + 1 WHERE MID = ?";
	final String sql_update_WARN_DOWN = "UPDATE MEMBER SET WARNCNT = WARNCNT - 1 WHERE MID = ?";
	// 관리자 자격부여
	final String sql_update_GRANT = "UPDATE MEMBER SET ADMIN = ? WHERE MID = ?";
	final String sql_update_REVOKE = "UPDATE MEMBER SET ADMIN = ? WHERE MID = ?";

	// 회원탈퇴 쿼리문
	final String sql_delete = "DELETE FROM MEMBER WHERE MID = ?";
	// 관리자가 회원 삭제(관리자 삭제X) 쿼리문
	final String sql_delete_MEMBER = "DELETE FROM MEMBER WHERE MID = ?";

	// 로그인 쿼리문
	final String sql_selectONE = "SELECT MID, MNAME, MPW, WARNCNT, ADMIN FROM MEMBER WHERE MID = ? AND MPW= ?";
	final String sql_selectONE_Search = "SELECT MID, MNAME, MPW, WARNCNT, ADMIN FROM MEMBER WHERE MID = ?";
	// 회원목록 출력 쿼리문
	final String sql_SelectAll = "SELECT MID, MNAME, MPW, WARNCNT, ADMIN FROM MEMBER WHERE ADMIN = ?";
	// 이름검색 쿼리문
	final String sql_selectAll_NAME = "SELECT MID, MNAME, MPW, WARNCNT, ADMIN FROM MEMBER WHERE MNAME LIKE CONCAT('%', ?, '%')";
	// 경고카운트 3회이상 회원목록 출력 쿼리문
	final String sql_selectAll_WARNCNT = "SELECT MID, MNAME, MPW, WARNCNT, ADMIN FROM MEMBER WHERE WARNCNT >= 3 AND ADMIN = FALSE";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public MemberDAO() {
		MemberVO mVO=new MemberVO("admin","관리자","1234",0,true);
		this.insert(mVO);
		mVO.setSelect("자격부여");
		this.update(mVO);
	}


	// 회원 가입
	public boolean insert(MemberVO mVO) {

		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);

//			System.out.println("로그 : mDAO : insert : pstmt에 넣어 실행 1");

			pstmt.setString(1, mVO.getmId());
			pstmt.setString(2, mVO.getmPw());
			pstmt.setString(3, mVO.getmName());
			pstmt.executeUpdate();

//			System.out.println("로그 : mDAO : insert : pstmt에 넣어 실행 2");  

		}catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : mDAO : insert : 예외발생시 실패 전");
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

//		System.out.println("로그 : mDAO : insert : 성공 반환 전");
		return true;

	}

	// 비번변경, 이름변경 / 경고카운트
	public boolean update(MemberVO mVO) {

		conn = JDBCUtil.connect();
		try {
			if(mVO.getSelect().equals("비번변경")) {
				pstmt = conn.prepareStatement(sql_update_MPW);

//				System.out.println("로그 : mDAO : update : 비번변경 : pstmt에 넣어서 실행 1");

				pstmt.setString(1, mVO.getTmpMpw());
				pstmt.setString(2, mVO.getmId());
			}
			else if(mVO.getSelect().equals("이름변경")) {
				pstmt = conn.prepareStatement(sql_update_NAME);

//				System.out.println("로그 : mDAO : update : 이름변경 : pstmt에 넣어서 실행 1");

				pstmt.setString(1, mVO.getmName());
				pstmt.setString(2, mVO.getmId());
			}
			else if(mVO.getSelect().equals("경고증가")) {
				pstmt = conn.prepareStatement(sql_update_WARN_UP);

//				System.out.println("로그 : mDAO : update : 경고증가 : pstmt에 넣어서 실행 1");

				pstmt.setString(1, mVO.getmId());
			}
			else if(mVO.getSelect().equals("경고감소")) {
				pstmt = conn.prepareStatement(sql_update_WARN_DOWN);

//				System.out.println("로그 : mDAO : update : 경고감소 : pstmt에 넣어서 실행 1");

				pstmt.setString(1, mVO.getmId());
			}
			else if(mVO.getSelect().equals("자격부여")) {
				pstmt = conn.prepareStatement(sql_update_GRANT);

//				System.out.println("로그 : mDAO : update : 자격부여 : pstmt에 넣어서 실행 1");

				pstmt.setBoolean(1, true);
				pstmt.setString(2, mVO.getmId());
			}
			else if(mVO.getSelect().equals("자격회수")) {
				pstmt = conn.prepareStatement(sql_update_REVOKE);

//				System.out.println("로그 : mDAO : update : 자격회수 : pstmt에 넣어서 실행 1");

				pstmt.setBoolean(1, false);
				pstmt.setString(2, mVO.getmId());
			}

			int result = pstmt.executeUpdate(); 

//			System.out.println("로그 : mDAO : update : pstmt에 넣어서 실행 2");

			if(result <= 0) {
//				System.out.println("로그 : mDAO : update : 실패시 반환 전");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : mDAO : update : 예외 발생시 실패 반환전");
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

//		System.out.println("로그 : mDAO : update : 성공 반환전");

		return true;
	}

	// 회원 탈퇴, 관리자가 회원 삭제
	public boolean delete(MemberVO mVO) {

		conn = JDBCUtil.connect();
		try {

			pstmt = conn.prepareStatement(sql_delete);

//			System.out.println("로그 : mDAO : delete : pstmt에  넣어서 실행1");

			pstmt.setString(1, mVO.getmId());
			int result = pstmt.executeUpdate();

			if(mVO.getSelect().equals("회원삭제")) {
				pstmt = conn.prepareStatement(sql_delete_MEMBER);
				pstmt.setString(1, mVO.getmId());
				result = pstmt.executeUpdate();
			}

//			System.out.println("로그 : mDAO : delete : pstmt에  넣어서 실행2");

			// 진짜 데이터가 지워졌는지 확인하기 위함
			if(result <= 0) {
//				System.out.println("로그 : mDAO : delete : 실패 반환시");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : mDAO : delete : 예외발생시 실패 반환 전");
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

//		System.out.println("로그 : mDAO : delete : 성공 반환전");

		return true;
	}

	// 로그인
	public MemberVO selectOne(MemberVO mVO) {

		MemberVO mdata = null;

		conn = JDBCUtil.connect();

		try {
			if (mVO.getSelect().equals("회원검색")) {
				pstmt = conn.prepareStatement(sql_selectONE_Search); // 로그인
				pstmt.setString(1, mVO.getmId());
			}else if(mVO.getSelect().equals("로그인")){
				
			pstmt = conn.prepareStatement(sql_selectONE); // 로그인

//			System.out.println("로그 : mDAO : selectOne : pstmt에 selectOne 넣어서 실행1");

			pstmt.setString(1, mVO.getmId());
			pstmt.setString(2, mVO.getmPw());
			}
			rs = pstmt.executeQuery();

//			System.out.println("로그 : mDAO : selectOne : pstmt에 selectOne 넣어서 실행2");

			if (rs.next()) {
				mdata = new MemberVO(rs.getString("MID"), rs.getString("MNAME"), rs.getString("MPW"),
						rs.getInt("WARNCNT"), rs.getBoolean("ADMIN"));
			}

//			System.out.println("로그 : mDAO : selectOne : pstmt에 selectOne에 데이터 추가 한후");

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : mDAO : selectOne : pstmt에 selectOne에서 예외 발생시 반환 전");
			return null;
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

//		System.out.println("로그 : mDAO : selectOne : pstmt에 selectOne에서 mdata반환 전");

		return mdata;
	}
	// 회원목록출력, 이름검색
	public ArrayList<MemberVO> selectAll(MemberVO mVO){

		ArrayList<MemberVO> mdatas = new ArrayList<MemberVO>();

		conn = JDBCUtil.connect();

		try {
			if(mVO.getSelect().equals("회원목록")) {

				pstmt = conn.prepareStatement(sql_SelectAll);

//				System.out.println("로그 : mDAO : selectAll : pstmt에 selectAll 넣어서 실행1");

				pstmt.setBoolean(1, mVO.isAdmin());
				rs = pstmt.executeQuery();
			}
			else if(mVO.getSelect().equals("이름검색")) {
				pstmt = conn.prepareStatement(sql_selectAll_NAME);
				pstmt.setString(1, mVO.getmName());
				rs = pstmt.executeQuery();
			}
			else if(mVO.getSelect().equals("경고누적")) {
				pstmt = conn.prepareStatement(sql_selectAll_WARNCNT);
				rs = pstmt.executeQuery();
			}

//			System.out.println("로그 : mDAO : selectAll : pstmt에 selectAll 넣어서 실행2");

			while(rs.next()) {
				mdatas.add(new MemberVO(rs.getString("MID"), rs.getString("MNAME"), rs.getString("MPW"), rs.getInt("WARNCNT"), rs.getBoolean("ADMIN")));
			}

//			System.out.println("로그 : mDAO : selectAll : pstmt에 selectAll에 데이터 추가한후");

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("로그 : mDAO : selectAll : pstmt에 selectAll에서 예외발생해서 반환되기 전");
			return null;
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

//		System.out.println("로그 : mDAO : selectAll : pstmt에 selectAll에서 mdatas 반환 전");

		return mdatas;
	}

}