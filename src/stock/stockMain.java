package stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class stockMain {
	
	public static int[] s_strArrayToIntArray(String[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			try {
				b[i] = Integer.parseInt(a[i]); 
						
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		return b;
	}
	
	public void ImportItemProp() {
		String itemprop_location = "C:/Users/liaml/Desktop/302 Files/itemproperties.csv";
        String line = "";
        String csvSplitBy = ",";
        
        int count = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(itemprop_location))) {

            while ((line = br.readLine()) != null) {
            	count = count + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] names = new String[count];
        String[] manu_cost = new String[count];
        String[] ret_price = new String[count];
        String[] reord_point = new String[count];
        String[] reord_amt = new String[count];
        String[] temp = new String[count];
                
        int count2 = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(itemprop_location))) {

            while ((line = br.readLine()) != null) {

                //Split on comma (as its a csv)
                String[] entry = line.split(csvSplitBy);
                
                count2 = count2 + 1;
                
                names[count2] = entry[0];
                manu_cost[count2] = entry[1];
                ret_price[count2] = entry[2];
                reord_point[count2] = entry[3];
                reord_amt[count2] = entry[4];
                temp[count2] = entry[5];
                
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
