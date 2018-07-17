package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class GUI {

	private JFrame frame;
	private JTextField txtStockSymbol;
	private JTextField txtQuantity;
	private JButton btnBuy;

	private JTextArea txtrDisplayInfoHere;
	private JButton btnViewPortfolio;
	private JButton btnSell;
	private JButton btnViewStock;
	
	private JOptionPane openingDialog;
	

	public JButton getBtnViewPortfolio() {
		return btnViewPortfolio;
	}

	public void setBtnViewPortfolio(JButton btnViewPortfolio) {
		this.btnViewPortfolio = btnViewPortfolio;
	}

	public JButton getBtnSell() {
		return btnSell;
	}

	public void setBtnSell(JButton btnSell) {
		this.btnSell = btnSell;
	}

	public JButton getBtnViewStock() {
		return btnViewStock;
	}

	public void setBtnViewStock(JButton btnViewStock) {
		this.btnViewStock = btnViewStock;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtStockSymbol() {
		return txtStockSymbol;
	}

	public void setTxtStockSymbol(JTextField txtStockSymbol) {
		this.txtStockSymbol = txtStockSymbol;
	}

	public JTextField getTxtQuantity() {
		return txtQuantity;
	}

	public void setTxtQuantity(JTextField txtQuantity) {
		this.txtQuantity = txtQuantity;
	}

	public JButton getBtnBuy() {
		return btnBuy;
	}

	public void setBtnBuy(JButton btnBuy) {
		this.btnBuy = btnBuy;
	}

	public JTextArea getTxtrDisplayInfoHere() {
		return txtrDisplayInfoHere;
	}

	public void setTxtrDisplayInfoHere(String info) {
		this.txtrDisplayInfoHere.setText(info);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToHamzas = new JLabel("Welcome to Hamza's Stock Simulator");
		lblWelcomeToHamzas.setBounds(6, 6, 239, 16);
		frame.getContentPane().add(lblWelcomeToHamzas);
		
		
		//Stock Symbol text box
		txtStockSymbol = new JTextField();
		txtStockSymbol.setText("Stock Symbol");
		txtStockSymbol.setBounds(6, 56, 130, 26);
		frame.getContentPane().add(txtStockSymbol);
		txtStockSymbol.setColumns(10);
		
		//Quantity text box
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity");
		txtQuantity.setBounds(6, 94, 130, 26);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		//Buy button
		btnBuy = new JButton("Buy");
		btnBuy.setBounds(204, 56, 117, 29);
		frame.getContentPane().add(btnBuy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 132, 438, 140);
		frame.getContentPane().add(scrollPane);
		
		txtrDisplayInfoHere = new JTextArea();
		txtrDisplayInfoHere.setWrapStyleWord(true);
		txtrDisplayInfoHere.setLineWrap(true);
		txtrDisplayInfoHere.setText("Display Info Here");
		scrollPane.setViewportView(txtrDisplayInfoHere);
		
		btnViewPortfolio = new JButton("View Portfolio");
		btnViewPortfolio.setBounds(333, 56, 117, 29);
		frame.getContentPane().add(btnViewPortfolio);
		
		btnSell = new JButton("Sell");
		btnSell.setBounds(204, 94, 117, 29);
		frame.getContentPane().add(btnSell);
		
		btnViewStock = new JButton("View Stock");
		btnViewStock.setBounds(333, 94, 117, 29);
		frame.getContentPane().add(btnViewStock);
		}
}
