package gui;

import javax.swing.SwingUtilities;

import gui.GUIMain;

public class GUIWizard {

	public GUIWizard() {
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GUIMain("Inventory Managment"));
	}

}
