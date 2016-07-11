package securityJect1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class procForClient {

	public static void main(String[] args) {

		//***Client는 ThreadRead 쓰레드를 포함하고 있다.
		//***Client 이름 정보는 여기 없다.
		
		System.out.println("프로그램 시작");
		
		Socket s = null;
		OutputStream os = null;          // 내보내기 위한 아웃풋스트림
		PrintWriter pw = null;           // 아웃풋스트림에서 쓰기 ( 버퍼로 )
		
		InputStream is = null;           // 받기위한 인풋스트림
		InputStreamReader isr = null;    // 인풋스트림 읽기
		BufferedReader br = null;        // 버퍼에서 읽기
		
		ObjectInputStream ois = null;		// object input.
		
		
		InputStreamReader inisr = null;  // 내부 인풋스트림 리더 
		BufferedReader inbr = null;      // 내부 버퍼
		
		String id;			// 화면에 보여지는 id
		String password;	// 			password
		
		
		
		// 안드로이드로 옮기기전 처리
		Scanner input = new Scanner(System.in);		
		
			
		
		try {
			s = new Socket("127.0.0.1",5000);   // ip 127.0.0.1 port 5000 에 연결
			
			//======================= 받아들이는 것 생성
			is = s.getInputStream();                        // 인풋스트림 생성
			isr = new InputStreamReader(is);                // 스트림리더연결
			br = new BufferedReader(isr);                   // 버퍼리더 연결
			
			ois = new ObjectInputStream(is);				// object
			
			//======================= 내보내는 것 생성
			os = s.getOutputStream();                      // 아웃풋 스트림 생성
			pw = new PrintWriter(os);                      // 적기위한 printWriter
			
			//======================= 내부 인풋스트림
						
			System.out.print("id : ");
			id = input.next();
			// id 오류 처리할 것
			
			System.out.print("pw : ");
			password = input.next();
			// pw 오류 처리할 것
			
			// 로그인 버튼 클릭	
			// --> 로그인 처리 클래스
			// --> 받아오는 것 = userInfo.
			userInfo myInfo = loginForClient(id,password,br,pw,ois);
					
			
			//------------------------------------------------------
			System.out.println(myInfo.getName() + "\t" +
					myInfo.getEmail() + "\t"
					+ myInfo.getPhoneNum()); // 확인
			
			System.out.println("프로그램 종료");
			
		} catch ( Exception e ) {
			System.out.println(e + " :Client");
		} finally {
			try {
				ois.close();
				br.close();
				isr.close();
				is.close();
				
				pw.close();
				os.close();				
				s.close();
			} catch( Exception e ) {
				System.out.println(e + " :Client");
			}
		}
			
	}

	private static userInfo loginForClient(String id, String password, BufferedReader br, PrintWriter pw, ObjectInputStream ois) {
		
		// id와 password 전송
		try {
		pw.println(id);
		pw.flush();
		pw.println(password);
		pw.flush();
		
		userInfo tempInfo = (userInfo)ois.readObject();
		
		return tempInfo;
		
		} catch ( Exception e ) {
			System.out.println("로그인 실패");
			return null;
		}		
	}
}
