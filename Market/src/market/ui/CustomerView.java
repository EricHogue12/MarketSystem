package market.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import market.login.Login;
import market.stock.Stock;

public class CustomerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView frame = new CustomerView();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerView() {  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		Login loginManager = Login.getInstance();
		Stock stockManager = Stock.getInstance();
		
		DecimalFormat balanceFormat = new DecimalFormat("0.00");
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstFrame ff = new FirstFrame();
				ff.setExtendedState(JFrame.MAXIMIZED_BOTH);
				ff.setVisible(true);
				loginManager.logout();
				dispose();
			}
		});
		btnSignOut.setBounds(30, 845, 100, 23);
		contentPane.add(btnSignOut);
		

		
		JButton btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String originalPassword = JOptionPane.showInputDialog("Old Password: ");
				if (!loginManager.getCurrentUser().isCorrectPassword(originalPassword)) {
					JOptionPane.showMessageDialog(null, "Incorrect Password");
				}
				else {
					String newPassword = JOptionPane.showInputDialog("New Password: ");
					try {
						loginManager.getCurrentUser().setPassword(newPassword);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				
				
			}
		});
		btnChangePassword.setBounds(1333, 845, 170, 23);
		contentPane.add(btnChangePassword);
		
		
		DefaultListModel<String> vegeModel = new DefaultListModel<String>();
		DefaultListModel<String> fruitModel = new DefaultListModel<String>();
		DefaultListModel<String> meatModel = new DefaultListModel<String>();
		DefaultListModel<String> dairyModel = new DefaultListModel<String>();
		DefaultListModel<String> bakeModel = new DefaultListModel<String>();
		
		Font stockFont = new Font("Serif", Font.PLAIN, 50);
		
		JList<String> vegeList = new JList<String>(vegeModel);
		JList<String> fruitList = new JList<String>(fruitModel);
		JList<String> meatList = new JList<String>(meatModel);
		JList<String> dairyList = new JList<String>(dairyModel);
		JList<String> bakeList = new JList<String>(bakeModel);
		
		JScrollPane vegePane = new JScrollPane(vegeList);
		JScrollPane fruitPane = new JScrollPane(fruitList);
		JScrollPane meatPane = new JScrollPane(meatList);
		JScrollPane dairyPane = new JScrollPane(dairyList);
		JScrollPane bakePane = new JScrollPane(bakeList);
		
		vegePane.setBounds(50, 75, 260, 350);
		fruitPane.setBounds(340, 75, 260, 350);
		meatPane.setBounds(630, 75, 260, 350);
		dairyPane.setBounds(920, 75, 260, 350);
		bakePane.setBounds(1210, 75, 260, 350);
		
		vegeList.setFont(stockFont);
		fruitList.setFont(stockFont);
		meatList.setFont(stockFont);
		dairyList.setFont(stockFont);
		bakeList.setFont(stockFont);
		
		Border lineBorder1 = BorderFactory.createLineBorder(Color.cyan, 1);
		vegeList.setBorder(lineBorder1);
		fruitList.setBorder(lineBorder1);
		meatList.setBorder(lineBorder1);
		dairyList.setBorder(lineBorder1);
		bakeList.setBorder(lineBorder1);

		
		JLabel vegeLabel = new JLabel("Vegetables");
		JLabel fruitLabel = new JLabel("Fruits");
		JLabel meatLabel = new JLabel("Meats");
		JLabel dairyLabel = new JLabel("Dairy");
		JLabel bakeLabel = new JLabel("Bakery");
		vegeLabel.setBounds(95, 20, 170, 45);
		fruitLabel.setBounds(420, 20, 95, 45);
		meatLabel.setBounds(710, 20, 96, 45);
		dairyLabel.setBounds(1005, 20, 86, 45);
		bakeLabel.setBounds(1285, 20, 110, 45);
		
		Font stockFont1 = new Font("SansSerif", Font.BOLD, 30);
		
		vegeLabel.setFont(stockFont1);
		fruitLabel.setFont(stockFont1);
		meatLabel.setFont(stockFont1);
		dairyLabel.setFont(stockFont1);
		bakeLabel.setFont(stockFont1);
		
		vegeLabel.setForeground(Color.green);
		fruitLabel.setForeground(Color.magenta);
		meatLabel.setForeground(Color.RED);
		dairyLabel.setForeground(Color.blue);
		bakeLabel.setForeground(Color.yellow);
		
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
		
		vegeLabel.setBorder(lineBorder);
		fruitLabel.setBorder(lineBorder);
		meatLabel.setBorder(lineBorder);
		dairyLabel.setBorder(lineBorder);
		bakeLabel.setBorder(lineBorder);
		
		contentPane.add(vegeLabel);
		contentPane.add(fruitLabel);
		contentPane.add(meatLabel);
		contentPane.add(dairyLabel);
		contentPane.add(bakeLabel);


		
		contentPane.add(vegePane);
		contentPane.add(fruitPane);
		contentPane.add(meatPane);
		contentPane.add(dairyPane);
		contentPane.add(bakePane);
		
		
		for (int i = 0; i < stockManager.getVegetables().size(); i++) {
			vegeModel.addElement(stockManager.getVegetables().get(i).getName());
		}
		for (int i = 0; i < stockManager.getFruits().size(); i++) {
			fruitModel.addElement(stockManager.getFruits().get(i).getName());
		}
		for (int i = 0; i < stockManager.getMeats().size(); i++) {
			meatModel.addElement(stockManager.getMeats().get(i).getName());
		}
		for (int i = 0; i < stockManager.getDairy().size(); i++) {
			dairyModel.addElement(stockManager.getDairy().get(i).getName());
		}
		for (int i = 0; i < stockManager.getBakery().size(); i++) {
			bakeModel.addElement(stockManager.getBakery().get(i).getName());
		}
				
		
		JLabel lname = new JLabel("Name:");
		JLabel lbyWeight = new JLabel("Measured By:");
		JLabel lstock = new JLabel("Stock:");
		JLabel lprice = new JLabel("Price:");
	
		
		Font infoFont = new Font("Arial", Font.BOLD, 25);
		
		lname.setBounds(50, 500, 200, 50);
		lbyWeight.setBounds(50, 725, 300, 50);
		lstock.setBounds(50, 650, 200, 50);
		lprice.setBounds(50, 575, 200, 50);
		
		lname.setFont(infoFont);
		lbyWeight.setFont(infoFont);
		lstock.setFont(infoFont);
		lprice.setFont(infoFont);

		
		contentPane.add(lname);
		contentPane.add(lbyWeight);
		contentPane.add(lstock);
		contentPane.add(lprice);
		
		
		
		
		JLabel lnameTxt = new JLabel("");
		JLabel lbyWeightTxt = new JLabel("");
		JLabel lstockTxt = new JLabel("");
		JLabel lpriceTxt = new JLabel("");
		
		Font infoFont2 = new Font("Arial", Font.PLAIN, 20);

		lnameTxt.setBounds(150, 477, 500, 100);
		lbyWeightTxt.setBounds(235, 702, 500, 100);
		lstockTxt.setBounds(150, 627, 500, 100);
		lpriceTxt.setBounds(150, 553, 500, 100);
		
		lnameTxt.setFont(infoFont2);
		lbyWeightTxt.setFont(infoFont2);
		lstockTxt.setFont(infoFont2);
		lpriceTxt.setFont(infoFont2);
	
		contentPane.add(lnameTxt);
		contentPane.add(lbyWeightTxt);
		contentPane.add(lstockTxt);
		contentPane.add(lpriceTxt);
		
		vegeList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				fruitList.clearSelection();
				meatList.clearSelection();
				dairyList.clearSelection();
				bakeList.clearSelection();
				int idx = vegeList.getSelectedIndex();
				if (idx != -1) {
					String name1 = stockManager.getVegetables().get(idx).getName();
					double price1 = stockManager.getVegetables().get(idx).getPrice();
					int stock1 = stockManager.getVegetables().get(idx).getStock();
					boolean byWeight = stockManager.getVegetables().get(idx).getByWeight();
					lnameTxt.setText(name1);
					if (byWeight) {
						lbyWeightTxt.setText("weight");
					}
					else {
						lbyWeightTxt.setText("quantity");
					}
					lstockTxt.setText(String.valueOf(stock1));
					lpriceTxt.setText(String.valueOf(price1));
				}
				else {
					lnameTxt.setText("");
					lbyWeightTxt.setText("");
					lstockTxt.setText("");
					lpriceTxt.setText("");
				}
			}
		});
		
		fruitList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				vegeList.clearSelection();
				meatList.clearSelection();
				dairyList.clearSelection();
				bakeList.clearSelection();
				int idx = fruitList.getSelectedIndex();
				if (idx != -1) {
					String name1 = stockManager.getFruits().get(idx).getName();
					double price1 = stockManager.getFruits().get(idx).getPrice();
					int stock1 = stockManager.getFruits().get(idx).getStock();
					boolean byWeight = stockManager.getFruits().get(idx).getByWeight();
					lnameTxt.setText(name1);
					if (byWeight) {
						lbyWeightTxt.setText("weight");
					}
					else {
						lbyWeightTxt.setText("quantity");
					}
					lstockTxt.setText(String.valueOf(stock1));
					lpriceTxt.setText(String.valueOf(price1));
				}
				else {
					lnameTxt.setText("");
					lbyWeightTxt.setText("");
					lstockTxt.setText("");
					lpriceTxt.setText("");
				}
			}
		});
		
		meatList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				fruitList.clearSelection();
				vegeList.clearSelection();
				dairyList.clearSelection();
				bakeList.clearSelection();
				int idx = meatList.getSelectedIndex();
				if (idx != -1) {
					String name1 = stockManager.getMeats().get(idx).getName();
					double price1 = stockManager.getMeats().get(idx).getPrice();
					int stock1 = stockManager.getMeats().get(idx).getStock();
					boolean byWeight = stockManager.getMeats().get(idx).getByWeight();
					lnameTxt.setText(name1);
					if (byWeight) {
						lbyWeightTxt.setText("weight");
					}
					else {
						lbyWeightTxt.setText("quantity");
					}
					lstockTxt.setText(String.valueOf(stock1));
					lpriceTxt.setText(String.valueOf(price1));
				}
				else {
					lnameTxt.setText("");
					lbyWeightTxt.setText("");
					lstockTxt.setText("");
					lpriceTxt.setText("");
				}
			}
		});
		
		dairyList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				fruitList.clearSelection();
				meatList.clearSelection();
				vegeList.clearSelection();
				bakeList.clearSelection();
				int idx = dairyList.getSelectedIndex();
				if (idx != -1) {
					String name1 = stockManager.getDairy().get(idx).getName();
					double price1 = stockManager.getDairy().get(idx).getPrice();
					int stock1 = stockManager.getDairy().get(idx).getStock();
					boolean byWeight = stockManager.getDairy().get(idx).getByWeight();
					lnameTxt.setText(name1);
					if (byWeight) {
						lbyWeightTxt.setText("weight");
					}
					else {
						lbyWeightTxt.setText("quantity");
					}
					lstockTxt.setText(String.valueOf(stock1));
					lpriceTxt.setText(String.valueOf(price1));
				}
				else {
					lnameTxt.setText("");
					lbyWeightTxt.setText("");
					lstockTxt.setText("");
					lpriceTxt.setText("");
				}
			}
		});
		
		bakeList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				fruitList.clearSelection();
				meatList.clearSelection();
				dairyList.clearSelection();
				vegeList.clearSelection();
				int idx = bakeList.getSelectedIndex();
				if (idx != -1) {
					String name1 = stockManager.getBakery().get(idx).getName();
					double price1 = stockManager.getBakery().get(idx).getPrice();
					int stock1 = stockManager.getBakery().get(idx).getStock();
					boolean byWeight = stockManager.getBakery().get(idx).getByWeight();
					lnameTxt.setText(name1);
					if (byWeight) {
						lbyWeightTxt.setText("weight");
					}
					else {
						lbyWeightTxt.setText("quantity");
					}
					lstockTxt.setText(String.valueOf(stock1));
					lpriceTxt.setText(String.valueOf(price1));
				}
				else {
					lnameTxt.setText("");
					lbyWeightTxt.setText("");
					lstockTxt.setText("");
					lpriceTxt.setText("");
				}
			}
		});
		
		JButton sep1 = new JButton();
		sep1.setBounds(400, 520, 2, 250);
		contentPane.add(sep1);
		
		JButton sep2 = new JButton();
		sep2.setBounds(395, 520, 2, 250);
		contentPane.add(sep2);
		
		JButton sep3 = new JButton();
		sep3.setBounds(405, 520, 2, 250);
		contentPane.add(sep3);
		
		
		
		JLabel lblAmount = new JLabel("Quantity/Weight(lbs)");
		lblAmount.setBounds(450, 500, 199, 50);
		lblAmount.setFont(new Font("Arial", Font.ITALIC, 20));
		contentPane.add(lblAmount);
		
		JTextField amount = new JTextField();
		amount.setBounds(460, 550, 170, 30);
		contentPane.add(amount);
		
		JButton buy = new JButton("BUY");
		buy.setBounds(460, 600, 170, 170);
		buy.setFont(new Font("Serif", Font.BOLD, 63));
		buy.setBorder(lineBorder);
		buy.setForeground(Color.GREEN);
		contentPane.add(buy);
		
		JLabel buyMessage = new JLabel("");
		buyMessage.setBounds(475, 775, 200, 30);
		buyMessage.setFont(new Font("Arial", Font.ITALIC, 15));
		buyMessage.setForeground(Color.red);
		contentPane.add(buyMessage);
		

		
		JLabel balance = new JLabel("0.00$");
		if (loginManager.getCurrentUser() != null) {
			balance.setText(String.valueOf(balanceFormat.format(loginManager.getCurrentUser().getBalance())));
		}
		balance.setBounds(760, 570, 300, 200);
		balance.setFont(new Font("Arial", Font.BOLD, 80));
		contentPane.add(balance);
		

		
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(amount.getText());
				}
				catch(Exception e1) {
					buyMessage.setText("Enter a number");
				}
				
				int amt = Integer.parseInt(amount.getText());
				
				
				if (vegeList.getSelectedIndex() != -1) {
					int lim = stockManager.getVegetables().get(vegeList.getSelectedIndex()).getStock();
					double prc = stockManager.getVegetables().get(vegeList.getSelectedIndex()).getPrice() * amt;
					
					if (prc > loginManager.getCurrentUser().getBalance()) {
						buyMessage.setText("Monetary Limitation");
					}
					
					else if (amt > lim) {
						buyMessage.setText("Stock limitation");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thank you for your purchase!");
						stockManager.incrementVegeCounter();
						stockManager.updateSales(prc);
						double bal = loginManager.getCurrentUser().getBalance();
						loginManager.getCurrentUser().setBalance(bal - prc);
						balance.setText(String.valueOf(balanceFormat.format(loginManager.getCurrentUser().getBalance())));
						if (amt == lim) {
							stockManager.removeFoodByIndex(vegeList.getSelectedIndex(), "Vegetable");
							vegeModel.removeElementAt(vegeList.getSelectedIndex());
						}
						else {
							stockManager.getVegetables().get(vegeList.getSelectedIndex()).setStock(lim - amt);
							lstockTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getStock()));
						}
					}
				}
				else if (fruitList.getSelectedIndex() != -1) {
					int lim = stockManager.getFruits().get(fruitList.getSelectedIndex()).getStock();
					double prc = stockManager.getFruits().get(fruitList.getSelectedIndex()).getPrice() * amt;
					
					if (prc > loginManager.getCurrentUser().getBalance()) {
						buyMessage.setText("Monetary Limitation");
					}
					
					else if (amt > lim) {
						buyMessage.setText("Stock limitation");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thank you for your purchase!");
						stockManager.incrementFruitCounter();
						stockManager.updateSales(prc);
						double bal = loginManager.getCurrentUser().getBalance();
						loginManager.getCurrentUser().setBalance(bal - prc);
						balance.setText(String.valueOf(balanceFormat.format(loginManager.getCurrentUser().getBalance())));
						if (amt == lim) {
							stockManager.removeFoodByIndex(fruitList.getSelectedIndex(), "Fruit");
							fruitModel.removeElementAt(fruitList.getSelectedIndex());
						}
						else {
							stockManager.getFruits().get(fruitList.getSelectedIndex()).setStock(lim - amt);
							lstockTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getStock()));
						}
					}
				}
				else if (meatList.getSelectedIndex() != -1) {
					int lim = stockManager.getMeats().get(meatList.getSelectedIndex()).getStock();
					double prc = stockManager.getMeats().get(meatList.getSelectedIndex()).getPrice() * amt;
					
					if (prc > loginManager.getCurrentUser().getBalance()) {
						buyMessage.setText("Monetary Limitation");
					}
					
					else if (amt > lim) {
						buyMessage.setText("Stock limitation");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thank you for your purchase!");
						stockManager.incrementMeatCounter();
						stockManager.updateSales(prc);
						double bal = loginManager.getCurrentUser().getBalance();
						loginManager.getCurrentUser().setBalance(bal - prc);
						balance.setText(String.valueOf(balanceFormat.format(loginManager.getCurrentUser().getBalance())));
						if (amt == lim) {
							stockManager.removeFoodByIndex(meatList.getSelectedIndex(), "Meat");
							meatModel.removeElementAt(meatList.getSelectedIndex());
						}
						else {
							stockManager.getMeats().get(meatList.getSelectedIndex()).setStock(lim - amt);
							lstockTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getStock()));
						}
					}
				}
				else if (dairyList.getSelectedIndex() != -1) {
					int lim = stockManager.getDairy().get(dairyList.getSelectedIndex()).getStock();
					double prc = stockManager.getDairy().get(dairyList.getSelectedIndex()).getPrice() * amt;
					
					if (prc > loginManager.getCurrentUser().getBalance()) {
						buyMessage.setText("Monetary Limitation");
					}
					
					else if (amt > lim) {
						buyMessage.setText("Stock limitation");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thank you for your purchase!");
						stockManager.incrementDairyCounter();
						stockManager.updateSales(prc);
						double bal = loginManager.getCurrentUser().getBalance();
						loginManager.getCurrentUser().setBalance(bal - prc);
						balance.setText(String.valueOf(balanceFormat.format(loginManager.getCurrentUser().getBalance())));
						if (amt == lim) {
							stockManager.removeFoodByIndex(dairyList.getSelectedIndex(), "Dairy");
							dairyModel.removeElementAt(dairyList.getSelectedIndex());
						}
						else {
							stockManager.getDairy().get(dairyList.getSelectedIndex()).setStock(lim - amt);
							lstockTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getStock()));
						}
					}
				}
				else if (bakeList.getSelectedIndex() != -1) {
					int lim = stockManager.getBakery().get(bakeList.getSelectedIndex()).getStock();
					double prc = stockManager.getBakery().get(bakeList.getSelectedIndex()).getPrice() * amt;
					
					if (prc > loginManager.getCurrentUser().getBalance()) {
						buyMessage.setText("Monetary Limitation");
					}
					
					else if (amt > lim) {
						buyMessage.setText("Stock limitation");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thank you for your purchase!");
						stockManager.incrementBakeCounter();
						stockManager.updateSales(prc);
						double bal = loginManager.getCurrentUser().getBalance();
						loginManager.getCurrentUser().setBalance(bal - prc);
						balance.setText(String.valueOf(balanceFormat.format(loginManager.getCurrentUser().getBalance())));
						if (amt == lim) {
							stockManager.removeFoodByIndex(bakeList.getSelectedIndex(), "Bakery");
							bakeModel.removeElementAt(bakeList.getSelectedIndex());
						}
						else {
							stockManager.getBakery().get(bakeList.getSelectedIndex()).setStock(lim - amt);
							lstockTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getStock()));
						}
					}
				}
				else {
					buyMessage.setText("Select an item");
				}
				
			}
				
			
		});
		
		JButton sep4 = new JButton();
		sep4.setBounds(690, 520, 2, 250);
		contentPane.add(sep4);
		
		JButton sep5 = new JButton();
		sep5.setBounds(695, 520, 2, 250);
		contentPane.add(sep5);
		
		JButton sep6 = new JButton();
		sep6.setBounds(685, 520, 2, 250);
		contentPane.add(sep6);
		
		JLabel marketBalance = new JLabel("Market Balance:");
		marketBalance.setBounds(750, 500, 300, 100);
		marketBalance.setFont(new Font("SansSerif", Font.PLAIN, 40));
		contentPane.add(marketBalance);
		
		
		
		JButton sep7 = new JButton();
		sep7.setBounds(760, 730, 270, 2);
		contentPane.add(sep7);
		
		JButton sep8 = new JButton();
		sep8.setBounds(1090, 520, 2, 250);
		contentPane.add(sep8);
		
		JButton sep9 = new JButton();
		sep9.setBounds(1095, 520, 2, 250);
		contentPane.add(sep9);
		
		JButton sep10 = new JButton();
		sep10.setBounds(1085, 520, 2, 250);
		contentPane.add(sep10);
		
		JButton sep11 = new JButton();
		sep11.setBounds(175, 855, 1100, 2);
		contentPane.add(sep11);
		
		JLabel donut = new JLabel("");
		donut.setIcon(new ImageIcon(MainFrame.class.getResource("/market/ui/donut.png")));
		donut.setBounds(1135, 450, 400, 400);
		contentPane.add(donut);
		

		
	}
}
