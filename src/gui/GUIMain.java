package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import stock.stockMain;
import stock.store;
import delivery.deliveryMain;

import java.awt.*;
import javax.swing.*;

public class GUIMain extends javax.swing.JFrame implements Runnable, ActionListener {
	
	public static boolean fileLoaded;
	JPanel panel; 
	JPanel IPpanel;
	JLabel header;
	JLabel capital;
	JTable itemPropertiesTable;
	JTable inventoryTable;
	
	DecimalFormat df = new DecimalFormat("##.00");
	
	public GUIMain(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		panel = new JPanel( new GridBagLayout() );
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		IPpanel = new JPanel( new GridBagLayout() );
		IPpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		header = new JLabel("SuperMart Inventory Managment");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(header, c); 
		
		
		capital = new JLabel("Capital = $" + stock.store.capital);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(capital, c);
		
		JButton ItemProp = new JButton("Load Item Properties");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		ItemProp.setActionCommand("LoadItemProp");
		ItemProp.addActionListener(this);
		panel.add(ItemProp, c);
		
		JButton DisplayInventory = new JButton("Display Inventory");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		DisplayInventory.setActionCommand("DisplayItems");
		DisplayInventory.addActionListener(this);
		panel.add(DisplayInventory, c);
		
		JButton CreateOrder = new JButton("Create Order");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		CreateOrder.setActionCommand("CreateOrder");
		CreateOrder.addActionListener(this);
		panel.add(CreateOrder, c);
		
		JButton LoadSale = new JButton("Load Sales Log");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		LoadSale.setActionCommand("LoadSale");
		LoadSale.addActionListener(this);
		panel.add(LoadSale, c);
		
		JButton LoadManifest = new JButton("Load Manifest");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		LoadManifest.setActionCommand("LoadManifest");
		LoadManifest.addActionListener(this);
		panel.add(LoadManifest, c);
		
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().add(panel);
		panel.setVisible(true);
		fileLoaded = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "DisplayItems") {
			if (fileLoaded) {
				
				String[][] rowData = new String[stock.stockMain.names.size()+1][7];
				rowData[0][0] = "ITEM NAME";
				rowData[0][1] = "MANU. COST";
				rowData[0][2] = "RET. PRICE";
				rowData[0][3] = "REORD. POINT";
				rowData[0][4] = "REORD. AMOUNT";
				rowData[0][5] = "TEMP";
				rowData[0][6] = "QUANTITY";
				for (int i = 1; i < stock.stockMain.names.size() + 1; i++) {
					try {
						rowData[i][0] = stock.stockMain.names.get(i-1);
						rowData[i][1] = stock.stockMain.manu_cost.get(i-1).toString();
						rowData[i][2] = stock.stockMain.ret_price.get(i-1).toString();
						rowData[i][3] = stock.stockMain.reord_point.get(i-1).toString();
						rowData[i][4] = stock.stockMain.reord_amt.get(i-1).toString();
						rowData[i][5] = stock.stockMain.temp.get(i-1);
						rowData[i][6] = Integer.toString((stock.stock.getQuantity(stock.stockMain.names.get(i-1))));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(getParent(), "Error Creating Item Properties Table");
						JOptionPane.showMessageDialog(getParent(), e1.getStackTrace());
					}
				}
				String[] IPColumnNames = { "Item Name", "Manufacturing Cost", "Retail Price", "Reorder Point", "Reorder Amount", "Temperature", "Quantity" };
				itemPropertiesTable = new JTable(rowData, IPColumnNames);
				JTextField IPTableTitle = new JTextField("Item Properties");
				
				JFrame IPFrame = new JFrame();
				IPFrame.add(IPTableTitle);
				IPFrame.remove(itemPropertiesTable);
				IPFrame.add(itemPropertiesTable);
				//IPFrame.setPreferredSize(new Dimension(750, 550));
				IPFrame.pack();
				IPFrame.setVisible(true);
			}
		} else if (e.getActionCommand() == "LoadItemProp") {
			stock.stockMain.ImportItemProp();
			JOptionPane.showMessageDialog(getParent(), "Item Properties Successfully Imported.");
		} else if (e.getActionCommand() == "CreateOrder") {
			try{
				stock.stockMain.ExportOrder();
				delivery.deliveryMain.runDelivery();
				JOptionPane.showMessageDialog(getParent(), "Order Successfully Created.");
			} catch(IOException ioe) {
				JOptionPane.showMessageDialog(getParent(), "IO Exception when creating Order.");
			}
			
		} else if (e.getActionCommand() == "LoadSale") {
			
			stock.stockMain.ImportSalesLog();
			JOptionPane.showMessageDialog(getParent(), "Sales Log Successfully Imported.");
			panel.remove(capital);
			capital.setText("Capital = $" + stock.store.capital);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			c.gridy = 0;
			panel.add(capital, c);
			pack();
			
		} else if (e.getActionCommand() == "LoadManifest") {
			stock.stockMain.ImportManifest();
			JOptionPane.showMessageDialog(getParent(), "Manifest Successfully Imported.");
			panel.remove(capital);
			capital.setText("Capital = $" + stock.store.capital);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			c.gridy = 0;
			panel.add(capital, c);
			pack();
		} else {
			JOptionPane.showMessageDialog(getParent(), "Please select a valid log file");
		}
	}
	
	@Override
	public void run() {
		setPreferredSize(new Dimension(678, 250));
		setLocation(new Point(100, 100));
		pack();
		setVisible(true);
	}

}

//else if (e.getActionCommand() == "displayInfo") {
	//if (fileLoaded) {
		//String[][] rowData = new String[restaurant.getNumCustomerOrders() + 1][6];
		//rowData[0][0] = "Customer Name";
		//rowData[0][1] = "Mobile Number";
		//rowData[0][2] = "Customer Type";
		//rowData[0][3] = "X Location";
		//rowData[0][4] = "Y Location";
		//rowData[0][5] = "Delivery Distance";
		//for (int i = 1; i < (restaurant.getNumCustomerOrders() + 1); i++) {
			//try {
				//rowData[i][0] = restaurant.getCustomerByIndex(i - 1).getName();
				//rowData[i][1] = restaurant.getCustomerByIndex(i - 1).getMobileNumber();
				//rowData[i][2] = restaurant.getCustomerByIndex(i - 1).getCustomerType();
				//rowData[i][3] = Integer.toString(restaurant.getCustomerByIndex(i - 1).getLocationX());
				//rowData[i][4] = Integer.toString(restaurant.getCustomerByIndex(i - 1).getLocationY());
				//rowData[i][5] = Double.toString(restaurant.getCustomerByIndex(i - 1).getDeliveryDistance());
			//} catch (Exception e1) {
				//handleException(e1);
			//}
		//}
		//String[] customerColumnNames = { "Customer Name", "Mobile Number", "Customer Type", "X Location",
			//	"Y Location", "Delivery Distance" };
	//	customerTable = new JTable(rowData, customerColumnNames);
	//	rowData = new String[restaurant.getNumPizzaOrders() + 1][5];
		//rowData[0][0] = "Pizza Type";
		//rowData[0][1] = "Quantity";
		//rowData[0][2] = "Order Price";
		//rowData[0][3] = "Order Cost";
		///rowData[0][4] = "Order Profit";
		//for (int i = 1; i < (restaurant.getNumPizzaOrders() + 1); i++) {
			//try {
				//rowData[i][0] = restaurant.getPizzaByIndex(i - 1).getPizzaType();
				//rowData[i][1] = Integer.toString(restaurant.getPizzaByIndex(i - 1).getQuantity());
				//rowData[i][2] = Double.toString(restaurant.getPizzaByIndex(i - 1).getOrderPrice());
				//rowData[i][3] = Double.toString(restaurant.getPizzaByIndex(i - 1).getOrderCost());
			//	rowData[i][4] = Double.toString(restaurant.getPizzaByIndex(i - 1).getOrderProfit());
		//	} catch (Exception e1) {
				//handleException(e1);
			//}
		//}
		//String[] pizzaColumnNames = { "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit" };
		//pizzaTable = new JTable(rowData, pizzaColumnNames);
		//JTextField customerTableTitle = new JTextField("Customer Details");
		//JTextField pizzaTableTitle = new JTextField("Pizza Details");
		//dataPanel.add(customerTableTitle);
		//dataPanel.add(customerTable);
		//dataPanel.add(pizzaTableTitle);
		//dataPanel.add(pizzaTable);
		//dataPanel.remove(fileLoadedText);
		//getContentPane().remove(dataPanel);
		//getContentPane().add(dataPanel);
		//setPreferredSize(new Dimension(678, 250));
		//pack();
	//	setVisible(true);
//	} else {
		//JOptionPane.showMessageDialog(getParent(), "Please select a valid log file");
	//}
