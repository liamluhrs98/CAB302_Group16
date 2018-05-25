package delivery;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import stock.item;

/**
 * 
 * @author harry
 *
 */


public class deliveryMain {
	
	//String ArrayList to Integer ArrayList Method
	public static int d_StringToInt(String a){
	    //ArrayList<Integer> b = new ArrayList<Integer>();
	    int b = 0;
		//for (String stringValue : a) {
	    	try {
	    		//b.add(Integer.parseInt(stringValue));
	    		b = Integer.parseInt(a);
	    	} catch(NumberFormatException nfe) {
	    		System.out.println("Could not parse " + a + " as an integer, please check CSV.");
	    	}
	    return b;
	}
	
	//Imported CSV Variables
	private static ArrayList<Integer> amountInts = new ArrayList<Integer>();
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<order> orderlist = new ArrayList<order>();
	
	//Truck Assigning Variables
	private static ArrayList<String> coldFood = new ArrayList<String>();
	private static ArrayList<Integer> coldFoodAmount = new ArrayList<Integer>();
	private static ArrayList<String> dryFood = new ArrayList<String>();
	private static ArrayList<Integer> dryFoodAmount = new ArrayList<Integer>();
	
	public static void importOrderCSV() {
		//Import CSV
		//Sort into object/array
		String csvfile = "C:/Users/harry/Desktop/sales_log_0.csv";
		String line = "";
		String csvSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

	          while ((line = br.readLine()) != null) {	        	  	
	        	  	// use comma as separator
		            String[] importedCSV = line.split(csvSplitBy);
		            
		            names.add(importedCSV[0]);
		            amountInts.add(d_StringToInt(importedCSV[1]));              
		                
		            for (int i = 0; i < amountInts.size(); i++) {
		              orderlist.add(new order(names, amountInts));
		            }	            
		      	}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		    } catch (IOException e) {
		    	e.printStackTrace();
		 }
	}
	
	public static void sortFood() {
		//Sort objects by temperature into cold food and dry food
		for (int i = 0; i < names.size(); i++) {
			if ( (names.get(i)).getTemp() != null) {
				coldFood.add(names.get(i));
				coldFoodAmount.add(amountInts.get(i));
			}
			else
				dryFood.add(names.get(i));
				dryFoodAmount.add(amountInts.get(i));
		}
		
	}
	
	public static void truckAssign() {
		//Divide amounts into 800 for cold and 1000 for dry
		int cq = 800;
		int dq = 1000;
		int currentquanc = 0;
		int currentquand = 0;
		int coldCount = 0;
		int dryCount = 0;
		
		ArrayList<String> coldItems = new ArrayList<String>();
		ArrayList<Integer> coldItemA = new ArrayList<Integer>();
		ArrayList<String> dryItems = new ArrayList<String>();
		ArrayList<Integer> dryItemA = new ArrayList<Integer>();
		
		while (coldFood.size() > 0) {
			//Add amount of cold trucks needed
			if (currentquanc >= cq) {
				coldCount += 1;
				currentquanc = 0;
			}
			//Sum of all the items in the current truck
			for (Integer am: coldItemA) {
				currentquanc += am;
			}
			//Add the items to the current trucks inventory
			//Remove the item from the list after its been added
			
			for (int i = 0; i < coldFood.size(); i++) {
				if (currentquanc <= cq) {
					coldItems.add(coldFood.get(i));
					coldItemA.add(coldFoodAmount.get(i));
				}
				
			}
		}
		//Sort into cold truck, then into dry truck with leftovers
		ordinaryTruck one = new ordinaryTruck("Ordinary", coldFood, coldFoodAmount);
	}
	
	public static void calcCost() {
		//Get total dry quantity
		int dryQuantity = 0;
		for (int q : dryFoodAmount) {
			dryQuantity += q;
		}
		//Get lowest temperature in cold food
		int lowestTemp = 10;
		for (String t : coldFood) {
			if (t.getTemp() < lowestTemp) {
				lowestTemp = t.getTemp();
			}
		}
		//Call getCostOrd() and getCostRe() using the quantity and temp
		double oCost = ordinaryTruck.getCostOrd(dryQuantity);
		double rCost = refrigeratedTruck.getCostRe(lowestTemp);
		double coldCost = 0;
		double dryCost = 0;
		for (String item: coldFood) {
			coldCost += item.getCost();
		}
		for (String item: dryFood) {
			dryCost += item.getCost();
		}
		double foodCost = coldCost + dryCost;
		double totalCost = oCost + rCost + foodCost;
	}
	
	public static void createManifest() {
		//Make Manifest CSV
			//Refridge
				//name, quantity
			//Ordinary
				//name, quantity
	}
	
	public static void main(String[] args) {
		importOrderCSV();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + "=" + amountInts.get(i));
		}
	}
}
