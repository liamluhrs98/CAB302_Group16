package delivery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class deliveryMain {
	
	public static void main(String[] args) {
		
	}
	
	public static int[] strArrayToIntArray(String[] a){
	    int[] b = new int[a.length];
	    for (int i = 0; i < a.length; i++) {
	        b[i] = Integer.parseInt(a[i]);
	    }

	    return b;
	}
	
	public void importOrderCSV() {
		//Import CSV
		//Sort into object/array
		int[] amountInts = null;
		String[] names = new String[30];
		ArrayList<order> orderlist = new ArrayList<order>();
		String csvfile = "C:/Users/harry/Desktop/sales_log_0.csv";
		String line = "";
		String csvSplitBy = ",";
				
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

	          while ((line = br.readLine()) != null) {
	        	  	// use comma as separator
		            String[] csv = line.split(csvSplitBy);
		            String[] amounts = new String[] {csv[1]};
		            names = new String[] {csv[0]};
		                
		            for (int i = 0; i < amounts.length; i++) {
		        		amountInts = strArrayToIntArray(amounts);
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
		//Sort objects by temp into cold food and dry food
		for(str element: names) {
			
		}
	}
	
	public void truckAssign() {
		//Get total quantity of cold food
		//Get total quantity of dry food
		//Sort into cold truck, then into dry truck with leftovers
		
	}
	
	public void calcCost() {
		//Get total dry quantity
		//Get lowest temp in cold food
		//Call getCostOrd() and getCostRe() using the quantity and temp
		
	}
	
	public void createManifest() {
		//Make Manifest CSV
			//Refridge
				//name, quantity
			//Ordinary
				//name, quantity
	}
	
}
