package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// 장점
//	: 코드 재사용성이 증가
//	: 중복코드 최소화
//	: 오류의 파급 효과 줄어듦
//	: 개발시간, 비용단축
//	: 영업 이익 증가
public class JDBCUtil {
	
	static final String driverName_MySQL="com.mysql.cj.jdbc.Driver"; // 클래스명, MySQL 드라이버명
//	static final String driverName_Oracle="oracle.jdbc.driver.OracleDriver"; // oracle.jdbc.driver.OracleDriver	<-- 오라클 드라이버명
	static final String url_MySQL="jdbc:mysql://localhost/RYU";		// <<--
//	static final String url_Oracle="jdbc:oracle:thin:@localhost:1521:xe";
	static final String userName="root";
	static final String password="1234";
	
	
	public static Connection connect() {
		// 유지 보수 용이
		try {
			Class.forName(driverName_MySQL); // new 없이 사용되었음 == static
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}	// new 없이 사용되었음 == static
		
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url_MySQL,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	public static void disconnect(PreparedStatement stmt, Connection conn) {
		try {
			stmt.close();	// stmt를 나중에 열었기 때문에 먼저 닫아야한다.
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void disconnect(ResultSet rs, PreparedStatement stmt, Connection conn) {
		try {
			stmt.close();	// stmt를 나중에 열었기 때문에 먼저 닫아야한다.
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	

	

	

	
	
}