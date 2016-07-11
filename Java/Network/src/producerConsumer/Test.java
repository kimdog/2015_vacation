package producerConsumer;

public class Test {

	public static void main(String[] args) {
		
		MyQueue queue = MyQueue.getInstance();
		Consumer c1 = new Consumer(queue, "Con 1");
		Consumer c2 = new Consumer(queue, "Con 2");
		Consumer c3 = new Consumer(queue, "Con 3");
		
		Thread ct1 = new Thread(c1);
		Thread ct2 = new Thread(c2);
		Thread ct3 = new Thread(c3);
		
		ct1.start();
		ct2.start();
		ct3.start();
		
		Producer p = new Producer(queue);
		Thread pt = new Thread(p);
		pt.start();
		
		try{
			Thread.sleep(2);
			pt.interrupt();
			Thread.sleep(2);
			ct1.interrupt();
			ct2.interrupt();
			ct3.interrupt();
			
		} catch( Exception e ) {
			System.out.println(e);
		}

	}

}
