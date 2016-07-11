package network;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {

	public static void main(String[] args) {

		//=============================== 서버는 클라이언트와 스레드를 이어주는 역할만 하고
		//=============================== 나머지 모든 일은 스레드 안에서 해결
		
		System.out.println("프로그램 시작");
		
		Socket recieveSocket = null;               // 소켓접속 받는 소켓
				
		try {
			ServerSocket server = new ServerSocket(5000); // 서버 소켓을 찾기위한 port 번호 부여
                                                          // 0~1023번 까지는 이미 예약되어 있다.
		
			while(true) {
				
			recieveSocket = server.accept();              // 소켓접속이 들어올 때 까지 대기. block.
			
			ThreadThread toClient = new ThreadThread(recieveSocket); // 들어온 소켓을 넘겨준다.
			Thread t = new Thread(toClient);
			
			t.start();
			
			}
						
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				recieveSocket.close();
			
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
