package solution1;

public class FamilyThread implements Runnable {
	
	private FamilyBathroom room;
	private String name;
	
	public FamilyThread(FamilyBathroom room, String name) {
		super();
		this.room = room;
		this.name = name;
	}

	@Override
	public void run() {

		room.use(name);
	}


	

}
