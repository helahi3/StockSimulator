import javax.swing.JOptionPane;

public class ViewController {
	
	private GUI gui;
	private Portfolio portfolio;
	
	public ViewController(GUI g, Portfolio p) {
		this.gui = g;
		this.portfolio = p;
		initView();
	}

	public void initView() {
		gui.getFrame().setVisible(true);
	}
	
	public void initController() {
		gui.getBtnBuy().addActionListener(e -> buy());
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
			System.out.println(symbol + " " + quantity + " " + portfolio.getCash());
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
	
	
	
	
	
}
