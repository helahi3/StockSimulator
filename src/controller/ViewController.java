package controller;

/**

 * View Controller Method.
 * Interacts with the View (GUI.java), Model (Portfolio.java) and FileIO , updating them
 * 
 */

import java.io.Serializable;

import javax.swing.JOptionPane;

import model.Portfolio;
import model.Stock;
import view.GUI;

public class ViewController implements Serializable {
	
	public int xyz;
	public ViewController() {
		xyz=0;
	}
	
	private GUI gui;
	private Portfolio portfolio;
	
	/**
	 * Constructor
	 * @param gui (the view)
	 * @param portfolio (the model)
	 */
	public ViewController(GUI g, Portfolio p) {
		this.gui = g;
		this.portfolio = p;
		initView();
	}

	/**
	 * Initialize the view by setting the frame as visible
	 */
	public void initView() {
		gui.getFrame().setVisible(true);
	}
	
	/**
	 * Initialize controller by adding action listeners to the buttons
	 */
	public void initController() {
		gui.getBtnBuy().addActionListener(e -> buy());
		gui.getBtnSell().addActionListener(e -> sell());
		gui.getBtnViewStock().addActionListener(e -> viewStock());
		gui.getBtnViewPortfolio().addActionListener(e -> viewPortfolio());
	}
	
//	/**
//	 * TODO: Update the label to display the cash in account
//	 */
//	private void updateCash() {
//		Double cash = portfolio.getCash();
//		gui.setLblCash(cash);
//	}
	
	/**
	 * Purchase a stock, getting input from the gui, and updating the model
	 */
	private void buy() {
		String symbol = getStockSymbol(gui);
		int quantity = getStockQuantity(gui);
		if(quantity == -1 || symbol == null) {
			JOptionPane.showMessageDialog(null, "Please input correct values","info",JOptionPane.INFORMATION_MESSAGE);
		}
		
		int confirmation = JOptionPane.showConfirmDialog(null, "Do you wish to buy " + quantity + " shares of " + symbol +"?");
		if(confirmation != 0) return;
		
		boolean success = portfolio.stockPurchase(symbol, quantity);
		
		
		if(success) {
			JOptionPane.showMessageDialog(null, "Stock purchase successful","info",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Stock purchase failed","info",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Sell a stock, getting input from the gui, and updating the model
	 */
	private void sell() {
		String symbol = getStockSymbol(gui);
		int quantity = getStockQuantity(gui);
		if(quantity == -1 || symbol == null) {
			JOptionPane.showMessageDialog(null, "Please input correct values","info",JOptionPane.INFORMATION_MESSAGE);
		}
		
		int confirmation = JOptionPane.showConfirmDialog(null, "Do you wish to sell " + quantity + " shares of " + symbol +"?");
		if(confirmation != 0) return;

		
		boolean success = portfolio.stockSale(symbol, quantity);
		if(success) {
			JOptionPane.showMessageDialog(null, "Stock sale successful","info",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Stock sale failed","info",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Get stock information from the model, display to the view
	 */
	private void viewStock() {
		String symbol = gui.getTxtStockSymbol().getText();
		String info = Stock.stockInfo(symbol);
		gui.setTxtrDisplayInfoHere(info);
	}
	
	/**
	 * Get portfolio information from the model, display to the view
	 */
	private void viewPortfolio() {
		String info = portfolio.toString();
		gui.setTxtrDisplayInfoHere(info);
	}
	
	/**
	 * 
	 * @param gui
	 * @return  stock symbol from the gui. Returns null if nothing is entered
	 */
	private String getStockSymbol(GUI gui) {
		String symbol = gui.getTxtStockSymbol().getText();
		if(symbol.length() == 0) return null;	
		
		return symbol;
	}
	
	/**
	 * 
	 * @param gui
	 * @return stock quantity from the gui. Returns -1 if error with input
	 */
	private int getStockQuantity(GUI gui) {
		String input = gui.getTxtQuantity().getText();
		try {
			int quantity = Integer.parseInt(input);
			return quantity;
		} catch(Exception e) {
			return -1;
		}
		

	}
	
}
