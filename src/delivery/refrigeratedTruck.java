package delivery;

public class refrigeratedTruck extends truck {
	public double rCost;
	private String item;
	private int quantity;
	private int lowestTemp = 2;
	
	public refrigeratedTruck(String item, int quantity, int temp) {
		super("refrigerated");
		this.item = item;
		this.quantity = quantity;
		if (temp < this.lowestTemp) {
			this.lowestTemp = temp;
		}
	}
	
	public int getCapacity() {
		return 800;
	}
	
	public double getCost() {
		rCost = 900 + 200 * Math.pow(0.7,(lowestTemp/5));
		return rCost;
	}

}
