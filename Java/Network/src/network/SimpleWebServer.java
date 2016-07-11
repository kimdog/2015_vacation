package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {

	public static void main(String[] args) {
		
		// 웹에서는 http://localhost:5000 으로 요청
		// 첫줄의 GET 옆에 요청된 문장이 들어온다
		
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("웹서버 기동");
			
			s = server.accept();

			br = 
					new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}

			pw = new PrintWriter(s.getOutputStream());
			pw.println("이것은 소리없는 아우성.."); 
			// 규약에 맞춰 보내지 않았기 때문에 안된다.
			// 따라서 http 규약을 보자
			pw.flush();
			
		} catch( Exception e ) {
			System.out.println(e);
		} finally {
			try {
				pw.close();
				br.close();
				s.close();
			} catch( Exception e ) {
				System.out.println(e);
			}
		}

	}

}
