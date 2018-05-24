package delivery;

import java.util.ArrayList;

/**
 * 
 * @author harry
 *
 */

public class ordinaryTruck extends truck {
	public double oCost;
	public int orCapacity = 1000;
	private String name;
	private ArrayList<String> itemNames;
	private ArrayList<Integer> itemAmounts;

	public ordinaryTruck(String name, ArrayList<String> itemNames, ArrayList<Integer> itemAmounts) {
		super("ordinary", name);
		this.name = name;
		this.itemNames = itemNames;
		this.itemAmounts = itemAmounts;
	}
	
	public String getOrdTruckName() {
		return name;
	}
	
	public int getCapacityOrd() {
		return orCapacity;
	}
	
	public double getCostOrd(int totalQuantity) {
		oCost = 750 + (0.25 * totalQuantity); 
		return oCost;
	}
	
}
