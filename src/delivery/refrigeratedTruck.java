package delivery;

public class refrigeratedTruck extends truck {
	public double rCost;
	public int reCapacity = 800;
	public String name;
	private String item;
	private int quantity;
	private int lowestTemp = 2;
	
	public refrigeratedTruck(String name, String item, int quantity, int temp) {
		super("refrigerated", name);
		this.name = name;
		this.item = item;
		this.quantity = quantity;
		if (temp < this.lowestTemp) {
			this.lowestTemp = temp;
		}
	}
	
	public int getCapacityRe() {
		return reCapacity;
	}
	
	public double getCostRe() {
		rCost = 900 + 200 * Math.pow(0.7,(lowestTemp/5));
		return rCost;
	}

}
