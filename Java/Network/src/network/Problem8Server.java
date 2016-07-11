package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Problem8Server {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
				
		Socket s = null;                 // 소켓
		OutputStream os = null;          // 내보내기 위한 아웃풋스트림
		PrintWriter pw = null;           // 아웃풋스트림에서 쓰기 ( 버퍼로 )
		
		InputStream is = null;           // 받기위한 인풋스트림
		InputStreamReader isr = null;    // 인풋스트림 읽기
		BufferedReader br = null;        // 버퍼에서 읽기
		
		try {
			ServerSocket server = new ServerSocket(5000); // 서버 소켓을 찾기위한 port 번호 부여
                                                          // 0~1023번 까지는 이미 예약되어 있다.
			
			s = server.accept();                   // 소켓접속이 들어올 때 까지 대기. block.
			
			//======================= 받아들이는 것 생성
			is = s.getInputStream();                        // 인풋스트림 생성
			isr = new InputStreamReader(is);                // 스트림리더연결
			br = new BufferedReader(isr);                   // 버퍼리더 연결
			
			//======================= 내보내는 것 생성
			os = s.getOutputStream();                      // 아웃풋 스트림 생성
			pw = new PrintWriter(os);                      // 적기위한 printWriter
			
			String Echo = "";            // 서버가 클라이언트로 부터 받아들일 문장
			
			//======================= 반복문 시작
			while(!Echo.equals("/exit")) {
			//======================= 읽어들이기 
			Echo = br.readLine();
			//======================= 보내기
			pw.println(Echo);       // 내장 버퍼를 가지고 있다 -> flush를 해주어야 비로소 data가 전송
			pw.flush();             // 버퍼에 있는 데이터를 보내고 버퍼를 비운다
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				
				pw.close();
				os.close();
				s.close();
			} catch ( Exception e) {
				System.out.println(e);
			}
		}


	}

}
