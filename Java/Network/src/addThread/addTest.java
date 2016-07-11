package addThread;

public class addTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 상속으로 =================================
		addThread1 add1 = new addThread1("process1");
		addThread2 add2 = new addThread2("process2");
				
		add1.start();
		add2.start();
		*/
		
		addThread3 adrun1 = new addThread3(1,10000);
		addThread3 adrun2 = new addThread3(10001,20000);
		
		Thread add1 = new Thread(adrun1);
		Thread add2 = new Thread(adrun2);
		
		add1.start();
		add2.start();
		
		//=== add1 과 add2 thread가 끝날때 까지 main thread가 기다린다.
		try { 
			add1.join();
		    add2.join();
		} catch(InterruptedException e) {
			System.out.println(e);			
		}
		//=================================================
		
		//System.out.println("sum : " + (add1.getSum() + add2.getSum()));
		System.out.println("sum : " + (adrun1.getSum() + adrun2.getSum()));
		System.out.println("main thread 종료!");
		
	}

}
