package delivery;

import java.util.ArrayList;

/**
 * 
 * @author Harrison Perkins
 *
 */

public class ordinaryTruck extends truck {

	public ordinaryTruck(String name, ArrayList<String> items, ArrayList<Integer> itemAmounts) {
		super("ordinary", items, itemAmounts);
	}
	
}
