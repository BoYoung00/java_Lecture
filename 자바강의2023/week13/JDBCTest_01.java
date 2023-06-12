package 자바강의2023.week13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest_01 {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2-B"
					+ "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", "root", "root1234");
			// ?characterEncoding=UTF-8 : 문자 코드는 유니코드
			// serverTimezone=UTC : 국제 표준시간대 UTC(Coordinated Universal Time)
			// useSSL=false : SLL사용
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		System.out.println("프로그램 종료");

	}

}
