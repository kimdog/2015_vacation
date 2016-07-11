package network;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class Problem11Write implements Problem11Interface {

	private static Problem11Write write = new Problem11Write();
	//private ArrayList<chatClientInfo> list = new ArrayList<ChatCLientiNFO>
	private ArrayList<Problem11ClientInfo> InfoList = new ArrayList<Problem11ClientInfo>(); 
	
	
	private Problem11Write() {
		
	}
	
	public static Problem11Write getInstance() {
		if( write == null ) {
			synchronized ( Problem11Write.class ) {
				write = new Problem11Write();
			}
		}
	    return write;
	}
	
	// 등록은 넘겨받은 각 클라이언트와 붙어있는 서버쪽 소켓에서 한다
	@Override
	public synchronized void join(String name, PrintWriter pw) {

		InfoList.add(new Problem11ClientInfo(name,pw));
		
	}
	
	//========== 이름, 내용, pwrintwriter를 넘겨주면 쓴다/
	public synchronized void write(String name, 
			String sentence, PrintWriter pw) { 
		
		String chat = name + " : " + sentence;
		
		try {
			
			for (int i = 0; i < InfoList.size(); i++) {
			
				InfoList.get(i).pw.println(chat);
				InfoList.get(i).pw.flush();
			}	
		
		} catch( Exception e ) {
			System.out.println(e + " :Write");
		} 
	}

	
}
