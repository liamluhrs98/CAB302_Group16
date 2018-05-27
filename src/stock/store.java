package stock;

import java.util.*;

//Java program implementing Singleton class
//with method name as that of class
class store
{
// static variable single_instance of type Singleton
private static store single_instance=null;

// variable of type String
public static double capital = 100000;
public static String store_name = "SuperMart";

public static HashMap<String, Integer> inventory = new HashMap<String, Integer>();


 
// private constructor restricted to this class itself
private store(double capital, stock inventory, String store_name)
{
	inventory = stockMain.quantities;
}

public static void UpdateInventory() {
    HashMap<String, Integer> temp = stock.getHashMap();
    inventory = temp;
}


// static method to create instance of Singleton class
public static store store()
 {
     // To ensure only one instance is created
     if (single_instance == null)
     {
         single_instance = new store(capital, stockMain.quantities, store_name);
     }
     return single_instance;
 }
}