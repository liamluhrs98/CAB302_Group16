package delivery;

public class ordinaryTruck extends truck {
	public double oCost;
	public int orCapacity = 1000;
	private String item;
	public String name;
	private int quantity;
	private int totalQuantity;

	public ordinaryTruck(String name, String item, int quantity) {
		super("ordinary", name);
		this.name = name;
		this.item = item;
		this.quantity = quantity;
		this.totalQuantity += quantity;
	}
	
	public int getCapacityOrd() {
		return orCapacity;
	}
	
	public double getCostOrd() {
		oCost = 750 + (0.25 * totalQuantity); 
		return oCost;
	}
	
}
