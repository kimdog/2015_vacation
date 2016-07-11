package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Problem8Client {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		Socket s = null;
		OutputStream os = null;          // 내보내기 위한 아웃풋스트림
		PrintWriter pw = null;           // 아웃풋스트림에서 쓰기 ( 버퍼로 )
		
		InputStream is = null;           // 받기위한 인풋스트림
		InputStreamReader isr = null;    // 인풋스트림 읽기
		BufferedReader br = null;        // 버퍼에서 읽기
		
		
		InputStreamReader inisr = null;  // 내부 인풋스트림 리더 
		BufferedReader inbr = null;      // 내부 버퍼
		
		
		try {
			s = new Socket("127.0.0.1",5000);   // ip 127.0.0.1 port 5000 에 연결
			
			//======================= 받아들이는 것 생성
			is = s.getInputStream();                        // 인풋스트림 생성
			isr = new InputStreamReader(is);                // 스트림리더연결
			br = new BufferedReader(isr);                   // 버퍼리더 연결
			
			//======================= 내보내는 것 생성
			os = s.getOutputStream();                      // 아웃풋 스트림 생성
			pw = new PrintWriter(os);                      // 적기위한 printWriter
			
			//======================= 내부 인풋스트림
				
			System.out.println("Echo 시킬 문자 적으세요. 나가려면 /exit 입력");
			
			String sentence = ""; // 보낼 문장
			
			//======================= 반복문 시작
			while(!sentence.equals("/exit")) {
			inisr = new InputStreamReader(System.in);
			inbr = new BufferedReader(inisr);
	
			sentence = inbr.readLine();
			
			System.out.println("입력 성공 : " + sentence );
			
			//======================= 내보내기
			
			pw.println(sentence);
			pw.flush();
			
			//======================= 에코가 돌아오면 읽고 쓰기
			
			String result = br.readLine();                  // 버퍼에서 읽는다
			
			System.out.print("돌아온 에코 : ");
			System.out.println(result);
			}
			
			System.out.println("프로그램 종료");
			
		} catch ( Exception e ) {
			System.out.println(e);
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				
				pw.close();
				os.close();				
				s.close();
			} catch( Exception e ) {
				System.out.println(e);
			}
		}
			
		

	}

}
