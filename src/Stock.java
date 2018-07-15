
public class Stock {

	private String symbol;
	private String name;
	private double currentPrice;
	private double purchasePrice;
	private int quantity;
	
	
	/**
	 * Constructor
	 * @param symbol
	 * @param quantity
	 * @param price
	 */
	public Stock(String symbol, int quantity, double price) {
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
		info += this.symbol + "\n" + this.quantity + this.currentPrice;
		return info;
	}
	
	/*public JSONObject stockInfo() {
		
		JSONObject stock = new JSONObject();
		stock.put("symbol", this.symbol);
		stock.put("name", this.name);
		stock.put("purchase price", this.purchasePrice);
		stock.put("current price", this.currentPrice);
		stock.put("quantity", quantity);
		
		return stock;
	}*/
	
	
}
