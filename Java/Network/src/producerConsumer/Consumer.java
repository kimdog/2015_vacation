package producerConsumer;

public class Consumer implements Runnable {

	private MyQueue queue = null;
	private String name;

	
	public Consumer(MyQueue queue, String name) {
		super();
		this.queue = queue;
		this.name = name;
	}


	@Override
	public void run() {
		System.out.println(name + " : Consumer 시작");
		try {
			while(!Thread.currentThread().isInterrupted()){
				int k = (Integer)queue.pop(); 
				// pop이 null로 넘어와서 integer로 바꾸는 과정에서 NULL pointer exception 발생.
				System.out.println(name + " : " + k);
			}
		} catch( Exception e) {
			System.out.println(e);
		} finally {
			System.out.println(name + " Consumer 종료");
		}
	}
	
	

}
