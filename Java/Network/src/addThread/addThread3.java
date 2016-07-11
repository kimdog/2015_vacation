package addThread;

public class addThread3 implements Runnable {
	
	private int startNum;
	private int endNum;
	private int sum;
	
	public int getSum() {
		return sum;
	}

	public addThread3(int startNum, int endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public void run() {
		sum = 0;
		for(int i=startNum; i<=endNum; i++) {
			sum += i;
		}			
	}
}
