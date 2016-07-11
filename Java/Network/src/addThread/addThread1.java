package addThread;

public class addThread1 extends Thread {
	

	private String name;
	private int sum1;
	
	public addThread1(String name) {
		super();
		this.name = name;
	}
	
	public int getSum() {
		return sum1;
	}
	
	@Override
	public void run() {
		sum1 = 0;
		for(int i=0; i<10000; i++) {
			System.out.println(name + " : " + i+1);
			sum1 += (i+1); 
		}
	}
	

}
