package gui;
//Import
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
	//Initialise variables
	public static boolean fileLoaded;
	JPanel panel; 
	JPanel IPpanel;
	JLabel header;
	JLabel capital;
	JTable itemPropertiesTable;
	JTable inventoryTable;
	//Decimal Place rounding variable
	DecimalFormat df = new DecimalFormat("##.00");
	
	public GUIMain(String title) {
		super(title);
		
		//Set up main panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		panel = new JPanel( new GridBagLayout() );
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		IPpanel = new JPanel( new GridBagLayout() );
		IPpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		//Panel settings creation and positioning
		header = new JLabel("SuperMart Inventory Managment");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(header, c); 
		
		//Capital label creation and positioning
		capital = new JLabel("Capital = $" + stock.store.capital);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(capital, c);
		
		//Load Item Prop button creation and positioning
		JButton ItemProp = new JButton("Load Item Properties");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		ItemProp.setActionCommand("LoadItemProp");
		ItemProp.addActionListener(this);
		panel.add(ItemProp, c);
		
		//Display inventory button creation and positioning
		JButton DisplayInventory = new JButton("Display Inventory");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		DisplayInventory.setActionCommand("DisplayItems");
		DisplayInventory.addActionListener(this);
		panel.add(DisplayInventory, c);
		
		//Create order button creation and positioning
		JButton CreateOrder = new JButton("Create Order & Manifest");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		CreateOrder.setActionCommand("CreateOrder");
		CreateOrder.addActionListener(this);
		panel.add(CreateOrder, c);
		
		//Load sales log button creation and positioning
		JButton LoadSale = new JButton("Load Sales Log");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		LoadSale.setActionCommand("LoadSale");
		LoadSale.addActionListener(this);
		panel.add(LoadSale, c);
		
		//Load Manifest button creation and positioning
		JButton LoadManifest = new JButton("Load Manifest");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		LoadManifest.setActionCommand("LoadManifest");
		LoadManifest.addActionListener(this);
		panel.add(LoadManifest, c);
		
		//Exit Button creation and positioning
		JButton closeButton = new JButton("Exit Program");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		closeButton.setActionCommand("Close");
		closeButton.addActionListener(this);
		panel.add(closeButton, c);
		
		//variables
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().add(panel);
		panel.setVisible(true);
		fileLoaded = false;
	}
	
	
	//Set up actions for the buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		//for item proper
		if (e.getActionCommand() == "DisplayItems") {
			//if item prop has been imported
			if (fileLoaded) {
				//Set up table
				String[][] rowData = new String[stock.stockMain.names.size()+1][7];
				rowData[0][0] = "ITEM NAME";
				rowData[0][1] = "MANU. COST";
				rowData[0][2] = "RET. PRICE";
				rowData[0][3] = "REORD. POINT";
				rowData[0][4] = "REORD. AMOUNT";
				rowData[0][5] = "TEMPERATURE";
				rowData[0][6] = "QUANTITY";
				//set up data for table
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
				//Create table and add to new panel
				JFrame IPFrame = new JFrame();
				IPFrame.add(IPTableTitle);
				IPFrame.remove(itemPropertiesTable);
				IPFrame.add(itemPropertiesTable);
				//IPFrame.setPreferredSize(new Dimension(750, 550));
				IPFrame.pack();
				IPFrame.setVisible(true);
			}
			
		} else if (e.getActionCommand() == "LoadItemProp") {
			//do stockMain.ImportItemProp() function
			stock.stockMain.ImportItemProp();
			JOptionPane.showMessageDialog(getParent(), "Item Properties Successfully Imported.");
			
		} else if (e.getActionCommand() == "CreateOrder") {
			//if item prop has been imported
			if (fileLoaded) {
				//Run ExportOrder() using stock package, then run runDelivery() from delivery function
				try{
					stock.stockMain.ExportOrder();
					delivery.deliveryMain.runDelivery();
					JOptionPane.showMessageDialog(getParent(), "Order Successfully Created.");
				} catch(IOException ioe) {
					JOptionPane.showMessageDialog(getParent(), "IO Exception when creating Order.");
				}
			}	
		} else if (e.getActionCommand() == "LoadSale") {
			//if item prop has been imported
			if (fileLoaded) {
				//Run ImportSalesLog() using stock package
				stock.stockMain.ImportSalesLog();
				JOptionPane.showMessageDialog(getParent(), "Sales Log Successfully Imported.");
				
				//Update capital label
				panel.remove(capital);
				capital.setText("Capital =  $" + stock.store.capital);
				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 2;
				c.gridy = 0;
				panel.add(capital, c);
				pack();
			}
		} else if (e.getActionCommand() == "LoadManifest") {
			//if item prop has been imported
			if (fileLoaded) {
				//Run ImportManifest() function from stock package
				stock.stockMain.ImportManifest();
				JOptionPane.showMessageDialog(getParent(), "Manifest Successfully Imported.");
				//Update capital label
				panel.remove(capital);
				capital.setText("Capital = $" + stock.store.capital);
				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 2;
				c.gridy = 0;
				panel.add(capital, c);
				pack();
			}	
		} else if (e.getActionCommand() == "Close"){
			//Close the program
			System.exit(0);
			
			
		} else {
			//Ask user to load in item properties
			JOptionPane.showMessageDialog(getParent(), "Please load an item properties file.");
		}
	}
	
	@Override
	public void run() {
		//Run
		setPreferredSize(new Dimension(678, 250));
		setLocation(new Point(100, 100));
		pack();
		setVisible(true);
	}

}