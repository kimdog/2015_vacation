package network;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestServer {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		// finally에서 close하기 위해 미리 선언
		Socket s = null;
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			ServerSocket server = new ServerSocket(5000); // 서버 소켓을 찾기위한 port 번호 부여
                                                          // 0~1023번 까지는 이미 예약되어 있다.
			
			s = server.accept();                   // 소켓접속이 들어올 때 까지 대기. block.
			
			os = s.getOutputStream();        // 아웃풋 스트림 생성
			pw = new PrintWriter(os);         // 적기위한 printWriter
			
			
			// SimpleDateFormat을 이용한 현재시간 구하기
			String time = 
					new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // (날짜)형태 정하기
			
			pw.println(time);    // 내장 버퍼를 가지고 있다 -> flush를 해주어야 비로소 data가 전송
			pw.flush();          // 버퍼에 있는 데이터를 보내고 버퍼를 비운다
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pw.close();
				os.close();
				s.close();
			} catch ( Exception e) {
				System.out.println(e);
			}
		}


	}

}
