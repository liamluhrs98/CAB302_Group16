package stock;

import java.util.*;


public class stock {
	
	private HashMap<String, Integer> stock_map;
		
	public int getQuantity(String name) {
		return stock_map.get(name);
	}
	
	public void changeAmount(stock map_name, String name, int amount) {
		map_name.stock_map.put(name, amount);
	}
	
}
