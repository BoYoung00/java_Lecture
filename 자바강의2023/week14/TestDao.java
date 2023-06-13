package 자바강의2023.week14;

import java.sql.*;

// exexute : 쿼리이면 true 아니면 false
// -> 반환 값이 true라면 getResultSet 메서드 사용 가능
// executeUpdate : 추가, 삭제, 수정하는 sql문 실행
// -> 반환 값은 SQL문 실행에 영향 받은 행수 반환 (오류 시 -1)
// executeQuery : select문에서만 실행
// -> 반환 값은 ResultSet
public class TestDao {
	
	Connection conn = null; // DB 연결용
	Statement stmt = null; // SQL 구문을 실행하는 역할
	ResultSet rs = null; // 값 넣는 곳
	PreparedStatement pstmt = null; // Statement 기능 향상 (? 쓸 수 있게 해줌)
	
	public TestDao() throws ClassNotFoundException, SQLException { // 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2-B"
				+ "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", "root", "root1234");
		
		stmt=conn.createStatement();
		
	}
	
	public void createTable() throws SQLException { // 테이블 생성
		stmt.executeUpdate("create table JDBCTest(name varchar(20), age int)");
		System.out.println("JDBCTest 테이블 생성 완료");
		String sql = null;
		for (int i = 0; i < 5; i++) {
			sql = "Insert Into JDBCTest (name, age) values('";
			sql += "홍길동"+i+"','"+(20+i)+"')";
			stmt.executeUpdate(sql);
			
		}
	}
	
	public void selectAll() throws SQLException { // 테이블 전체 출력
		rs = stmt.executeQuery("select name, age from JDBCTest");
		while (rs.next()) {
			System.out.println("name : " + rs.getString(1) + " age : " + rs.getInt("age"));
			
		}
	}
	
	public void selectUsingExecute(String sql) throws SQLException { // sql문 받아서 출력
		boolean isResult = stmt.execute(sql); // sql문이 맞는지 확인
		if (isResult) { //True : ResultSet 객체를 반환
			rs = stmt.getResultSet(); // 테이블 값 가져오기 한 행씩
			while (rs.next())
				System.out.println("name : " + rs.getString("name") + " age : " + rs.getInt(2));
		} else 
			System.out.println("rowCount : " + stmt.getUpdateCount());
	}
	
	public void usingPreStatment(String name, int age) throws SQLException { // 일치하는 값 출력
		pstmt = conn.prepareStatement("select name, age from JDBCTest where name=? and age >= ?");
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		
		rs = pstmt.executeQuery();
		while (rs.next()) 
			System.out.println("name : " + rs.getString("name") + " age : " + rs.getInt(2));
	}
	
	public void usingTansaction() {
		// 트랜잭션 : 그룹으로 처리해야하느 명령문을 모아놓은 작업 단위
		// -> 하나라도 오류나면 전체 명령문 취소
		try {
			conn.setAutoCommit(false); // 트랜젝션의 시작
			stmt.executeUpdate("Insert Into JDBCTest (name, age) values('홍길동10', 20)");
			stmt.executeUpdate("Insert Into JDBCTest (name, age) values('임꺽정11', 21)"); // 일부러 오류
			conn.commit(); // 트랜젝션의 범위 (만나기 전까지 트렌젝션) commit : 모든 명령문이 성공했을 때
			selectAll();
		} catch (Exception e) {
			try {
				// 트랜젝션의 범위 (만나기 전까지 트렌젝션)
				conn.rollback(); // 하나라도 오류뜨면 정상적인 코드까지 취소시킴
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
