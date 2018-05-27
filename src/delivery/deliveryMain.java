package delivery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 
 * @author Harrison Perkins
 *
 */


public class deliveryMain {
	
	//String to Integer Array Method
	public static int d_StringToInt(String a){
	    int b = 0;
	    	try {
	    		b = Integer.parseInt(a);
	    	} catch(NumberFormatException nfe) {
	    		System.out.println("Could not parse " + a + " as an integer, please check CSV.");
	    	}
	    return b;
	}
	
	//Imported CSV Variables
	private static ArrayList<Integer> amountInts = new ArrayList<Integer>();
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<String> temp = new ArrayList<String>();
	private static ArrayList<Integer> manuAmount = new ArrayList<Integer>();
	
	//Cost Variables
	private static double manuCost = 0;
	private static double totalCost = 0;
	
	//Truck Assigning Variables
	private static ArrayList<String> coldFood = new ArrayList<String>();
	private static ArrayList<Integer> coldFoodAmount = new ArrayList<Integer>();
	private static ArrayList<String> dryFood = new ArrayList<String>();
	private static ArrayList<Integer> dryFoodAmount = new ArrayList<Integer>();
	
	public static void importOrderCSV() {
		int orderNo = 0;
		//Import CSV
		//Sort into object/array
		String csvfile = "C:/Users/harry/Desktop/order_"+ orderNo +".csv";
		String line = "";
		String csvSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

	          while ((line = br.readLine()) != null) {	        	  	
	        	  	// use comma as separator
		            String[] importedCSV = line.split(csvSplitBy);
		//Sort item name, amount, cost and temperature into their own ArrayLists, converting Strings to Ints.
		            names.add(importedCSV[0]);
		            amountInts.add(d_StringToInt(importedCSV[1]));  
		            temp.add(importedCSV[2]);
		            manuAmount.add(d_StringToInt(importedCSV[3]));
		            	            
		      	}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		    } catch (IOException e) {
		    	e.printStackTrace();
		 }
		orderNo += 1;
	}
	
	public static void sortFood() {
		String n = "NULL";
		//Sort objects by temperature into cold food and dry food
		for (int i = 0; i < names.size(); i++) {
			//if temperature is null put item into dry food
			if ( temp.get(i).equals(n)) {
				dryFood.add(names.get(i));
				dryFoodAmount.add(amountInts.get(i));
			} else
				//if item has temperature requirement put item into cold food
				coldFood.add(names.get(i));
				coldFoodAmount.add(amountInts.get(i));
		}
	}
	
	public static void truckAssign() {
		//Divide amounts into 800 for cold and 1000 for dry
		//Add amount of cold trucks needed
		//Sum of all the items in the current truck
		//Add the items to the current trucks inventory
		//Remove the item from the list after its been added
		//Sort into cold truck, then into dry truck with leftovers
		
		ArrayList<String> currentItemsCold = new ArrayList<String>();
		ArrayList<Integer> currentAmountsCold = new ArrayList<Integer>();
		ArrayList<String> currentItemsDry = new ArrayList<String>();
		ArrayList<Integer> currentAmountsDry = new ArrayList<Integer>();
		int sum = 0;
		
		for( int i = 0; i < coldFood.size(); i++) {
			currentItemsCold.add(coldFood.get(i));
			currentAmountsCold.add(coldFoodAmount.get(i));
			
			for (Integer quan: currentAmountsCold) {
				sum += quan;
			}
			
			if (sum >= 800) {
				refrigeratedTruck newTruck1 = new refrigeratedTruck("refrigerated", currentItemsCold, currentAmountsCold);
				currentItemsCold.clear();
				currentAmountsCold.clear();
			}
		}
		
		for (int i = 0; i < dryFood.size(); i++) {
			currentItemsDry.add(dryFood.get(i));
			currentAmountsDry.add(dryFoodAmount.get(i));
			
			for (Integer quan: currentAmountsDry) {
				sum += quan;
			}
			
			if (sum >= 1000) {
				ordinaryTruck newTruck2 = new ordinaryTruck("ordinary", currentItemsDry, currentAmountsDry);
				currentItemsDry.clear();
				currentAmountsDry.clear();
			}
		}
	}
	
	public static void calcCost() {
		//Get total dry quantity
		int dryQuantity = 0;
		for (int q : dryFoodAmount) {
			dryQuantity += q;
		}
		//Get lowest temperature in cold food
		int lowestTemp = 10;
		int tempCounter = 0;
		String[] ts = temp.toArray(new String[temp.size()]);
		for (int i = 0; i < ts.length; i++) {
			if (ts[i] != "NULL") {
				tempCounter += 1;
			}
		}
		
		int[] tss = new int[tempCounter];
		int tempCounter2 = 0;
		
		for (int i = 0; i < ts.length; i++ ) {
			if (!ts[i].equals("NULL")) {
				tss[tempCounter2] = d_StringToInt(ts[i]);
				tempCounter2 += 1;
			}
		}
		
		for (Integer t: tss) {
			if (t <= lowestTemp) {
				lowestTemp = t;
			}
		}
		//Call getCostOrd() and getCostRe() using the quantity and temperature
		double oCost = ordinaryTruck.getCostOrd(dryQuantity);
		double rCost = refrigeratedTruck.getCostRe(lowestTemp);
		//Calculate total manufacturing cost using manufacturing amount and item amounts
		for (int i = 0; i < amountInts.size(); i++) {
        	manuCost += (amountInts.get(i) * manuAmount.get(i));
        }
		
		totalCost = oCost + rCost + manuCost;
		}
	
	public static void createManifest() throws IOException {
		int sumCold = 0;
		int sumDry = 0;
		//Make Manifest CSV
		File file = new File("C:/Users/harry/Desktop/manifest_0.csv");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		//Refridge
		//name, quantity
		bw.write(">Refrigerated");
		bw.newLine();
		for (int i = 0; i < coldFood.size(); i++) {
			bw.write(coldFood.get(i) + "," + coldFoodAmount.get(i));
			bw.newLine();
			sumCold += coldFoodAmount.get(i);
			if (sumCold >= 800) {
				bw.write(">Refrigerated");
				bw.newLine();
				sumCold = 0;
			}
		}
		//Ordinary
		//name, quantity
		bw.write(">Ordinary");
		bw.newLine();
		for (int i = 0; i < dryFood.size(); i++) {
			bw.write(dryFood.get(i) + "," + dryFoodAmount.get(i));
			bw.newLine();
			sumDry += dryFoodAmount.get(i);
			if ( sumDry >= 1000) {
				bw.write(">Ordinary");
				bw.newLine();
				sumDry = 0;
			}
		}
		bw.close();
		fw.close();
		//store.UpdateCapital(totalCost);
	}
	
	public static void main(String[] args) throws IOException {
		importOrderCSV();
		sortFood();
		calcCost();
		createManifest();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + "=" + amountInts.get(i) + "=" + temp.get(i));
		}
		
		System.out.println("Manufactoring cost of food is = " + manuCost);
		DecimalFormat f = new DecimalFormat("##.00");
		System.out.println("Total cost is = " + f.format(totalCost));
	}
}
