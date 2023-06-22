package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ForbiddenWordDAO {
	static final String sql_insert="INSERT INTO FORBIDDENWORD (BLOCK) VALUES ( ? )";
	static final String sql_delete="DELETE FROM FORBIDDENWORD WHERE NUM = ?";
	static final String sql_selectAll="SELECT NUM,BLOCK FROM FORBIDDENWORD";
	
	ResultSet rs;
	PreparedStatement pstmt;
	Connection conn;
	
	public ArrayList<ForbiddenWordVO> selectAll(ForbiddenWordVO fVO) {	// 금지어 목록 출력
		
		ArrayList<ForbiddenWordVO> fdatas=new ArrayList<ForbiddenWordVO>(); // 반환할 ArrayList-> fdatas
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
//			System.out.println("로그 : fDAO : selectAll : pstmt에 selectAll 넣어서 실행1");
			rs=pstmt.executeQuery();
//			System.out.println("로그 : fDAO : selectAll : pstmt에 selectAll 넣어서 실행2");
			while(rs.next()) {	// 
				fdatas.add(new ForbiddenWordVO(rs.getInt("NUM"),rs.getString("BLOCK")));
			}
//			System.out.println("로그 : fDAO : selectAll : pstmt에 selectAll 데이터 추가 하고 난후");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("로그 : fDAO : selectAll : pstmt에 selectAll에서 예외발생해서 null반환될때");
			return null;
		}
		
		JDBCUtil.disconnect(rs, pstmt, conn);	// 연결 다 끊어주고
//		System.out.println("로그 : fDAO : selectAll : pstmt에 selectAll실행해서 fdatas반환 하기전");
		return fdatas;
	}
	private ForbiddenWordVO selectOne() {
		return null;
	}

	public boolean insert(ForbiddenWordVO fVO) {	// 금지어 추가
		
		conn=JDBCUtil.connect();	// DB연결하고
		try {
			pstmt=conn.prepareStatement(sql_insert);	// insert넣어서 하고
//			System.out.println("로그 : fDAO : insert : pstmt에 insert 넣어서 실행1");
			pstmt.setString(1, fVO.getBlock());			// ? 자리에 PKNum받아와서 바꿔주고
			pstmt.executeUpdate();			// 실행해서 그결과값을 result에 저장
//			System.out.println("로그 : fDAO : insert : pstmt에 insert 넣어서 실행2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("로그 : fDAO : insert : pstmt에 insert실행시 예외 발생해서 false반환될때");
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn); // 연결 해놓은것 끊어주고
//		System.out.println("로그 : fDAO : insert : pstmt에 insert실행시 true반환되기 전");
		return true;	// 성공했을때 반환
	}
	private boolean update() {
		return false;
	}
	public boolean delete(ForbiddenWordVO fVO) {	// 금지어 삭제
		
		conn=JDBCUtil.connect();	// DB연결하고
		try {
			pstmt=conn.prepareStatement(sql_delete);	// delete넣어서 하고
//			System.out.println("로그 : fDAO : delete : pstmt에 delete넣어서 실행");
			pstmt.setInt(1, fVO.getNum());				// ? 자리에 PKNum받아와서 바꿔주고
			int result=pstmt.executeUpdate();			// 실행해서 그결과값을 result에 저장
//			System.out.println("로그 : fDAO : delete : delete 실행해서 result에 넣어었을때");
			if(result<=0) {	// 나온결과가 실행이 안됫다면
//				System.out.println("로그 : fDAO : delete : delete에서 if에 걸려서 false반환될때");
				return false;	// 실패 반환
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("로그 : fDAO : delete : delete실행시 예외발생해서 false반환될때");
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn); // 연결 해놓은것 끊어주고
//		System.out.println("로그 : fDAO : delete : 연결해제 하고 true반환 전 ");
		return true;	// 성공했을때 반환
	}
}
