package securityJect1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class threadClient implements Runnable {

	//========== 서버쪽의 쓰레드로
	//========== 각 클라이언트에 대해 받은 메세지를 그대로 모두에게 넘겨준다
	
	private Socket localSocket;   // 서버에서 이어줄 소켓을 넘겨 받는다
	private Connection con;
		
	public threadClient(Socket localSocket, Connection con) {
		super();
		this.localSocket = localSocket;
		this.con = con;
	}

	@Override
	public void run() {

		OutputStream os = null;
		ObjectOutputStream oos = null;
		PrintWriter pw = null;
		
		InputStream is = null;           // 받기위한 인풋스트림
		InputStreamReader isr = null;    // 인풋스트림 읽기
		BufferedReader br = null;        // 버퍼에서 읽기
		
		//======================= 넘겨받은 DB connection 처리 위한				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		String id = null;
		String password = null;
		String email_id = null;
		String email_pw = null;
		String enable = null;
					
		
		userInfo correctInfo = null;	// DB를 통해 넘겨줄 Info
		
		try {
			
			//======================= 연결될 소켓을 넘겨 받고 시작한다

			//======================= 받아들이는 것 생성
			is = localSocket.getInputStream();             // 인풋스트림 생성
			isr = new InputStreamReader(is);               // 스트림리더연결
			br = new BufferedReader(isr);                  // 버퍼리더 연결
			
			//======================= 내보내는 것 생성
			os = localSocket.getOutputStream();            // 아웃풋 스트림 생성
			pw = new PrintWriter(os);                      // 적기위한 printWriter
			
			oos = new ObjectOutputStream(os);				// objectOutputStream.
			

			int state = Integer.parseInt(br.readLine());
			
			
			switch(state) {
			
				case 1 :
					try {
						System.out.println("case 1 진입");
						id = br.readLine();
						
						sql = "select * from users where app_id =" + "'" + id +"'"; // table 명 : users
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						
						boolean isOverlap = false;
						
						if(rs.next())
							isOverlap = true;
						// 결과처리
						if(isOverlap) {
							pw.println(isOverlap);
							pw.flush();
							
						} else {
							pw.println(isOverlap);
							pw.flush();
						}
					} catch ( Exception e ) {
						System.out.println(e);
					}
					
					break;
					
				case 2 :
					System.out.println("case 2 진입");
					try {
						id = br.readLine();
						password = br.readLine();
									
						sql = 
								"insert into users(app_id,app_pw)" + "values(?,?)"; // 등록 쿼리
						PreparedStatement sptmt =
								con.prepareStatement(sql);
						sptmt.setString(1, id);             // 넣어줄 값
						sptmt.setString(2, password);			   // x번째 물음표
						sptmt.executeUpdate();
						
						boolean sqlEnroll = true;
						pw.println(sqlEnroll);
						pw.flush();
					
					} catch ( Exception e ) {
						System.out.println(e);
						try { 
							boolean sqlEnroll = false;
							pw.println(sqlEnroll);
							pw.flush();
						} catch ( Exception e2 ) {
							System.out.println(e2);
						}
					}
					break;
					
				case 3 :
					System.out.println("case 3 진입");
					try {
						
						id = br.readLine();
						password = br.readLine();
						

						
						sql = "select * from users where app_id ='" + id + "'&& app_pw ='" + password +"'";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						
						/*
						sql = 
								"select * from users where" + "id = ? && pw = ?"; // 등록 쿼리
						PreparedStatement sptmt =
								con.prepareStatement(sql);
						sptmt.setString(1, id");             // 넣어줄 값
						sptmt.setString(2, password);			   // x번째 물음표
						rs = sptmt.executeQuery();
						*/
						
						Boolean isCorrect = false;
						
						if(rs.next()) {
							System.out.println("rs.next 진입");
							isCorrect = true;
							pw.println(isCorrect);
							pw.flush();
							
							userInfo entity = new userInfo();
							entity.setId(rs.getString("app_id"));
							entity.setPw(rs.getString("app_pw"));
							entity.setEmail_id(rs.getString("id"));
							entity.setEmail_pw(rs.getString("password"));
							entity.setIsEnable(rs.getString("isEnable"));					
							//oos.writeObject(entity);
							//oos.flush();
							pw.println(entity.getId().toString());
							pw.flush();
							pw.println(entity.getPw().toString());
							pw.flush();
							pw.println(entity.getEmail_id().toString());
							pw.flush();
							pw.println(entity.getEmail_pw().toString());
							pw.flush();
							pw.println(entity.getIsEnable().toString());
							pw.flush();
							
						} else {
							System.out.println("else 진입");
							pw.println(isCorrect);
							pw.flush();
						}
												
					} catch ( Exception e ) {
						System.out.println("Login fail" + e);
					}
					break;
					
				case 4 :
					System.out.println("case 4 진입");
					try {
						id = br.readLine();
						password = br.readLine();
						enable = br.readLine();
						
						sql = 
								"update users set isEnable = ? " + "where app_id = ? && app_pw = ?"; // 등록 쿼리
						PreparedStatement sptmt =
								con.prepareStatement(sql);
						sptmt.setString(1, enable);
						sptmt.setString(2, id);             
						sptmt.setString(3, password);			 
						sptmt.executeUpdate();
						
						boolean sqlSuccess = true;
						pw.println(sqlSuccess);
						pw.flush();
					
					} catch ( Exception e ) {
						System.out.println(e);
						try { 
							boolean sqlSuccess = false;
							pw.println(sqlSuccess);
							pw.flush();
						} catch ( Exception e2 ) {
							System.out.println(e2);
						}
					}
					
					break;
					

				case 5 :
					
					System.out.println("case 5 진입");
					try {
						id = br.readLine();
						password = br.readLine();
						email_id = br.readLine();
						email_pw = br.readLine();
						
						sql = "select * from users where id ='" + email_id + "'&& password ='" + email_pw +"'";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						
						boolean sqlSuccess = false;
						
						if(rs.next()) {
							
							sql = 
									"update users set app_id = ? , app_pw = ? " 
											+ "where id = ? && password = ?"; // 등록 쿼리
							
							PreparedStatement sptmt =
									con.prepareStatement(sql);
							sptmt.setString(1, id);
							sptmt.setString(2, password);
							sptmt.setString(3, email_id);             
							sptmt.setString(4, email_pw);			 
							sptmt.executeUpdate();
							// 결과처리
							
							sql = 
									"delete from users where app_id = ? && app_pw = ? " 
											+ "&& password is null"; // 등록 쿼리
							
							PreparedStatement sptmt2 =
									con.prepareStatement(sql);
							sptmt2.setString(1, id);
							sptmt2.setString(2, password);			 
							sptmt2.executeUpdate();
									
							sqlSuccess = true;
							pw.println(sqlSuccess);
							pw.flush();
							
						} else {
							pw.println(sqlSuccess);
							pw.flush();
						}
						
					} catch ( Exception e ) {
						System.out.println(e);
						try { 
							boolean sqlSuccess = false;
							pw.println(sqlSuccess);
							pw.flush();
						} catch ( Exception e2 ) {
							System.out.println(e2);
						}
					}
					
					break;
					
			}
			//1.회원가입처리
			//2.로그인처리
			

			// correctInfo를 client에 전송
			//oos.writeObject(correctInfo);
			//oos.flush();
						
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				
				oos.close();
				pw.close();
				os.close();
				localSocket.close();
			} catch ( Exception e) {
				System.out.println(e);
			}
		}
	}

}
