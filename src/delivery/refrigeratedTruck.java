package delivery;

public class refrigeratedTruck extends truck {

	private String item;
	private int quantity;
	private int temp;
	
	public refrigeratedTruck(String item, int quantity, int temp) {
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
