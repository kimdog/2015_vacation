package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {

	public static void main(String[] args) {

		InetAddress addr = null;
		DatagramSocket socket = null;
		BufferedReader br = null;
		
		try {

			addr = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket();
			br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while((line = br.readLine()) != null) {
				
				DatagramPacket packet =
						new DatagramPacket(line.getBytes(),
								line.getBytes().length,addr,5000);
				if(line.equals("exit")) break;
				
				byte[] buffer = new byte[512];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				socket.receive(receivePacket); // 접속대기
				String msg = new String(receivePacket.getData(),0,
						receivePacket.getData().length).trim();
				
				System.out.println("서버로부터 전송받은 문자열 : " + msg);
				
				
			}
			
			System.out.println("클라이언트 종료");
	
		} catch (Exception e) {
			System.out.println(e + " :UDPClient");	
		}
	}

}
