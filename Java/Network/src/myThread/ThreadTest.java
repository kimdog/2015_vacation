package myThread;

public class ThreadTest {

	public static void main(String[] args) {
		
		//============================================================= 상속
		/*

		MyThread a1 = new MyThread("홍길동");
		MyThread a2 = new MyThread("김길동");
		MyThread a3 = new MyThread("최길동");
		
		a1.start(); // run을 직접적으로 호출안함. start는 thread가 runnable 상태로 전이(=스케쥴러에게 실행요청). 
		            // 실제로 thread 스케쥴러가 (언젠가는)실행 -> **생각한 것과 다른 시기에 실행될 수 있다.
		
		a2.start();
		a3.start(); // 한 thread가 실행 도중에도 다른 thread로 넘어갈 수 있다.
		*/ 
		
		//============================================================= 상속 끝
		//============================================================= interface
		
		MyRunnable r1 = new MyRunnable("홍길동");
		MyRunnable r2 = new MyRunnable("김길동");
		MyRunnable r3 = new MyRunnable("최길동");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		
		t1.start();
		t2.start();
		t3.start();
		
		//============================================================= interface 끝	
		
		System.out.println("main thread 종료!");

	}

}
