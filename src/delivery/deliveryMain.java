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
	private static ArrayList<Integer> del_amountInts = new ArrayList<Integer>();
	private static ArrayList<String> del_names = new ArrayList<String>();
	private static ArrayList<String> del_temp = new ArrayList<String>();
	private static ArrayList<Integer> del_manuAmount = new ArrayList<Integer>();
	
	//Cost Variables
	private static double manuCost = 0;
	private static double totalCost = 0;
	
	//CSV Variables
	private static int orderNumber = 0;
	private static int manifestNumber = 0;
	
	//Truck Assigning Variables
	private static ArrayList<String> coldFood = new ArrayList<String>();
	private static ArrayList<Integer> coldFoodAmount = new ArrayList<Integer>();
	private static ArrayList<String> dryFood = new ArrayList<String>();
	private static ArrayList<Integer> dryFoodAmount = new ArrayList<Integer>();
	
	public static void importOrderCSV() {
		//Import CSV
		//Sort into object/array
		String csvfile = "C:/302_Files/order_"+ orderNumber +".csv";
		String line = "";
		String csvSplitBy = ",";
		
		del_amountInts.clear();
		del_names.clear();
		del_temp.clear();
		del_manuAmount.clear();
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

			while ((line = br.readLine()) != null) {	        	  	
				// use comma as separator
		        String[] importedCSV = line.split(csvSplitBy);
		        //Sort item name, amount, cost and temperature into their own ArrayLists, converting Strings to Ints.
		        del_names.add(importedCSV[0]);
		        del_amountInts.add(d_StringToInt(importedCSV[1]));  
		        del_temp.add(importedCSV[2]);
		        del_manuAmount.add(d_StringToInt(importedCSV[3]));
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		   	e.printStackTrace();
		}
		orderNumber += 1;
	}
	
	public static void sortFood() {
		String n = "NULL";
		dryFood.clear();
		dryFoodAmount.clear();
		coldFood.clear();
		coldFoodAmount.clear();
		
		//Sort objects by temperature into cold food and dry food
		for (int i = 0; i < del_names.size(); i++) {
			//if temperature is null put item into dry food
			if ( del_temp.get(i).equals(n)) {
				dryFood.add(del_names.get(i));
				dryFoodAmount.add(del_amountInts.get(i));
			} else
				//if item has temperature requirement put item into cold food
				coldFood.add(del_names.get(i));
				coldFoodAmount.add(del_amountInts.get(i));
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
				currentItemsDry.clear();
				currentAmountsDry.clear();
			}
		}
	}
	
	public static void calcCost() {
		//Get total dry quantity
		manuCost = 0;
		
		int dryQuantity = 0;
		
		for (int q : dryFoodAmount) {
			dryQuantity += q;
		}
		//Get lowest temperature in cold food
		int lowestTemp = 10;
		int tempCounter = 0;
		String[] ts = del_temp.toArray(new String[del_temp.size()]);
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
		for (int i = 0; i < del_amountInts.size(); i++) {
        	manuCost += (del_amountInts.get(i) * del_manuAmount.get(i));
        }
		
		totalCost = oCost + rCost + manuCost;
		totalCost = -totalCost;
		}
	
	public static void createManifest() throws IOException {
		int sumCold = 0;
		int sumDry = 0;
		//Make Manifest CSV
		File file = new File("C:/302_Files/manifest_" + manifestNumber + ".csv");
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
		manifestNumber += 1;
		
	}
	
	/*public static void main(String[] args) throws IOException {
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
	}*/
	
	public static void runDelivery() throws IOException {
		importOrderCSV();
		sortFood();
		calcCost();
		createManifest();
		stock.stockMain.UpdateCapital(totalCost);

	}
}
