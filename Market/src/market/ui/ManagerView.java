package market.ui;

import java.awt.Color;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import market.login.Login;
import market.stock.Stock;

public class ManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel customerFirstName;
	private JLabel customerLastName;
	
	private JLabel t1Stock;
	private JLabel t1Items;
	private JLabel t1Sales;
	private JLabel t1Customer;
	private JLabel t1Food;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerView frame = new ManagerView();
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
	public ManagerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DecimalFormat salesFormat = new DecimalFormat("0.00");
		
		JPanel CustomerDirectory = new JPanel();
		JPanel stock = new JPanel();
		JPanel MarketStatistics = new JPanel();
		CustomerDirectory.setBounds(-3, 0, 230, 830);
		stock.setBounds(375, 10, 800, 840);
		MarketStatistics.setBounds(1309, 0, 230, 830);
		TitledBorder border1 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 4), "Customer Directory", SwingConstants.NORTH_EAST, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.BLACK);
		TitledBorder border2 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 4), "Stock Management", SwingConstants.NORTH_EAST, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.BLACK);
		TitledBorder border3 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 4), "Market Statistics", SwingConstants.NORTH_EAST, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.BLACK);
		CustomerDirectory.setBorder(border1);
		stock.setBorder(border2);
		MarketStatistics.setBorder(border3);
		contentPane.add(CustomerDirectory);
		contentPane.add(stock);
		contentPane.add(MarketStatistics);
		CustomerDirectory.setLayout(null);
		stock.setLayout(null);
		MarketStatistics.setLayout(null);
		
		
		
		Login loginManager = Login.getInstance();
		
		Stock stockManager = Stock.getInstance();
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		ArrayList<String> firstNameList = new ArrayList<String>();
		ArrayList<String> lastNameList = new ArrayList<String>();
		
		
		for (int i = 0; i < loginManager.getUsers().size(); i++) {
			if (!"manager".equals(loginManager.getUsers().get(i).getUsername())) {
				listModel.addElement(loginManager.getUsers().get(i).getUsername());
				firstNameList.add(loginManager.getUsers().get(i).getFirstName());
				lastNameList.add(loginManager.getUsers().get(i).getLastName());
			}
		}
		
		
		JList<String> customerList = new JList<String>(listModel);
		customerList.setBounds(5, 30, 219, 730);
		customerList.setFixedCellHeight(70);
		customerList.setFont(new Font("Arial", Font.PLAIN, 40));
		
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) customerList.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		CustomerDirectory.add(customerList);
		
		customerFirstName = new JLabel("");
		customerFirstName.setBounds(25, 760, 200, 50);
		customerFirstName.setFont(new Font("Arial", Font.PLAIN, 20));
		
		CustomerDirectory.add(customerFirstName);
		
		customerLastName = new JLabel("");
		customerLastName.setBounds(25, 785, 190, 50);
		customerLastName.setFont(new Font("Arial", Font.PLAIN, 20));
		
		CustomerDirectory.add(customerLastName);
		
		
		customerList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedIndex = customerList.getSelectedIndex();
				if (selectedIndex != -1) {
					String customerFirstNameText = firstNameList.get(selectedIndex);
					String customerLastNameText = lastNameList.get(selectedIndex);
					customerFirstName.setText(customerFirstNameText);
					customerLastName.setText(customerLastNameText);
				}
				else {
					customerFirstName.setText("");
					customerLastName.setText("");
				}
			}
		});
		
		
		DefaultListModel<String> vegeModel = new DefaultListModel<String>();
		DefaultListModel<String> fruitModel = new DefaultListModel<String>();
		DefaultListModel<String> meatModel = new DefaultListModel<String>();
		DefaultListModel<String> dairyModel = new DefaultListModel<String>();
		DefaultListModel<String> bakeModel = new DefaultListModel<String>();
		
		Font stockFont = new Font("Arial", Font.ITALIC, 40);
		
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
		
		vegePane.setBounds(21, 75, 150, 150);
		fruitPane.setBounds(173, 75, 150, 150);
		meatPane.setBounds(325, 75, 150, 150);
		dairyPane.setBounds(477, 75, 150, 150);
		bakePane.setBounds(629, 75, 150, 150);
		
		vegeList.setFont(stockFont);
		fruitList.setFont(stockFont);
		meatList.setFont(stockFont);
		dairyList.setFont(stockFont);
		bakeList.setFont(stockFont);
		
		JLabel vegeLabel = new JLabel("Vegetables");
		JLabel fruitLabel = new JLabel("Fruits");
		JLabel meatLabel = new JLabel("Meats");
		JLabel dairyLabel = new JLabel("Dairy");
		JLabel bakeLabel = new JLabel("Bakery");
		vegeLabel.setBounds(61, 15, 100, 100);
		fruitLabel.setBounds(227, 15, 100, 100);
		meatLabel.setBounds(380, 15, 100, 100);
		dairyLabel.setBounds(532, 15, 100, 100);
		bakeLabel.setBounds(679, 15, 100, 100);
		stock.add(vegeLabel);
		stock.add(fruitLabel);
		stock.add(meatLabel);
		stock.add(dairyLabel);
		stock.add(bakeLabel);


		
		stock.add(vegePane);
		stock.add(fruitPane);
		stock.add(meatPane);
		stock.add(dairyPane);
		stock.add(bakePane);
		
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
		
		JLabel lnameTxt = new JLabel("");
		JLabel lbyWeightTxt = new JLabel("");
		JLabel lstockTxt = new JLabel("");
		JLabel lpriceTxt = new JLabel("");
		
		Font infoFont2 = new Font("Arial", Font.PLAIN, 20);

		lnameTxt.setBounds(150, 477, 500, 100);
		lbyWeightTxt.setBounds(310, 702, 500, 100);
		lstockTxt.setBounds(150, 627, 500, 100);
		lpriceTxt.setBounds(150, 553, 500, 100);

		lnameTxt.setFont(infoFont2);
		lbyWeightTxt.setFont(infoFont2);
		lstockTxt.setFont(infoFont2);
		lpriceTxt.setFont(infoFont2);
	
		stock.add(lnameTxt);
		stock.add(lbyWeightTxt);
		stock.add(lstockTxt);
		stock.add(lpriceTxt);
		
		
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
		
		JButton btnStock1 = new JButton("INCREASE STOCK (+1)");
		JButton btnStock2 = new JButton("INCREASE STOCK (+10)");
		JButton btnStock3 = new JButton("MINIMIZE STOCK");
		JButton btnPrice1 = new JButton("INCREASE PRICE (¢)");
		JButton btnPrice2 = new JButton("INCREASE PRICE ($)");
		JButton btnPrice3 = new JButton("MINIMIZE PRICE");
		JButton btnAdd = new JButton("CREATE ITEM");
		JButton btnRemove = new JButton("REMOVE ITEM");
		
		btnStock1.setBounds(60, 250, 320, 50);
		btnStock2.setBounds(410, 250, 320, 50);
		btnStock3.setBounds(60, 400, 140, 50);
		btnPrice1.setBounds(60, 325, 320, 50);
		btnPrice2.setBounds(410, 325, 320, 50);
		btnPrice3.setBounds(240, 400, 140, 50);
		btnAdd.setBounds(410, 400, 140, 50);
		btnRemove.setBounds(590, 400, 140, 50);

		stock.add(btnStock1);
		stock.add(btnStock2);
		stock.add(btnStock3);
		stock.add(btnPrice1);
		stock.add(btnPrice2);
		stock.add(btnPrice3);
		stock.add(btnAdd);
		stock.add(btnRemove);
		
		
		JLabel lsort = new JLabel("Sort By");
		lsort.setFont(new Font("Monospaced", Font.PLAIN, 40));
		lsort.setBounds(500, 500, 200, 50);
		stock.add(lsort);
		
		JButton btnSortN = new JButton("Name");
		JButton btnSortP = new JButton("Price");
		JButton btnSortS = new JButton("Stock");
		
		btnSortN.setBounds(500, 575, 200, 50);
		btnSortP.setBounds(500, 650, 200, 50);
		btnSortS.setBounds(500, 725, 200, 50);
		
		stock.add(btnSortS);
		stock.add(btnSortN);
		stock.add(btnSortP);
		
		btnStock1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStock(vegeList.getSelectedIndex(), "Vegetable");
					lstockTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getStock()));
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStock(fruitList.getSelectedIndex(), "Fruit");
					lstockTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getStock()));
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStock(meatList.getSelectedIndex(), "Meat");
					lstockTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getStock()));
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStock(dairyList.getSelectedIndex(), "Dairy");
					lstockTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getStock()));
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStock(bakeList.getSelectedIndex(), "Bakery");
					lstockTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getStock()));
				}
				
				t1Stock.setText(String.valueOf(stockManager.getStockCount()));

				
			}
		});
		
		btnStock2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStockTen(vegeList.getSelectedIndex(), "Vegetable");
					lstockTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getStock()));
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStockTen(fruitList.getSelectedIndex(), "Fruit");
					lstockTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getStock()));
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStockTen(meatList.getSelectedIndex(), "Meat");
					lstockTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getStock()));
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStockTen(dairyList.getSelectedIndex(), "Dairy");
					lstockTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getStock()));
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.incrementFoodStockTen(bakeList.getSelectedIndex(), "Bakery");
					lstockTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getStock()));
				}
				
				t1Stock.setText(String.valueOf(stockManager.getStockCount()));

				
			}
		});
		
		btnStock3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.reduceFoodStock(vegeList.getSelectedIndex(), "Vegetable");
					lstockTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getStock()));
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.reduceFoodStock(fruitList.getSelectedIndex(), "Fruit");
					lstockTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getStock()));
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.reduceFoodStock(meatList.getSelectedIndex(), "Meat");
					lstockTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getStock()));
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.reduceFoodStock(dairyList.getSelectedIndex(), "Dairy");
					lstockTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getStock()));
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.reduceFoodStock(bakeList.getSelectedIndex(), "Bakery");
					lstockTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getStock()));
				}
				
				t1Stock.setText(String.valueOf(stockManager.getStockCount()));
				
			}
		});
		
		btnPrice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByCent(vegeList.getSelectedIndex(), "Vegetable");
					lpriceTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getPrice()));
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByCent(fruitList.getSelectedIndex(), "Fruit");
					lpriceTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getPrice()));
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByCent(meatList.getSelectedIndex(), "Meat");
					lpriceTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getPrice()));
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByCent(dairyList.getSelectedIndex(), "Dairy");
					lpriceTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getPrice()));
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByCent(bakeList.getSelectedIndex(), "Bakery");
					lpriceTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getPrice()));
				}
				
			}
		});
		
		btnPrice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByDollar(vegeList.getSelectedIndex(), "Vegetable");
					lpriceTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getPrice()));
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByDollar(fruitList.getSelectedIndex(), "Fruit");
					lpriceTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getPrice()));
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByDollar(meatList.getSelectedIndex(), "Meat");
					lpriceTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getPrice()));
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByDollar(dairyList.getSelectedIndex(), "Dairy");
					lpriceTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getPrice()));
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.increaseFoodPriceByDollar(bakeList.getSelectedIndex(), "Bakery");
					lpriceTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getPrice()));
				}
				
			}
		});
		
		btnPrice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.reduceFoodPrice(vegeList.getSelectedIndex(), "Vegetable");
					lpriceTxt.setText(String.valueOf(stockManager.getVegetables().get(vegeList.getSelectedIndex()).getPrice()));
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.reduceFoodPrice(fruitList.getSelectedIndex(), "Fruit");
					lpriceTxt.setText(String.valueOf(stockManager.getFruits().get(fruitList.getSelectedIndex()).getPrice()));
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.reduceFoodPrice(meatList.getSelectedIndex(), "Meat");
					lpriceTxt.setText(String.valueOf(stockManager.getMeats().get(meatList.getSelectedIndex()).getPrice()));
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.reduceFoodPrice(dairyList.getSelectedIndex(), "Dairy");
					lpriceTxt.setText(String.valueOf(stockManager.getDairy().get(dairyList.getSelectedIndex()).getPrice()));
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.reduceFoodPrice(bakeList.getSelectedIndex(), "Bakery");
					lpriceTxt.setText(String.valueOf(stockManager.getBakery().get(bakeList.getSelectedIndex()).getPrice()));
				}
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = JOptionPane.showInputDialog("Vegetable, Fruit, Meat, Dairy, or Bakery");
				String name = JOptionPane.showInputDialog("Item Name: ");
				boolean byWeight;
				int weight = JOptionPane.showOptionDialog(null, "Item measured by Quantity instead of Weight?", "Option", 
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
				
				if (weight == JOptionPane.YES_OPTION) {
					byWeight = false;
				}
				else {
					byWeight = true;
				}
				
				if ("Vegetable".equals(category)) {
					try {
						stockManager.addVegetable(name, byWeight, 1, 0.25);
						vegeModel.addElement(name);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				else if ("Fruit".equals(category)) {
					try {
						stockManager.addFruit(name, byWeight, 1, 0.25);
						fruitModel.addElement(name);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				else if ("Meat".equals(category)) {
					try {
						stockManager.addMeat(name, byWeight, 1, 0.25);
						meatModel.addElement(name);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				else if ("Dairy".equals(category)) {
					try {
						stockManager.addDairy(name, byWeight, 1, 0.25);
						dairyModel.addElement(name);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				else if ("Bakery".equals(category)) {
					try {
						stockManager.addBakery(name, byWeight, 1, 0.25);
						bakeModel.addElement(name);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Enter a proper food category");
				}
				
				t1Stock.setText(String.valueOf(stockManager.getStockCount()));
				t1Items.setText(String.valueOf(stockManager.itemCount()));
				
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegeList.getSelectedIndex() != -1) {
					stockManager.removeFoodByIndex(vegeList.getSelectedIndex(), "Vegetable");
					vegeModel.removeElementAt(vegeList.getSelectedIndex());
				}
				else if (fruitList.getSelectedIndex() != -1) {
					stockManager.removeFoodByIndex(fruitList.getSelectedIndex(), "Fruit");
					fruitModel.removeElementAt(fruitList.getSelectedIndex());
				}
				else if (meatList.getSelectedIndex() != -1) {
					stockManager.removeFoodByIndex(meatList.getSelectedIndex(), "Meat");
					meatModel.removeElementAt(meatList.getSelectedIndex());
				}
				else if (dairyList.getSelectedIndex() != -1) {
					stockManager.removeFoodByIndex(dairyList.getSelectedIndex(), "Dairy");
					dairyModel.removeElementAt(dairyList.getSelectedIndex());
				}
				else if (bakeList.getSelectedIndex() != -1) {
					stockManager.removeFoodByIndex(bakeList.getSelectedIndex(), "Bakery");
					bakeModel.removeElementAt(bakeList.getSelectedIndex());
				}
				else {
					
				}
				
				t1Stock.setText(String.valueOf(stockManager.getStockCount()));
				t1Items.setText(String.valueOf(stockManager.itemCount()));
			}
		});
		
		btnSortN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] s1 = stockManager.sorted("name", "Vegetable");
				vegeModel.removeAllElements();
				for (int i = 0; i < s1.length; i++) {
					vegeModel.addElement(s1[i]);
				}
				String[] s2 = stockManager.sorted("name", "Fruit");
				fruitModel.removeAllElements();
				for (int i = 0; i < s2.length; i++) {
					fruitModel.addElement(s2[i]);
				}
				String[] s3 = stockManager.sorted("name", "Meat");
				meatModel.removeAllElements();
				for (int i = 0; i < s3.length; i++) {
					meatModel.addElement(s3[i]);
				}				
				String[] s4 = stockManager.sorted("name", "Dairy");
				dairyModel.removeAllElements();
				for (int i = 0; i < s4.length; i++) {
					dairyModel.addElement(s4[i]);
				}
				String[] s5 = stockManager.sorted("name", "Bakery");
				bakeModel.removeAllElements();
				for (int i = 0; i < s5.length; i++) {
					bakeModel.addElement(s5[i]);
				}
			}
	    });
		
		btnSortS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] s1 = stockManager.sorted("stock", "Vegetable");
				vegeModel.removeAllElements();
				for (int i = 0; i < s1.length; i++) {
					vegeModel.addElement(s1[i]);
				}
				String[] s2 = stockManager.sorted("stock", "Fruit");
				fruitModel.removeAllElements();
				for (int i = 0; i < s2.length; i++) {
					fruitModel.addElement(s2[i]);
				}
				String[] s3 = stockManager.sorted("stock", "Meat");
				meatModel.removeAllElements();
				for (int i = 0; i < s3.length; i++) {
					meatModel.addElement(s3[i]);
				}				
				String[] s4 = stockManager.sorted("stock", "Dairy");
				dairyModel.removeAllElements();
				for (int i = 0; i < s4.length; i++) {
					dairyModel.addElement(s4[i]);
				}
				String[] s5 = stockManager.sorted("stock", "Bakery");
				bakeModel.removeAllElements();
				for (int i = 0; i < s5.length; i++) {
					bakeModel.addElement(s5[i]);
				}
			}
	    });
		
		btnSortP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] s1 = stockManager.sorted("price", "Vegetable");
				vegeModel.removeAllElements();
				for (int i = 0; i < s1.length; i++) {
					vegeModel.addElement(s1[i]);
				}
				String[] s2 = stockManager.sorted("price", "Fruit");
				fruitModel.removeAllElements();
				for (int i = 0; i < s2.length; i++) {
					fruitModel.addElement(s2[i]);
				}
				String[] s3 = stockManager.sorted("price", "Meat");
				meatModel.removeAllElements();
				for (int i = 0; i < s3.length; i++) {
					meatModel.addElement(s3[i]);
				}				
				String[] s4 = stockManager.sorted("price", "Dairy");
				dairyModel.removeAllElements();
				for (int i = 0; i < s4.length; i++) {
					dairyModel.addElement(s4[i]);
				}
				String[] s5 = stockManager.sorted("price", "Bakery");
				bakeModel.removeAllElements();
				for (int i = 0; i < s5.length; i++) {
					bakeModel.addElement(s5[i]);
				}
			}
	    });

		
		

		JLabel lname = new JLabel("Name:");
		JLabel lbyWeight = new JLabel("Quantity or Weight:");
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

		
		stock.add(lname);
		stock.add(lbyWeight);
		stock.add(lstock);
		stock.add(lprice);
		
		
		
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
		
		JButton btnAddCustomer = new JButton("+");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = JOptionPane.showInputDialog("Customer First Name: ");
				String lastName = JOptionPane.showInputDialog("Customer Last Name: ");
				String username = JOptionPane.showInputDialog("Customer Username: ");
				String password = JOptionPane.showInputDialog("Customer Initial Password: ");
				String balance = JOptionPane.showInputDialog("Customer Initial Balance (in $): ");
				
				try {
					Integer.parseInt(balance);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Enter a number for the balance");
				}
				
				int balance1 = Integer.parseInt(balance);
				double balance2 = (double)(balance1);
				
				try {
					loginManager.addCustomer(firstName, lastName, username, password, balance2);
					listModel.addElement(username);
					firstNameList.add(firstName);
					lastNameList.add(lastName);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnAddCustomer.setBounds(235, 10, 50, 40);
		btnAddCustomer.setFont(new Font("Arial", Font.BOLD, 28));
		btnAddCustomer.setForeground(Color.GREEN);
		contentPane.add(btnAddCustomer);
		
		JButton btnRemoveCustomer = new JButton("x");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customerList.getSelectedIndex() != -1 && listModel.getSize() != 0) {
					loginManager.deleteCustomer(customerList.getSelectedValue());
					int idx = customerList.getSelectedIndex();
					firstNameList.remove(idx);
					lastNameList.remove(idx);
					listModel.removeElementAt(idx);
				}
			}
		});
		
		btnRemoveCustomer.setBounds(235, 60, 50, 40);
		btnRemoveCustomer.setFont(new Font("Arial", Font.BOLD, 28));
		btnRemoveCustomer.setForeground(Color.RED);
		contentPane.add(btnRemoveCustomer);
		
		
		JLabel tStock = new JLabel("Total Stock:");
		JLabel tItems = new JLabel("Total #Items:");
		JLabel tSales = new JLabel("Total Sales:");
		JLabel tCustomer = new JLabel("#1 Customer:");
		JLabel tFood = new JLabel("#1 Food Type:");
		
		
		Font statFont = new Font("Serif", Font.PLAIN, 35);
		
		tStock.setBounds(15, 50, 300, 50);
		tItems.setBounds(15, 190, 300, 50);
		tSales.setBounds(15, 330, 300, 50);
		tCustomer.setBounds(15, 470, 300, 50);
		tFood.setBounds(15, 610, 300, 50);
		
		tStock.setFont(statFont);
		tItems.setFont(statFont);
		tSales.setFont(statFont);
		tCustomer.setFont(statFont);
		tFood.setFont(statFont);

		
		MarketStatistics.add(tStock);
		MarketStatistics.add(tItems);
		MarketStatistics.add(tSales);
		MarketStatistics.add(tCustomer);
		MarketStatistics.add(tFood);
		
		t1Stock = new JLabel(String.valueOf(stockManager.getStockCount()));
		t1Items = new JLabel(String.valueOf(stockManager.itemCount()));
		t1Sales = new JLabel(String.valueOf(salesFormat.format(stockManager.getSales())));
		t1Customer = new JLabel(loginManager.getBestCustomer());
		t1Food = new JLabel(stockManager.getMostBoughtFood());
		
		Font statFont1 = new Font("SansSerif", Font.PLAIN, 20);
		
		t1Stock.setBounds(30, 120, 300, 50);
		t1Items.setBounds(30, 260, 300, 50);
		t1Sales.setBounds(30, 400, 300, 50);
		t1Customer.setBounds(30, 540, 300, 50);
		t1Food.setBounds(30, 680, 300, 50);
		
		t1Stock.setFont(statFont1);
		t1Items.setFont(statFont1);
		t1Sales.setFont(statFont1);
		t1Customer.setFont(statFont1);
		t1Food.setFont(statFont1);
		
		MarketStatistics.add(t1Stock);
		MarketStatistics.add(t1Items);
		MarketStatistics.add(t1Sales);
		MarketStatistics.add(t1Customer);
		MarketStatistics.add(t1Food);
		
		
	}
}
