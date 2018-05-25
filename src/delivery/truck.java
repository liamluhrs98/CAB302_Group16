package delivery;

import java.util.ArrayList;

/**
 * 
 * @author harry
 *
 */

public abstract class truck {
	
	private String type;
	private ArrayList<String> items;
	private ArrayList<Integer> itemAmounts;
	private int orCapacity = 1000;
	private int reCapacity = 800;
	
	public truck(String type, ArrayList<String> items, ArrayList<Integer> itemAmounts) {
		this.type = type;
		this.items = items;
		this.itemAmounts = itemAmounts;
	}
	
	public ArrayList<String> getItemNames() {
		return items;
	}
	
	public ArrayList<Integer> getItemAmounts() {
		return itemAmounts;
	}
	
	public int getCapacity() {
		if (type == "ordinary") {
			return orCapacity;
		} else if (type == "refrigerated") {
			return reCapacity;
		} else
			return 0;
	}
	
	public static double getCostOrd(int totalQuantity) {
		double oCost = 750 + (0.25 * totalQuantity); 
		return oCost;
	}
	
	public static double getCostRe(int lowestTemp) {
		double rCost = 900 + 200 * Math.pow(0.7,(lowestTemp/5));
		return rCost;
	}
}
