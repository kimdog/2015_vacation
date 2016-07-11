package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

	public static void main(String[] args) {

		DatagramSocket socket = null;
		
		try {
			System.out.println("서버 접속 대기 상태입니다");
			socket = new DatagramSocket(5000);
			String line = null;
			while(true) {
				byte[] buffer = new byte[512];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);   // 접속대기
				String msg =
						new String(packet.getData(),0,packet.getData().length).trim();
				System.out.println("전송받은 문자열 : " + msg);
				if(msg.equals("exit")) break;
				
				DatagramPacket sendPacket = new DatagramPacket(
						packet.getData(),
						packet.getData().length,
						packet.getAddress(),
						packet.getPort()
						);
				socket.send(sendPacket);
			}
			System.out.println("UDP 서버 종료");
		} catch( Exception e ) {
			System.out.println(e + " UDPServer");
		}

	}

}
