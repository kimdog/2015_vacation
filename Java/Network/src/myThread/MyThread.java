package myThread;

public class MyThread extends Thread {
	// 하나의 독립적이 실행흐름
	
	private String name;
	
	public MyThread(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(name + " : " + i);
		}
	}
	
	
	

}
