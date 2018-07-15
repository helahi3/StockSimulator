import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GUI {

	private JFrame frame;
	private JTextField txtStockSymbol;
	private JTextField txtQuantity;

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
		
		txtStockSymbol = new JTextField();
		txtStockSymbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = txtStockSymbol.getText();
				txtStockSymbol.setText(textFieldValue);
			}
		});
		txtStockSymbol.setText("Stock Symbol");
		txtStockSymbol.setBounds(6, 56, 130, 26);
		frame.getContentPane().add(txtStockSymbol);
		txtStockSymbol.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = txtQuantity.getText();
				txtQuantity.setText(textFieldValue);
			}
		});

		txtQuantity.setText("Quantity");
		txtQuantity.setBounds(6, 94, 130, 26);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnBuy.setBounds(204, 56, 117, 29);
		frame.getContentPane().add(btnBuy);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(204, 94, 117, 29);
		frame.getContentPane().add(btnSell);
		
		JButton btnViewPortfolio = new JButton("View Portfolio");
		btnViewPortfolio.setBounds(327, 56, 117, 29);
		frame.getContentPane().add(btnViewPortfolio);
		
		JButton btnViewStockInfo = new JButton("View Stock");
		btnViewStockInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewStockInfo.setBounds(327, 94, 117, 29);
		frame.getContentPane().add(btnViewStockInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 132, 438, 140);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtrDisplayInfoHere = new JTextArea();
		txtrDisplayInfoHere.setText("Display Info Here");
		scrollPane.setViewportView(txtrDisplayInfoHere);
		
		
	}
}
