package stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class stockMain {
	
	public void ImportItemProp() {
		String itemprop_location = "C:/Users/liaml/Desktop/302 Files/itemproperties.csv";
        String line = "";
        String csvSplitBy = ",";

        
        //Initialise temporary variables to use for creating items
        String adhoc_name = "";			//Item name
                
        try (BufferedReader br = new BufferedReader(new FileReader(itemprop_location))) {

            while ((line = br.readLine()) != null) {

                //Split on comma (as its a csv)
                String[] entry = line.split(csvSplitBy);
                
                //Put the name into the adhoc variable
                adhoc_name = entry[0];
                
                //Convert remaining strings to int
                try (int adhoc_manu_cost = Integer.parseInt(entry[1])) {
            	   
                } catch (NumberFormatException e) {
                	System.out.println("Cant convert " + entry[1] + " to type int.");
                }
                
                try (int adhoc_ret_price = Integer.parseInt(entry[2])) {
             	   
                } catch (NumberFormatException e) {
                	System.out.println("Cant convert " + entry[2] + " to type int.");
                }
                try (int adhoc_reord_point = Integer.parseInt(entry[3])) {
             	   
                } catch (NumberFormatException e) {
                	System.out.println("Cant convert " + entry[3] + " to type int.");
                }
                try (int adhoc_reord_amt = Integer.parseInt(entry[4])) {
             	   
                } catch (NumberFormatException e) {
                	System.out.println("Cant convert " + entry[4] + " to type int.");
                }
                try (int adhoc_temp = Integer.parseInt(entry[5])) {
             	   
                } catch (NumberFormatException e) {
                	System.out.println("Cant convert " + entry[5] + " to type int.");
                }
                
                            
                
                
                
                
                System.out.println(entry[0]+ "=" + entry[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void CurrentCapital() {
		//return capital
	}
	
	public void CurrentStock() {
		//return stock
	}
	
	public void ImportSalesLog() {
		
	}
	
	public void CreateOrder() {
		
	}
	
	public void ExportOrder() {
		
	}
}
