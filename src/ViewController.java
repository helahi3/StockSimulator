import javax.swing.JOptionPane;

public class ViewController {
	
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

	private void updateCash() {
		Double cash = portfolio.getCash();
		gui.setLblCash(cash);
	}
	
	private void buy() {
		String symbol = gui.getTxtStockSymbol().getText();
		int quantity = Integer.parseInt(gui.getTxtQuantity().getText());
		
		
		boolean success = portfolio.stockPurchase(symbol, quantity);
		
		
		
		if(success) {
			JOptionPane.showMessageDialog(null, "Stock purchase successful","info",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Stock purchase failed","info",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void sell() {
		String symbol = gui.getTxtStockSymbol().getText();
		int quantity = Integer.parseInt(gui.getTxtQuantity().getText());
		boolean success = portfolio.stockSale(symbol, quantity);
		if(success) {
			JOptionPane.showMessageDialog(null, "Stock sale successful","info",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Stock sale failed","info",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void viewStock() {
		String symbol = gui.getTxtStockSymbol().getText();
		String info = Stock.stockInfo(symbol);
		gui.setTxtrDisplayInfoHere(info);
	}
	
	private void viewPortfolio() {
		String info = portfolio.toString();
		gui.setTxtrDisplayInfoHere(info);
	}
	
	
	
}
