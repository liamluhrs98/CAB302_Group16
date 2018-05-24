package delivery;

import java.util.ArrayList;

/** 
 * 
 * @author harry
 *
 */

public class refrigeratedTruck extends truck {
	public double rCost;
	public int reCapacity = 800;
	public String name;
	private ArrayList<String> itemNames;
	private ArrayList<Integer> itemAmounts;
	private int lowestTemp = 2;
	
	public refrigeratedTruck(String name, ArrayList<String> itemNames, ArrayList<Integer> itemAmounts) {
		super("refrigerated", name);
		this.name = name;
		this.itemNames = itemNames;
		this.itemAmounts = itemAmounts;
	}
	
	public String getReTruckName() {
		return name;
	}
		
	public int getCapacityRe() {
		return reCapacity;
	}
	
	public double getCostRe(int lowestTemp) {
		rCost = 900 + 200 * Math.pow(0.7,(lowestTemp/5));
		return rCost;
	}

}
