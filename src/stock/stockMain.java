package stock;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import gui.GUIMain;

public class stockMain {
	
    public static ArrayList<String> names = new ArrayList<String>();
    public static ArrayList<Integer> manu_cost = new ArrayList<Integer>();
    public static ArrayList<Integer> ret_price = new ArrayList<Integer>();
    public static ArrayList<Integer> reord_point = new ArrayList<Integer>();
    public static ArrayList<Integer> reord_amt = new ArrayList<Integer>();
    public static ArrayList<String> temp = new ArrayList<String>();
       
    static DecimalFormat df = new DecimalFormat("##.00");
      
    static stock quantities = new stock();
    
    private static int orderNumber = 0;
    private static int manifestNumber = 0;
    private static int salesNumber = 0;
    
    private static double totalProfit = 0;

    public static void initialiseVariables() {
    	store supermart = store.store();
    }
    
    //String ArrayList to Integer ArrayList Method
    public static int s_StrToInt(String a){
        //ArrayList<Integer> b = new ArrayList<Integer>();
        int b = 0;
    	try {
            b = Integer.parseInt(a);
        } catch(NumberFormatException nfe) {
         	System.out.println("Could not parse " + a + " as an integer, please check CSV.");
         	nfe.printStackTrace();
        }
        return b;
    }
	
    public static void ImportItemProp() {
		String itemprop_location = "C:/302_Files/item_properties.csv";
        String line = "";
        String csvSplitBy = ",";

        names.clear();
        manu_cost.clear();
        ret_price.clear();
        reord_point.clear();
        reord_amt.clear();
        temp.clear();
        
        try (BufferedReader br = new BufferedReader(new FileReader(itemprop_location))) {

            while ((line = br.readLine()) != null) {

                //Split on comma (as its a csv)
                String[] entry = line.split(csvSplitBy);
                 
                names.add(entry[0]);
                manu_cost.add(s_StrToInt(entry[1]));
                ret_price.add(s_StrToInt(entry[2]));
                reord_point.add(s_StrToInt(entry[3]));
                reord_amt.add(s_StrToInt(entry[4]));
                
                //leaving temp as string because some items have no temp
                try {
                	temp.add(entry[5]);
                }
                catch(ArrayIndexOutOfBoundsException oob) {
                	temp.add("NULL");
                }
                
            }
            
            gui.GUIMain.fileLoaded = true;
            
        } catch (IOException ioe) {
        	System.out.println("IOException");
            ioe.printStackTrace();
        }
        
        HashMap<String, Integer> quantities = stock.getHashMap();
        for (int i = 0; i < names.size(); i++) {
        	quantities.put(names.get(i), 0);
        }
    }
	
	public void CreateItems() {
		int i = 0;
		if (i < names.size()) {
			item item0 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item1 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item2 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item3 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item4 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item5 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item6 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item7 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item8 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item9 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item10 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item11 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item12 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item13 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item14 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item15 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item16 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item17 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item18 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item19 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item20 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item21 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item22 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item23 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
		if (i < names.size()) {
			item item24 = new item(names.get(i), manu_cost.get(i), ret_price.get(i), reord_point.get(i), reord_amt.get(i), temp.get(i));
			i += 1;
		}
	}
	
	public static void ImportManifest() {
		String manifest_location = "C:/302_Files/manifest_" + manifestNumber + ".csv";
        String line = "";
        String csvSplitBy = ",";

        manifestNumber = manifestNumber + 1;
        
        try (BufferedReader br = new BufferedReader(new FileReader(manifest_location))) {

            while ((line = br.readLine()) != null) {
            	
                //Split on comma (as its a csv)
                String[] entry = line.split(csvSplitBy);
                
                if (entry[0] != ">Refridgerated" && entry[0] != ">Ordinary") {
                	try {
                	stock.changeAmount(quantities, entry[0], s_StrToInt(entry[1]));
                	} catch(ArrayIndexOutOfBoundsException oob) { 
                		
                	}
                }
            }
        } catch (IOException ioe) {
        	System.out.println("IOException");
            ioe.printStackTrace();
        }
        
	}
	
	public static void UpdateCapital(double amount) {
		double currentCapital = store.capital;
		store.capital = currentCapital + amount;		
	}
	
	public static void ImportSalesLog() {
		String saleslog_location = "C:/302_Files/sales_log_" + salesNumber + ".csv";
        String line = "";
        String csvSplitBy = ",";

        salesNumber = salesNumber + 1;
        
       totalProfit = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(saleslog_location))) {

            while ((line = br.readLine()) != null) {
            	
                //Split on comma (as its a csv)
                String[] entry = line.split(csvSplitBy);
                
                for (int i = 0; i < names.size(); i++) {
                	if (entry[0].equals(names.get(i))) {
                		stock.changeAmount(quantities, names.get(i), -1 * s_StrToInt(entry[1]));
                		
                		totalProfit = totalProfit + (s_StrToInt(entry[1]) * ret_price.get(i)); 
                	}
                }
               
            }
        } catch (IOException ioe) {
        	System.out.println("IOException");
            ioe.printStackTrace();
        }
        
        
        UpdateCapital(totalProfit);
        
	}
	
	public void CurrentStock() {
		//return stock
	}	
	
	public static void ExportOrder() throws IOException {
        //Make Order CSV
            //Format = "Name | Quantity"
		
        File file = new File("C:/302_Files/order_"+ orderNumber + ".csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        orderNumber = orderNumber + 1;

        for (int i = 0; i < names.size(); i++) {
        	if (stock.getQuantity(names.get(i)) <= reord_point.get(i)) {
    			bw.write(names.get(i) + "," + reord_amt.get(i) + "," + temp.get(i) + "," + manu_cost.get(i));
	            bw.newLine();
        	}
            
        }
        bw.close();
        fw.close();
    }

	
	/*public static void main(String[] args) throws IOException {
		
		initialiseVariables();
		ImportItemProp();
		ExportOrder();
		ImportManifest();
		System.out.println(store.capital);
		System.out.println(store.store_name);
        store.UpdateInventory();
		System.out.println(store.inventory);
		
	}*/


}
