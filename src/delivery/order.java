package delivery;

import java.util.ArrayList;

/**
 * 
 * @author Harrison Perkins
 *
 */

public class order {
	public ArrayList<String> names;
	public ArrayList<Integer> amount;
	
	public order(ArrayList<String> names, ArrayList<Integer> amount) {
		this.names = names;
		this.amount = amount;
	}
	
	public ArrayList<String> getName() {
		return names;
	}
	
	public ArrayList<Integer> getAmount() {
		return amount;
	}
}
