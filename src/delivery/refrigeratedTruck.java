package delivery;

public class refrigeratedTruck extends truck {

	private String item;
	private int quantity;
	
	public refrigeratedTruck(String item, int quantity) {
		// TODO Auto-generated constructor stub
		super("refrigerated");
	}
	
	public int getCapacity() {
		return 800;
	}
	
	public int getCost() {
		return 0;
	}

}
