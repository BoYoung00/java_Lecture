package 자바강의2023.week14;

import java.sql.SQLException;

public class JDBCTest02 {
	public static void main(String[] args) {
		TestDao dao = null;
		
		try {
			dao = new TestDao();
			//dao.createTable();
			//dao.selectAll();
			//dao.selectUsingExecute("select name, age from JDBCTest");
			//dao.usingPreStatment("홍길동0", 20);
			dao.usingTansaction();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				dao.dbClose();
			} catch (SQLException e2) {}
			System.out.println("프로그램 종료");
		} //finally
	} //main
}
