package network;

import java.io.BufferedReader;


public class Problem11ThreadRead implements Runnable {
	
	// Client 쪽에 있어야 하며 읽는 기능만 존재

	private BufferedReader br;            // 넘겨받는 버퍼
	
	
	public Problem11ThreadRead(BufferedReader br) {
		super();
		this.br = br;
	}


	@Override
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				
			String result = br.readLine();    // 넘겨 받는 버퍼 그대로 읽는다			
			System.out.println(result);       // 넘긴 사람 이름 + 말이 모두 포함됨.
			
			}
		} catch ( Exception e ) {
			System.out.println(e + " :ThreadRead");
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println(e + " :ThreadRead");
			}
		}
	}

}
