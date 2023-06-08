package class01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		// JDBC의 4가지 순서
		
		// 1. JAVA와 DB를 연결해줄 자원(resource)을 가진
		//	  클래스(== 드라이버 : 서로 다른 시스템, 이종기기간의 연결을 위해 필요한 객체)를 메모리로 불러와야함 == load(적재)
		// 위 드라이버들은 기본 제공되는 클래스가 아님
		
		// 유지보수 용이
		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driverName_MySQL); // static이 붙어있을거란 예상을 할 수 있음 -> 객체와 무관하게 불러낼 수 있는 메서드
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 2. DB와 연결
		//  : Connection 객체가 필요하다
		final String url_MySQL = "jdbc:mysql://localhost/kim";
		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userName = "root";
		final String passwd = "1234";
		// DriverManager.getConnection(url, userName, password); // url, userName, password -> 인자 값
		
		Connection conn = null; 
		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd); // DB를 연결하는 주체가 Connection
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. DB에 데이터를 작성하거나(write),
		//	  DB의 데이터를 받아오거나(read) 할 수 있음
		//	: Statement 객체를 생성하고, 사용하는것이 목표
		
		// -------------------------------- VIEW Start --------------------------------
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생의 이름을 입력하세요.");
		String studentName = sc.next();
		
		System.out.println("학생의 점수를 입력하세요.");
		int studentScore = sc.nextInt();
		// -------------------------------- VIEW End --------------------------------
		
		// -------------------------------- Ctrl Start --------------------------------
		// CTRL 입장 : "M의 DAO의 CRUD 메서드의 인자는 VO인데 나도 VO로 주면 좋을 것 같다"
		StudentVO sVO = new StudentVO(0, studentName, studentScore);
		// -------------------------------- Ctrl End --------------------------------
		
		final String sql_INSERT = "INSERT INTO STUDENT (NAME, SCORE) VALUES('" + sVO.getName() + "', " + sVO.getScore() + ")";
		final String sql_UPDATE = "UPDATE STUDENT SET SCORE = 0 WHERE NUM = 1"; // WHERE 절 뒤에는 PK
		final String sql_DELETE = "DELETE FROM STUDENT WHERE NUM = 2"; // WHERE 절 뒤에는 PK
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_INSERT);
			stmt.executeUpdate(sql_UPDATE);
			stmt.executeUpdate(sql_DELETE);
			// Query -> SELECT
			// Update -> INSERT, UPDATE, DELETE
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 4. DB와 연결해제 ★
		// 만들었던거 역순으로
		// 반드시 닫아줘야함, 그렇지 않으면 메모리 나감
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("로그: 프로그램 종료");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
