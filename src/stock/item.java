package stock;

public class item {
	
	//Set up object
	private String name; 		//Item name
	private int manu_cost;		//Manufacturing cost of item
	private int ret_price;		//Retail price of item
	private int reord_point;	//Reordering point of item
	private int reord_amt;		//Quantity to reorder of item, once reorder point is reached
	private String temp;			//Temperature to store item at
	
	//Construct item object with variables
	public item(String name, int manu_cost, int ret_price, int reord_point, int reord_amt, String temp) {
		this.name = name;
		this.manu_cost = manu_cost;
		this.ret_price = ret_price;
		this.reord_point = reord_point;
		this.reord_amt = reord_amt;
		this.temp = temp;
		
	}
	
	public String getItemName() {
		return this.name;
	}
	
	public int getItemManuCost() {
		return this.manu_cost;
	}
	
	public int getItemRetPrice() {
		return this.ret_price;
	}
	
	public int getItemReordPoint() {
		return this.reord_point;
	}
	
	public int getItemReordAmt() {
		return this.reord_amt;
	}
	
	public String getItemTemp() {
		return this.temp;
	}
	
	
	
}
