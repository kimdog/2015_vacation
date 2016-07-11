package network;

import java.io.PrintWriter;
import java.net.Socket;

public interface Problem11Interface {
	
	// 브로드캐스트 하는 것을 array에 넣어서 만들면 쉽다.	
	
	public void write(String name, String sentence, PrintWriter printw);
	
	// 공용자원안에 클라이언트 정보와 자료구조가 모두 있어야한다.
	// 쓰레드들은 공용자원 속 메소드를 공유하게 된다 -> synchronized
	
	public void join(String name, PrintWriter pw); // 입장
	
}
