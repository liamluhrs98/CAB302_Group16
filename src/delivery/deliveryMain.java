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
	
	public static void main(String[] args) {
		
	}
	
	//String Array to Integer Array Method
	public static int[] d_strArrayToIntArray(String[] a){
	    int[] b = new int[a.length];
	    for (int i = 0; i < a.length; i++) {
		        b[i] = Integer.parseInt(a[i]);
	    }
	    return b;
	}
	
	//Imported CSV Variables
	private String[] importedCSV = new String[30];
	private int[] amountInts = null;
	private String[] names = new String[30];
	private ArrayList<order> orderlist = new ArrayList<order>();
	
	//Truck Assigning Variables
	private ArrayList<String> cold_food = new ArrayList<String>();
	private ArrayList<Integer> cold_food_amount = new ArrayList<Integer>();
	private ArrayList<String> dry_food = new ArrayList<String>();
	private ArrayList<Integer> dry_food_amount = new ArrayList<Integer>();
	
	public void importOrderCSV() {
		//Import CSV
		//Sort into object/array
		String csvfile = "C:/Users/harry/Desktop/sales_log_0.csv";
		String line = "";
		String csvSplitBy = ",";
				
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

	          while ((line = br.readLine()) != null) {
	        	  	// use comma as separator
		            importedCSV = line.split(csvSplitBy);
		            
		            String[] amounts = new String[] {importedCSV[1]};
		            names = new String[] {importedCSV[0]};
		                
		            for (int i = 0; i < amounts.length; i++) {
		        		amountInts = d_strArrayToIntArray(amounts);
		        	}               
		                
		            for (int i = 0; i < amounts.length; i++) {
		                orderlist.add(new order(names[i], amountInts[i]));
		            }
		            
		            System.out.println(names[0] + "=" + amountInts[0]);
		      	}

		      } catch (IOException e) {
		    	  e.printStackTrace();
		 }
	}
	
	public void sortFood() {
		//Sort objects by temperature into cold food and dry food
		for (int i = 0; i < importedCSV.length; i++) {
			if ( item.getTemp(names[i]) != null) {
				cold_food.add(names[i]);
				cold_food_amount.add(amountInts[i]);
			}
			else
				dry_food.add(names[i]);
				dry_food_amount.add(amountInts[i]);
		}
		
	}
	
	public void truckAssign() {
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
		
		for (int i = 0; i < cold; i++) {
			refrigeratedTruck refrig1 = new refrigeratedTruck( "reTruck" + i, cold_food, cold_food_amount);
		}
		
		for (int i = 0; i < dry; i++) {
			ordinaryTruck ord1 = new ordinaryTruck("ordTruck" + i, dry_food, dry_food_amount);
		}
		//Sort into cold truck, then into dry truck with leftovers
	}
	
	public void calcCost() {
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
	
	public void createManifest() {
		//Make Manifest CSV
			//Refridge
				//name, quantity
			//Ordinary
				//name, quantity
	}
	
}
