package stock;

import java.util.*;


public class stock {
	
	static private HashMap<String, Integer> stock_map = new HashMap<String, Integer>();
		
	public static int getQuantity(String name) {
		return stock_map.get(name);
	}
	
	public static HashMap<String, Integer> getHashMap() {
		return stock_map;
	}
	
	public static void changeAmount(stock map_name, String name, int amount) {
		int currentAmount = map_name.stock_map.get(name);
		
		map_name.stock_map.put(name, currentAmount + amount);
	}
	
}
