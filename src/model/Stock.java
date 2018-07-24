package model;

import controller.APIController;

/**
 * Stock Class
 * @author Hamza Elahi
 * Contains all the features of the stock object
 *
 */
public class Stock {

	private String symbol;
	private String name;
	private double currentPrice;
	private double purchasePrice;
	private int quantity;
	
	
	/**
	 * Constructor that fails if symbol is empty string, longer than 5 or if price/quantity is 0 or negative
	 * @param symbol of the stock
	 * @param quantity owned
	 * @param price at the time of purchase is set to current and purchase price
	 */
	public Stock(String symbol, int quantity, double price) {
		if(symbol.equals("") || symbol.length() > 5 || quantity <= 0 || price <= 0) return;
		this.symbol = symbol;
		this.quantity = quantity;
		this.currentPrice = price;
		this.purchasePrice = price;
	}
	

	//TODO: Link this to API to get name of stock from symbol
	public String generateName(String symbol) {
		return "";
	}
	
	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Checks the API for the stock price and returns if
	 * @return the spot price of the stock
	 */
	public Double getSpotPrice() {
		Double spotPrice = APIController.getStockPrice(symbol);
		if(spotPrice <0) return null;
		this.currentPrice = spotPrice;
		return spotPrice;
	}
	
	/**
	 * Update the amount of shares owned
	 * @param quantity of stocks purchased/sold
	 */
	public void update(int quant) {
		this.quantity += quant;
		if (this.quantity < 0) this.quantity = 0;
	}
	
	public String toString() {
		String info = "";
		info += this.symbol.toUpperCase() + "\nQuantity: " + this.quantity + "\nPrice: " + this.currentPrice
				+ "\nMarket Value: " + quantity*currentPrice;
		return info;
	}
	
	public static String stockInfo(String s) {
		String info = "";
		info += s + "\n" + APIController.getStockPrice(s);
		
		return info;

	}
	
	
}
