package jdbcPackage;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {

		// JDBC를 사용하기 위한 Library 설정
		// JDBC 코드를 이용해서 DB 처리
		try {
			// 1. Driver Loading
			Class.forName("org.gjt.mm.mysql.Driver");
			// 2. 접속
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = 
					DriverManager.getConnection(url,id,pw); // import부분은 java껄로
			// 3. PreparedStatement 생성
			String sql = "select * from books";
			PreparedStatement pstmt =
					con.prepareStatement(sql);
			// 4. query 실행
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 결과처리
			while(rs.next()) {
				System.out.println(rs.getString("bprice"));
			}
			
			// 6. 사용된 resource를 해제
			// 나중에 연 객체를 먼저 해제
			rs.close();
			pstmt.close();
			con.close();  
			
			System.out.println("접속성공!!");
		}  catch (Exception e) {
			System.out.println(e);
		}	

	}

}
