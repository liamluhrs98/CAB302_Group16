package delivery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class deliveryMain {
	
	public static void main(String[] args) {
		//Import CSV
		//Sort into object/array/hashmap
		int[] arr = null;
		String[] names = new String[30];
		ArrayList<order> orderlist = new ArrayList<order>();
		String csvfile = "C:/Users/harry/Desktop/sales_log_0.csv";
		String line = "";
		String csvSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] name = line.split(csvSplitBy);
                String[] amount = new String[] {name[1]};
                names = new String[] {name[0]};
                
                for (int i = 0; i < amount.length; i++) {
        			arr = strArrayToIntArray(amount);
        		}               
                
                for (int i = 0; i < amount.length; i++) {
                	orderlist.add(new order(names[i], arr[i]));
                }
                
                System.out.println(names[0] + "=" + arr[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//for (int i = 0; i< names.length; i++) {
			//String[][] test = new String[50][50];
			//test[0][i] = names[i];
			//test[1][i] = Integer.toString(arr[i]);
			//System.out.println(test[0][i] + "=" + test[1][i]);
		//}
	}
	
	public static int[] strArrayToIntArray(String[] a){
	    int[] b = new int[a.length];
	    for (int i = 0; i < a.length; i++) {
	        b[i] = Integer.parseInt(a[i]);
	    }

	    return b;
	}
	
	public void sortFood() {
		//Sort objects by temp into cold food and dry food
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
