package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// JDBC와 관련된 1, 2 => connect()
// 4 코드를 "모듈화" => disconnect()
// -> 별도의 클래스로 캐슐화하는 것이 더 유리함!
// -> 공통의 로직을 무듈화한 클래스
//		== Util 클래스

public class MovieDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	// Q. 배열리스트를 받아오는데,
	// insert()를 그럼 1번 하나요?
	// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
	public boolean insert(MovieVO mVO) {

		conn = JDBCUtil.connect();

		final String sql_INSERT = "INSERT INTO MOVIE (NAME, ODATE) VALUES('" + mVO.getName() + "', '" + mVO.getOdate() + "')";

		try {
			stmt = conn.createStatement();
			int res = stmt.executeUpdate(sql_INSERT);

			if(res <= 0) {
				// 적용된 row가 없음!
				return false;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);
		}

		return true;
	}

	public boolean update(MovieVO mVO) {

		conn = JDBCUtil.connect();

		final String sql_UPDATE = "UPDATE MOVIE SET NAME = '" + mVO.getName() + "' WHERE NUM = " + mVO.getNum() + "";

		try {
			stmt = conn.createStatement();
			int res = stmt.executeUpdate(sql_UPDATE);
			// Query -> SELECT -> output data
			// Update -> INSERT, UPDATE, DELETE -> output int

			if(res <= 0) {
				// 적용된 row가 없음!
				return false;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(stmt, conn);

		return true;
	}

	public boolean delete(MovieVO mVO) {

		conn = JDBCUtil.connect();

		// 3. 데이터 read, write

		final String sql_DELETE = "DELETE FROM MOVIE WHERE NUM = " + mVO.getNum() + "";

		try {
			stmt = conn.createStatement();
			int res = stmt.executeUpdate(sql_DELETE);
			// Query -> SELECT -> output data
			// Update -> INSERT, UPDATE, DELETE -> output int
			if(res <= 0) {
				// 적용된 row가 없음!
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);
		}


		return true;
	}

	public ArrayList<MovieVO> selectAll(MovieVO mVO) {


		conn = JDBCUtil.connect();

		final String sql_SELECTALL = "SELECT NUM, NAME, ODATE FROM MOVIE";

		ArrayList<MovieVO> mdatas = new ArrayList<MovieVO>();
		try {
			stmt = conn.createStatement();

			if(mVO == null) {
				rs = stmt.executeQuery(sql_SELECTALL);
			} else if(mVO != null) {
				final String sql_SELECTALL2 = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NAME LIKE '%" + mVO.getName() + "%'";
				rs = stmt.executeQuery(sql_SELECTALL2);
			}
			
			while(rs.next()) { // rs는 모델꺼라 VIEW가 가지고 있으면 안됨
				// 선생님 풀이
				//				int num = rs.getInt("NUM");
				//				String name = rs.getString("NAME");
				//				String odate = rs.getString("ODATE");
				//				MovieVO mdata = new MovieVO(num, name, odate);
				//				mdatas.add(mdata);

				MovieVO mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));

				mdatas.add(mdata);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(rs, stmt, conn);
		}

		return mdatas;

//		conn = JDBCUtil.connect();
//
//		final String sql_SELECTALL = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NAME LIKE '%" + mVO.getName() + "%'";
//
//		ArrayList<MovieVO> mdatas = new ArrayList<MovieVO>();
//		try {
//			stmt = conn.createStatement();
//
//			while(rs.next()) { // rs는 모델꺼라 VIEW가 가지고 있으면 안됨
//				// 선생님 풀이
//				//				int num = rs.getInt("NUM");
//				//				String name = rs.getString("NAME");
//				//				String odate = rs.getString("ODATE");
//				//				MovieVO mdata = new MovieVO(num, name, odate);
//				//				mdatas.add(mdata);
//
//				MovieVO mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));
//
//				mdatas.add(mdata);
//			}
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//			return null;
//		} finally {
//			JDBCUtil.disconnect(rs, stmt, conn);
//		}
//
//		return mdatas;

	}

	public MovieVO selectOne(MovieVO mVO) {

		conn = JDBCUtil.connect();

		final String sql_SELECTONE = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NUM = " + mVO.getNum() + ";";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTONE);
			// Query -> SELECT
			// Update -> INSERT, UPDATE, DELETE

			if(rs.next()) { // rs는 모델꺼라 VIEW가 가지고 있으면 안됨
				MovieVO mdata = new MovieVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getString("ODATE"));
				return mdata;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(rs, stmt, conn);
		}

		System.out.println("로그: 프로그램 종료");

		return null;
	}

}