package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Problem11ThreadWrite implements Runnable {

	//========== 서버쪽의 쓰레드로
	//========== 각 클라이언트에 대해 받은 메세지를 그대로 모두에게 넘겨준다
	
	private String name;          // 클라이언트 이름은 넘겨받아서 여기에 있다.
	private Socket localSocket;   // 서버에서 이어줄 소켓을 넘겨 받는다
	
	//========== 동기화 write
	private Problem11Write write = null;
	
	public Problem11ThreadWrite(String name, Socket localSocket, Problem11Write write) {
		super();
		this.name = name;
		this.localSocket = localSocket;
		this.write = write;
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
			is = localSocket.getInputStream();             // 인풋스트림 생성
			isr = new InputStreamReader(is);               // 스트림리더연결
			br = new BufferedReader(isr);                  // 버퍼리더 연결
			
			//======================= 내보내는 것 생성
			os = localSocket.getOutputStream();            // 아웃풋 스트림 생성
			pw = new PrintWriter(os);                      // 적기위한 printWriter
			
			//======================= 공유하는 clientList에 등록시킴
			write.join(name, pw);
			
			
			String sentence = "";                          // 서버가 클라이언트로 부터 받아들일 문장
			
			
			//======================= 클라이언트 입장 알림
			pw.println(name + " 가 입장하셨습니다. 나가려면 /exit"); 
			pw.flush();
			
			
			//======================= 반복문 시작
			while(!sentence.equals("/exit")) {
			//======================= 읽어들이기 
			sentence = br.readLine();
			//======================= 보내기
			/*
			pw.println(name + " : " + sentence);           // 채팅창에 보이는 대화
			pw.flush();
			*/ 
			// 공용자원을 대신 사용
			
			write.write(name, sentence, pw); 
			
			}
			
			pw.println(name + " 가 퇴장하셨습니다.");
			pw.flush();
			
		} catch (Exception e) {
			System.out.println(e + " :ThreadWrite");
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				
				pw.close();
				os.close();
				localSocket.close();
			} catch ( Exception e) {
				System.out.println(e + " :ThreadWrite");
			}
		}
	}
}
