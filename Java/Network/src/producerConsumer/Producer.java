package producerConsumer;

public class Producer implements Runnable {

	private MyQueue queue = null;
	
	
	public Producer(MyQueue queue) {
		super();
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("Producer 시작");
		try {
			int i = 0;
			while(!Thread.currentThread().isInterrupted()){
				queue.put(i++);
			}
		} catch( Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Producer 종료");
		}
	}
	
	

}
