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
			
						
			//1.회원가입처리
			//2.로그인처리
			
			//Client가 보내온 id, password를 읽어들임
			String id = br.readLine();
			String password = br.readLine();
			
			String sql = "select * from users where id ='" + id +"'"; // table 명 : users
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 결과처리
			if(rs.next()) {
				String tempName = rs.getString("name");
				String tempEmail = rs.getString("email");
				String tempPhoneNum = rs.getString("phoneNum");
				String tempId = rs.getString("id");
				String tempPw = rs.getString("password");

				correctInfo = new userInfo(tempName, tempEmail, tempPhoneNum, tempId, tempPw);
			}
			else {
				System.out.println("일치된 id가 없다 .");
			}
			
			// correctInfo를 client에 전송
			oos.writeObject(correctInfo);
			oos.flush();
						
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
