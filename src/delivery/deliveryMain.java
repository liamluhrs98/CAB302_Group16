package delivery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class deliveryMain {
	
	public static void main(String[] args) {
		//Import CSV
		//Sort into object/array/hashmap
		String csvfile = "C:/Users/harry/Desktop/sales_log_0.csv";
		String line = "";
		String csvSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] name = line.split(csvSplitBy);

                System.out.println(name[0]+ "=" + name[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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
