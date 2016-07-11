package addThread;

public class addThread2 extends Thread {

	private String name;
	private int sum2;
	
	public addThread2(String name) {
		super();
		this.name = name;
	}
	
	public int getSum() {
		return sum2;
	}
	
	
	@Override
	public void run() {
		sum2 = 0;
		for(int i=0; i<10000; i++) {
			System.out.println(name + " : " + i+10001);
			sum2 += (i+10001); 
		}
	}
	
}
