package solution1;

public class FamilyBathroom implements Bathroom {
	
	private static Object monitor = new Object();
	
	@Override
	public void use(String name) {
		synchronized (monitor) {
			System.out.println(name + " 입장");
			System.out.println(name + " 양치");
			System.out.println(name + " 세면");
			System.out.println(name + " 퇴장");
		}
	}

}
