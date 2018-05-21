package stock;

public class item {
	
	//Set up object
	private String name; 		//Item name
	private int quantity;		//Quantity of item
	private int manu_cost;		//Manufacturing cost of item
	private int ret_price;		//Retail price of item
	private int reord_point;	//Reordering point of item
	private int reord_amt;		//Quantity to reorder of item, once reorder point is reached
	private int temp;			//Temp to store item at
	
	//Construct item object with variables
	public item(String name, int quantity, int manu_cost, int ret_price, int reord_point, int reord_amt, int temp) {
		this.name = name;
		this.quantity = quantity;
		this.manu_cost = manu_cost;
		this.ret_price = ret_price;
		this.reord_point = reord_point;
		this.reord_amt = reord_amt;
		this.temp = temp;
		
	}
	
	public String getItemName() {
		return this.name;
	}
	
	
	
}
