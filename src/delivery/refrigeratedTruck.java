package delivery;

import java.util.ArrayList;

/** 
 * 
 * @author harry
 *
 */

public class refrigeratedTruck extends truck {
	
	public refrigeratedTruck(String name, ArrayList<String> items, ArrayList<Integer> itemAmounts) {
		super("refrigerated", items, itemAmounts);
	}

}
