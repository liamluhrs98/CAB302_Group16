package delivery;

/**
 * 
 * @author harry
 *
 */

public class ordinaryTruck extends truck {
	public int orCapacity = 1000;
	private String name;
	private String[] itemNames;
	private int[] itemAmounts;

	public ordinaryTruck(String name, String[] itemNames, int[] itemAmounts) {
		super("ordinary", name);
		this.name = name;
		this.itemNames = itemNames;
		this.itemAmounts = itemAmounts;
	}
	
	public String getOrdTruckName() {
		return name;
	}
	
	public String[] getItemNames() {
		return itemNames;
	}
	
	public int[] getItemAmounts() {
		return itemAmounts;
	}
	
	public int getCapacityOrd() {
		return orCapacity;
	}
	
	public static double getCostOrd(int totalQuantity) {
		double oCost = 750 + (0.25 * totalQuantity); 
		return oCost;
	}
	
}
