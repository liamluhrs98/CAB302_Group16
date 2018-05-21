package delivery;

public class ordinaryTruck extends truck {
	public double oCost;
	public int orCapacity = 1000;
	private String name;
	private int totalQuantity;

	public ordinaryTruck(String name, order order) {
		super("ordinary", name);
		this.name = name;
	}
	
	public int getCapacityOrd() {
		return orCapacity;
	}
	
	public double getCostOrd(int totalQuantity) {
		oCost = 750 + (0.25 * totalQuantity); 
		return oCost;
	}
	
}
