package problem1;

public class Action implements Runnable {
	
	private int state; // 0 = 입장, 1 = 양치, 2 = 세면, 3 = 퇴장
	private String name;
	private static Object monitor = new Object();
	private static boolean isInToilet;
	
	public Action(String name) {
		super();
		this.name = name;
	}
	
	

	public int getstate() {
		return state;
	}



	@Override
	public void run() {
		state = 0;
		
		while(!Thread.currentThread().isInterrupted()) {
			synchronized (monitor) {
				if(isInToilet) {
					try {
						System.out.println(name + "은 대기 중 입니다");
						monitor.wait();
					} catch( Exception e ) {
						System.out.println(e);
					}
				}
				else {
					monitor.notify();
				}
			}
			
			switch(state) {
			case 0: System.out.println(name + "은 입장 중 입니다"); 
			        state = 1; 
			        isInToilet = true; break;
			case 1: System.out.println(name + "은 양치 중 입니다"); 
			        state = 2; break;
			case 2: System.out.println(name + "은 세면 중 입니다"); 
			        state = 3; break;
			case 3: System.out.println(name + "은 퇴장 중 입니다"); 
			        state = 0; 
			        isInToilet = false; break;
			}
		}
	}
}
