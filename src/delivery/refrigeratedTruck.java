package delivery;

/** 
 * 
 * @author harry
 *
 */

public class refrigeratedTruck extends truck {
	public double rCost;
	public int reCapacity = 800;
	public String name;
	private int lowestTemp = 2;
	
	public refrigeratedTruck(String name, order order) {
		super("refrigerated", name);
		this.name = name;
	}
		
	public int getCapacityRe() {
		return reCapacity;
	}
	
	public double getCostRe(int lowestTemp) {
		rCost = 900 + 200 * Math.pow(0.7,(lowestTemp/5));
		return rCost;
	}

}
