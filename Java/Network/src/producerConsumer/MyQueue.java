package producerConsumer;

import java.util.LinkedList;

public class MyQueue implements Queue{

	private static Object monitor = new Object(); // monitor
	private LinkedList jobs = new LinkedList();   // 자료가 들어갈 리스트
	private static MyQueue queue = new MyQueue(); // 자기 자신에 대한 instance. 외부접근 못함
	                                              // singleton 패턴.
	private MyQueue() {
		
	}
	
	public static MyQueue getInstance() {
		// queue가 없으면 새로 생성
		if( queue == null) {
			synchronized (MyQueue.class) {
				queue = new MyQueue();
			}
		}
		// queue가 있으면 그대로 return
		return queue;
	}
	//================================================= 여기까지 singleton패턴
	
	@Override
	public void clear() {
		jobs.clear();
	}

	@Override
	public void put(Object obj) {
		// synchronized 블럭 사용.
		synchronized (monitor) {
			jobs.addLast(obj);
			monitor.notify(); // wait 하는 것에 notify 해준다.
		}
		jobs.addLast(obj);
	}

	@Override
	public Object pop() {
		Object obj = null;
		synchronized (monitor) {
			if(jobs.isEmpty()) {
				// 아무것도 안하고 빠져 나가야한다.
				try {
					monitor.wait();
				} catch( Exception e ) {
					System.out.println(e);
				}
			}
		}
		
		obj = jobs.removeFirst();
		
		return obj;
	}

	@Override
	public int size() {
		return jobs.size();
	}
	
	

}
