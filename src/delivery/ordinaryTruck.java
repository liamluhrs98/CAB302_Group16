package delivery;

public class ordinaryTruck extends truck {
	
	private String item;
	private int quantity;

	public ordinaryTruck(String item, int quantity) {
		// TODO Auto-generated constructor stub
		super("ordinary");
	}
	
	public int getCapacity() {
		return 1000;
	}
	
	public int getCost() {
		return 0;
	}
	
}
