package stock;

import java.util.*;

public class stock {
	
	private String itemName;
	private int itemQuantity;
	
	public stock(String itemName, int itemQuantity) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}
	
	public String getStockItemName() {
		return this.itemName;
	}
	
	public int getStockItemQuantity() {
		return this.itemQuantity;
	}
	
	
	
}
