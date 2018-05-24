package delivery;

/**
 * 
 * @author harry
 *
 */

public class order {
	public String name;
	public int amount;
	
	public order(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAmount() {
		return amount;
	}
}
