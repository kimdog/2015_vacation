package producerConsumer;

public class Singleton {
	
	private static Singleton singLeton = new Singleton();
	
	private Singleton() {
		System.out.println("Singleton 객체 생성");
	}

	// private로 외부에서 접근 못하게 한다.
	
	public static Singleton getInstance() {
		return singLeton;
	}

}
