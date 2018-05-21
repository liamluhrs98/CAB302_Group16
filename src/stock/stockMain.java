package stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class stockMain {
	
	public void ImportItemProp() {
		String csvfile = "C:/Users/liaml/Desktop/itemproperties.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] entry = line.split(csvSplitBy);

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
