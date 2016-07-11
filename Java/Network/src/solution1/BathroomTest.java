package solution1;

public class BathroomTest {

	public static void main(String[] args) {

		FamilyBathroom room = new FamilyBathroom();
		
		FamilyThread r1 = new FamilyThread(room, "아빠");
		FamilyThread r2 = new FamilyThread(room, "엄마");
		FamilyThread r3 = new FamilyThread(room, "누나");
		FamilyThread r4 = new FamilyThread(room, "형");
		FamilyThread r5 = new FamilyThread(room, "동생");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		Thread t5 = new Thread(r5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		

	}

}
