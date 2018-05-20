package delivery;

public class ordinaryTruck extends truck {
	public double oCost;
	private String item;
	private int quantity;
	private int totalQuantity;

	public ordinaryTruck(String item, int quantity) {
		super("ordinary");
		this.item = item;
		this.quantity = quantity;
		this.totalQuantity += quantity;
	}
	
	public int getCapacity() {
		return 1000;
	}
	
	public double getCost() {
		oCost = 750 + (0.25 * totalQuantity); 
		return oCost;
	}
	
}
