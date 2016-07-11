package producerConsumer;

public interface Queue {
	// method의 선언
	public void put(Object obj);
	public Object pop();
	public int size();      // Queue 의 size를 return
	public void clear();    // Queue 안의 내용을 비운다
	
	/*
	 * public String getName();
	 * public void clear();
	 * public void put(Object obj);
	 * public Object pop() throws InterruptedException;
	 * public int size();
	 */
	
	/* public class PrinterQueue implements Queue {
	 * 
	 * private static final String NAME = "Printer Queue";
	 * private static final Object monitor = new Object();
	 * 
	 * private LinkedList jobs = new LinkedList();
	 * private static PrinterQueue queue = new PrinterQueue();
	 * 
	 * public static PrinterQueue getInstance() {
	 *    if( queue == null) {
	 *       synchronized (PrinterQueue.class) {
	 *           queue = new PrinterQueue();
	 *           }
	 *    }
	 *    return queue;
	 * }
	 */

}
