package class01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

// 선생님 풀이
public class Test04 {

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
		
		int num;
		while(true) {
			try {
				System.out.println("확인할 학생 번호를 입력하세요.");
				num = sc.nextInt();
				if(num <= 0 ) {
					System.out.println("0보다 큰 정수를 입력하세요!\n");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로 입력하세요.\n");
			}
		}
		// -------------------------------- VIEW End --------------------------------

		// -------------------------------- Ctrl Start --------------------------------
		StudentVO sVO = new StudentVO(num, null, 0);
		// -------------------------------- Ctrl End --------------------------------
		
		final String sql_SELECTONE = "SELECT NUM, NAME, SCORE FROM STUDENT WHERE NUM = " + sVO.getNum() + ";";

		Statement stmt = null; // jsoup에서 사용했던 iterator과 유사
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTONE);
			// Query -> SELECT
			// Update -> INSERT, UPDATE, DELETE

			if(rs.next()) { // rs는 모델꺼라 VIEW가 가지고 있으면 안됨
				// -------------------------------- Ctrl Start --------------------------------
				StudentVO sVO2 = new StudentVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("SCORE"));
				// -------------------------------- Ctrl End --------------------------------

				// -------------------------------- VIEW Start --------------------------------
				// 컬럼명을 받아옴
				System.out.println(sVO2);
				System.out.println();
				// -------------------------------- VIEW Start --------------------------------
			} else {
				System.out.println("해당 학생은 없습니다.\n");
			}

		} catch (SQLException e1) {
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
