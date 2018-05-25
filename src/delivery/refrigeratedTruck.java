package delivery;

/** 
 * 
 * @author harry
 *
 */

public class refrigeratedTruck extends truck {
	public int reCapacity = 800;
	public String name;
	private String[] itemNames;
	private int[] itemAmounts;
	
	public refrigeratedTruck(String name, String[] itemNames, int[] itemAmounts) {
		super("refrigerated", name);
		this.name = name;
		this.itemNames = itemNames;
		this.itemAmounts = itemAmounts;
	}
	
	public String getReTruckName() {
		return name;
	}
	
	public String[] getItemNames() {
		return itemNames;
	}
	
	public int[] getItemAmounts() {
		return itemAmounts;
	}
		
	public int getCapacityRe() {
		return reCapacity;
	}
	
	public static double getCostRe(int lowestTemp) {
		double rCost = 900 + 200 * Math.pow(0.7,(lowestTemp/5));
		return rCost;
	}

}
