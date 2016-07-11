package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			Socket s = new Socket("127.0.0.1",5000);   // ip 127.0.0.1 port 5000 에 연결
			is = s.getInputStream();                        // 인풋스트림 생성
			isr = new InputStreamReader(is);                // 스트림리더연결
			br = new BufferedReader(isr);                   // 버퍼리더 연결
			String result = br.readLine();                  // 버퍼에서 읽는다
			
			System.out.println(result);
			
		} catch ( Exception e ) {
			System.out.println(e);
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
				
			} catch( Exception e ) {
				System.out.println(e);
			}
		}
			
		

	}

}
