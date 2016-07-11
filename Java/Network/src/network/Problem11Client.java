package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Problem11Client {

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
						
			String sentence = ""; // 보낼 문장
			
			//======================= 읽는 쓰레드 실행
			
			Problem11ThreadRead readr = new Problem11ThreadRead(br);
			Thread readt = new Thread(readr);
			
			readt.start();
			
			
			//======================= 반복문 시작
			while(!sentence.equals("/exit")) {
			inisr = new InputStreamReader(System.in);
			inbr = new BufferedReader(inisr);
	
			sentence = inbr.readLine();                    // 대화말
			
			//======================= 내보내기
			
			pw.println(sentence);
			pw.flush();
			
			//======================= 쓰기 끝
			//======================= 읽어주는 파트가 있어야하지만
			//======================= 따로 읽는 쓰레드가 돌 것이므로 상관없다
			
			//======================= 삭제된 읽는 part			
			/*
			String result = br.readLine();                  // 버퍼에서 읽는다
			
			System.out.print("돌아온 에코 : ");
			System.out.println(result);
			*/
			
			}
			
			readt.interrupt();
			
			System.out.println("프로그램 종료");
			
		} catch ( Exception e ) {
			System.out.println(e + " :Client");
		} finally {
			try {
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

}
