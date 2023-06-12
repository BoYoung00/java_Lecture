package 자바강의2023.week14;

import java.sql.*;

public class TestDao {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public TestDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2-B"
				+ "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", "root", "root1234");
		
		stmt=conn.createStatement();
		
	}
	
	public void createTable() throws SQLException {
		stmt.executeUpdate("create table JDBCTest(name varchar(20), age int)");
		System.out.println("JDBCTest 테이블 생성 완료");
		String sql = null;
		for (int i = 0; i < 5; i++) {
			sql = "Insert Into JDBCTest (name, age) values('";
			sql += "홍길동"+i+"','"+(20+i)+"')";
			stmt.executeUpdate(sql);
			
		}
	}
	
	public void selectAll() throws SQLException {
		rs = stmt.executeQuery("select name, age from JDBCTest");
		while (rs.next()) {
			System.out.println("name : " + rs.getString(1) + " age : " + rs.getInt("age"));
			
		}
	}
	
	public void selectUsingExecute(String sql) throws SQLException {
		boolean isResult = stmt.execute(sql); // sql문이 맞는지 확인
		if (isResult) { //True : ResultSet 객체를 반환
			rs = stmt.getResultSet(); // 테이블 값 가져오기 한 행씩
			while (rs.next())
				System.out.println("name : " + rs.getString("name") + " age : " + rs.getInt(2));
		} else 
			System.out.println("rowCount : " + stmt.getUpdateCount());
	}
	
	public void usingPreStatment(String name, int age) throws SQLException {
		pstmt = conn.prepareStatement("select name, age from JDBCTest where name=? and age >= ?");
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		
		rs = pstmt.executeQuery();
		while (rs.next()) 
			System.out.println("name : " + rs.getString("name") + " age : " + rs.getInt(2));
	}
	
	public void usingTansaction() {
		try {
			conn.setAutoCommit(false); // 트랜젝션의 시작
			stmt.executeUpdate("Insert Into JDBCTest (name, age) values('홍길동10', 20)");
			stmt.executeUpdate("Insert Into JDBCTest (name, age) values('임꺽정11', 21)"); // 일부러 오류
			conn.commit(); // 트랜젝션의 범위 (만나기 전까지 트렌젝션)
			selectAll();
		} catch (Exception e) {
			try {
				// 트랜젝션의 범위 (만나기 전까지 트렌젝션)
				conn.rollback(); // 정상적인 코드까지 취소시킴
				selectAll();
			} catch (Exception e2) {} 
		}
	}
	
	public void dbClose() throws SQLException {
		if (conn != null) 
			conn.close();
		
		if (stmt != null) 
			stmt.close();
		
		if (rs != null) 
			rs.close();
		
	}
	
}
