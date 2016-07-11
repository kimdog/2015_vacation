package myThread;

public class WhileThread implements Runnable {
	
	@Override
	public void run() {

		int i = 0;
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("현재 i값은 : " + i++);
		}
	}

}
