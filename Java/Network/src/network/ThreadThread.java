package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadThread implements Runnable {


	//private String name;          // 하나의 소켓 이름
	private Socket localSocket;  // 서버에서 이어줄 소켓을 넘겨 받는다
	
	public ThreadThread(Socket localSocket) {
		super();
		//this.name = name;
		this.localSocket = localSocket;
	}

	@Override
	public void run() {
		
		// finally에서 close하기 위해 미리 선언

		OutputStream os = null;
		PrintWriter pw = null;
		
		InputStream is = null;           // 받기위한 인풋스트림
		InputStreamReader isr = null;    // 인풋스트림 읽기
		BufferedReader br = null;        // 버퍼에서 읽기
		
		try {
			
			//======================= 연결될 소켓을 넘겨 받고 시작한다

			//======================= 받아들이는 것 생성
			is = localSocket.getInputStream();              // 인풋스트림 생성
			isr = new InputStreamReader(is);                // 스트림리더연결
			br = new BufferedReader(isr);                   // 버퍼리더 연결
			
			//======================= 내보내는 것 생성
			os = localSocket.getOutputStream();            // 아웃풋 스트림 생성
			pw = new PrintWriter(os);                      // 적기위한 printWriter
			
			String Echo = "";       // 서버가 클라이언트로 부터 받아들일 문장
			
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
				localSocket.close();
			} catch ( Exception e) {
				System.out.println(e);
			}
		}
	
	
	}
	
}
