package model;

import java.sql.Connection;
import java.sql.DriverManager;
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

	// Q. 배열리스트를 받아오는데,
	// insert()를 그럼 1번 하나요?
	// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
	public boolean insert(MovieVO mVO) {

		// JDBC

		// 1. 드라이버 로드

		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driverName_MySQL); // static이 붙어있을거란 예상을 할 수 있음 -> 객체와 무관하게 불러낼 수 있는 메서드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} 

		// 2. DB연결

		final String url_MySQL = "jdbc:mysql://localhost/kim";
		final String userName = "root";
		final String passwd = "1234";

		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd); // DB를 연결하는 주체가 Connection
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		// 3. 데이터 read, write

		final String sql_INSERT = "INSERT INTO MOVIE (NAME, ODATE) VALUES('" + mVO.getName() + "', '" + mVO.getOdate() + "')";

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_INSERT);
			// Query -> SELECT -> output data
			// Update -> INSERT, UPDATE, DELETE -> output int

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		// 4. DB 연결해제

		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(MovieVO mVO) {
		return false;
	}

	public boolean delete(MovieVO mVO) {
		// JDBC

		// 1. 드라이버 로드

		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driverName_MySQL); // static이 붙어있을거란 예상을 할 수 있음 -> 객체와 무관하게 불러낼 수 있는 메서드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} 

		// 2. DB연결

		final String url_MySQL = "jdbc:mysql://localhost/kim";
		final String userName = "root";
		final String passwd = "1234";

		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd); // DB를 연결하는 주체가 Connection
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		// 3. 데이터 read, write

		final String sql_DELETE = "DELETE FROM MOVIE WHERE NUM = " + mVO.getNum() + "";

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_DELETE);
			// Query -> SELECT -> output data
			// Update -> INSERT, UPDATE, DELETE -> output int

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		// 4. DB 연결해제

		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public ArrayList<MovieVO> selectAll(MovieVO mVO) {
		// JDBC
		// 1. 드라이버 로드

		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driverName_MySQL); // static이 붙어있을거란 예상을 할 수 있음 -> 객체와 무관하게 불러낼 수 있는 메서드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} 

		// 2. DB연결

		final String url_MySQL = "jdbc:mysql://localhost/kim";
		final String userName = "root";
		final String passwd = "1234";

		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd); // DB를 연결하는 주체가 Connection
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		// 3. 데이터 read, write

		final String sql_SEECLTALL = "SELECT NUM, NAME, ODATE FROM MOVIE";

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MovieVO> mdatas = new ArrayList<MovieVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SEECLTALL);
			// Query -> SELECT -> output data
			// Update -> INSERT, UPDATE, DELETE -> output int

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
		}

		// 4. DB 연결해제

		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return mdatas;
	}

	public MovieVO selectOne(MovieVO mVO) {

		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driverName_MySQL); // static이 붙어있을거란 예상을 할 수 있음 -> 객체와 무관하게 불러낼 수 있는 메서드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} 

		// 2. DB와 연결
		//  : Connection 객체가 필요하다
		final String url_MySQL = "jdbc:mysql://localhost/kim";
		final String userName = "root";
		final String passwd = "1234";

		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd); // DB를 연결하는 주체가 Connection
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		// 3. DB에 데이터를 작성하거나(write),
		//	  DB의 데이터를 받아오거나(read) 할 수 있음
		//	: Statement 객체를 생성하고, 사용하는것이 목표

		final String sql_SELECTONE = "SELECT NUM, NAME, ODATE FROM MOVIE WHERE NUM = " + mVO.getNum() + ";";

		Statement stmt = null; // jsoup에서 사용했던 iterator과 유사
		ResultSet rs = null;
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
		}

		// 4. DB와 연결해제 ★
		// 만들었던거 역순으로
		// 반드시 닫아줘야함, 그렇지 않으면 메모리 나감
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		System.out.println("로그: 프로그램 종료");
		return null;
	}

}