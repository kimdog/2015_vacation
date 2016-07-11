package securityJect1;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mainServer {

	public static void main(String[] args) {

		//=============================== 서버는 클라이언트와 스레드를 이어주는 역할만 하고
		//=============================== 나머지 모든 일은 스레드 안에서 해결
		
		
		// ************ 추가사항 : DB를 여기서 생성해서 넘겨주어야 한다. << 그러나 수정시에 직접 thread안쪽에서 생성  
		Connection con = null;
		
		
		// JDBC를 사용하기 위한 Library 설정
		// JDBC 코드를 이용해서 DB 처리
		try {
			// 1. Driver Loading
			Class.forName("org.gjt.mm.mysql.Driver");
			// 2. 접속
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/test";	// test database
		 				
			con = 
					DriverManager.getConnection(url,id,pw); // import부분은 java껄로
			
			/*
			
			// 3. PreparedStatement 생성
			String sql = "select * from users";					// users table
			PreparedStatement pstmt =
					con.prepareStatement(sql);
			// 4. query 실행
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 결과처리
			while(rs.next()) {
				System.out.println(rs.getString("bprice"));
			}s
			*/
			
			System.out.println("DB connection 성공!!");
		}  catch (Exception e) {
			System.out.println(e + "db connection");
		}	

		
		
		
		System.out.println("프로그램 시작");
		
		Socket recieveSocket = null;               // 소켓접속 받는 소켓
				
				
		try {
			
			ServerSocket server = new ServerSocket(5000); // 서버 소켓을 찾기위한 port 번호 부여

			// 1. 웹과 접속 처리
			
			// 2. client 접속 처리 --> thread 안쪽에서 처리 
			// 	2-1. 회원가입
			// 	2-2. 로그인
						

			while(true) {
			
			recieveSocket = server.accept();              // 소켓접속이 들어올 때 까지 대기. block.
			
			threadClient toClient = 
					new threadClient(recieveSocket, con); 	// 들어온 소켓을 넘겨준다.
			
			Thread t = new Thread(toClient);
			
			t.start();
			
			}
						
			
		} catch (Exception e) {
			System.out.println(e + " :server");
		} finally {
			try {
				recieveSocket.close();
			
			} catch (Exception e) {
				System.out.println(e + " :server");
			}
		}
		
		
		// 6. 사용된  DB resource 를 해제
		
		try {
			con.close();
			
			System.out.println("DB disconnect");
		} catch ( Exception e ) {
			System.out.println("DB disconnect error" + e);
		}
					
	}

}
