package delivery;

import java.io.BufferedReader;
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
	private static ArrayList<String> cold_food = new ArrayList<String>();
	private static ArrayList<Integer> cold_food_amount = new ArrayList<Integer>();
	private static ArrayList<String> dry_food = new ArrayList<String>();
	private static ArrayList<Integer> dry_food_amount = new ArrayList<Integer>();
	
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
		      } catch (IOException e) {
		    	  e.printStackTrace();
		 }
	}
	
	public static void sortFood() {
		//Sort objects by temperature into cold food and dry food
		for (int i = 0; i < names.size(); i++) {
			if ( item.getTemp(names.get(i)) != null) {
				cold_food.add(names.get(i));
				cold_food_amount.add(amountInts.get(i));
			}
			else
				dry_food.add(names.get(i));
				dry_food_amount.add(amountInts.get(i));
		}
		
	}
	
	public static void truckAssign() {
		//Get total quantity of cold food
		int totalcold = 0;
		for (int t : cold_food_amount) {
			totalcold += t;
		}
		//Get total quantity of dry food
		int totaldry = 0;
		for (int t : dry_food_amount) {
			totaldry += t;
		}
		//Divide amounts into 800 for cold and 1000 for dry
		double cold = 0.0;
		double dry = 0.0;
		int cq = 800;
		int dq = 1000;
		
		ArrayList<String> coldItems = new ArrayList<String>();
		ArrayList<Integer> coldItemA = new ArrayList<Integer>();
		
		for (int i = 0; i < (cold_food.size() + dry_food.size()); i++) {
			if (coldItemA < 800) {
				coldItems.add(cold_food.get(i));
				coldItemA.add(cold_food_amount.get(i));
			}
			
		}
		
		while (cold_food.size() > 0 && dry_food.size() > 0) {
			
		}
		
		//Sort into cold truck, then into dry truck with leftovers
		for (int i = 0; i < cold; i++) {
			refrigeratedTruck refrig1 = new refrigeratedTruck( "reTruck" + i, cold_food, cold_food_amount);
		}
		
		for (int i = 0; i < dry; i++) {
			ordinaryTruck ord1 = new ordinaryTruck("ordTruck" + i, dry_food, dry_food_amount);
		}
	}
	
	public static void calcCost() {
		//Get total dry quantity
		int dryQuantity = 0;
		for (int q : dry_food_amount) {
			dryQuantity += q;
		}
		//Get lowest temp in cold food
		int lowestTemp = 10;
		for (String t : cold_food) {
			if (item.getTemp(t) < lowestTemp) {
				lowestTemp = item.getTemp(t);
			}
		}
		//Call getCostOrd() and getCostRe() using the quantity and temp
		//double oCost = ordinaryTruck.getCostOrd(dryQuantity);
		//double rCost = refrigeratedTruck.getCostRe(lowestTemp);
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
