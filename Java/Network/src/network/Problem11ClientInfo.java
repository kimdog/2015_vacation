package network;

import java.io.PrintWriter;

public class Problem11ClientInfo {
	
	// 등록할 아이디와 주소
	
	String name;
	PrintWriter pw;
	

	public Problem11ClientInfo(String name, PrintWriter pw) {
		super();
		this.name = name;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public PrintWriter getPw() {
		return pw;
	}


}
