package stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class stockMain {
	
    private static ArrayList<String> names = new ArrayList<String>();
    private static ArrayList<Integer> manu_cost = new ArrayList<Integer>();
    private static ArrayList<Integer> ret_price = new ArrayList<Integer>();
    private static ArrayList<Integer> reord_point = new ArrayList<Integer>();
    private static ArrayList<Integer> reord_amt = new ArrayList<Integer>();
    private static ArrayList<String> temp = new ArrayList<String>();
        
    
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
		String itemprop_location = "C:/Users/liaml/Desktop/302 Files/item_properties.csv";
        String line = "";
        String csvSplitBy = ",";

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
                	temp.add(" ");
                }
                
            }
        } catch (IOException ioe) {
        	System.out.println("IOException");
            ioe.printStackTrace();
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
	
	
	public void UpdateCapital() {
	
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
	
	public static void main(String[] args) {
		ImportItemProp();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + " : " + manu_cost.get(i) + " : " + ret_price.get(i) + " : " + reord_point.get(i) + " : " + reord_amt.get(i) + " : " + temp.get(i));
		}
	}


}
