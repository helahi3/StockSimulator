import java.util.ArrayList;


public class Portfolio {

	//TODO: Decide which one to use
	private ArrayList<Stock> stockList;
	private Double portfolioValue;
	private Double cash;
	
	/**
	 * Getter method for stockList
	 * @return the stock list
	 */
	public ArrayList<Stock> getStockList() {
		return stockList;
	}

	/**
	 * Getter method for cash
	 * @return current cash
	 */
	public Double getCash() {
		return cash;
	}

	/**
	 * Constructor
	 */
	public Portfolio() {
		stockList = new ArrayList<Stock>();
		portfolioValue = 0.0;
		cash = 10000.0;
	}
	
	/**
	 * Initialize the portfolio with a certain amount of cash
	 * @param cash
	 * @throws Exception
	 */
	public void initializePortfolio(Double cash) throws Exception {
		if(cash < 0) throw new Exception();
		this.cash = cash;
	}
	
	/**
	 * Get the portfolio value
	 * @return the portfolio value at the latest returned prices
	 */
	public Double updatePortfolioValue() {
		Double portVal = 0.0;
		for(Stock s : stockList) {
			portVal += s.getCurrentPrice(); 
		}
		this.portfolioValue = portVal;
		return portVal;
	}
	
	/**
	 * Check if a particular stock is owned
	 * @param symbol
	 * @return
	 */
	public boolean checkStock(String symbol) {
		for(Stock s : stockList) {
			if(s.getSymbol().equals(symbol))
				return true;
		}
		return false;
	}
	
	/**
	 * Get the stock after checking it exists in portfolio
	 * @param symbol
	 * @return the stock
	 */
	public Stock getStock(String symbol) {
		if(!checkStock(symbol)) return null;
		for(Stock s : stockList) {
			if(s.getSymbol().equals(symbol))
				return s;
		}
		return null;
	}
	
	/**
	 * Get the stock quantity
	 * @param symbol
	 * @return the stock quantity
	 */
	public int getStockQuant(String symbol) {
		Stock s = getStock(symbol);
		if(s == null) return -1;
		return s.getQuantity();
	}
	
	/**
	 * Overloaded method
	 * @param stock
	 * @return the quantity 
	 */
	public int getStockQuant(Stock s) {
		if(s == null) return -1;
		return s.getQuantity();
	}
	
	/**
	 * Checks if a particular stock symbol exists, or can be bought, then makes the purchase
	 * @param symbol
	 * @param quantity
	 * @return whether the stock was bought or not
	 */
	public boolean stockPurchase(String symbol, int quantity) {
		Double price = APIController.getStockPrice(symbol);
		if(price < 0) return false; //There was some error / wrong symbol entered
		if(price * quantity > cash) return false; //Cannot afford this quantity of stocks 

		this.cash -= price * quantity;
		
		//if stockList does not contain this stock
		if(!checkStock(symbol)) {
			stockList.add(new Stock(symbol, quantity, price));
		}
		else { //Else just get the stock and update teh quantity
			Stock s = getStock(symbol);
			s.update(quantity);
		}
		
		return true;
	}
	
	/**
	 * Sells a quantity of a stock after checking quantity owned
	 * @param symbol
	 * @param quantity
	 * @return whether stock was sold or not
	 */
	public boolean stockSale(String symbol, int quantity) {
		Double price = APIController.getStockPrice(symbol);
		if(price < 0) return false; //There was some error / wrong symbol entered
		Stock s = getStock(symbol);
		if(getStockQuant(s) < quantity) return false; //Do not own this quantity of stocks

		this.cash += price * quantity;
		
		s.update(-quantity);
		return true;
		
	}
	
	public String toString() {
		String info = "";
		for(Stock s : stockList) {
			info += s.toString();
			info += "\n";
		}
		return info;
	}
	
	
}
