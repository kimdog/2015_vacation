package myThread;

public class WhileThreadTest {

	public static void main(String[] args) {

		WhileThread whileThread =
				new WhileThread();
		Thread t = new Thread(whileThread);

		/*
		
		//================================================== 2초 후 interrupt 걸어준다.
		t.start();

		try {
			Thread.sleep(2000);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		t.interrupt();

		//=================================================
		 
		 */
		
		//================================================= Daemon thread
		
		t.setDaemon(true); // main thread가 죽고나서 해당 thread가 죽게끔 요청한다.
		t.start();
		
		try {
			Thread.sleep(2000);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		//=================================================
		
		
		System.out.println("main thread 종료!");

		
	}

}
