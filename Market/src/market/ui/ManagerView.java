package market.ui;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import market.login.Login;

public class ManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel customerFirstName;
	private JLabel customerLastName;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel CustomerDirectory = new JPanel();
		CustomerDirectory.setBounds(-3, 0, 230, 830);
		TitledBorder border1 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 4), "Customer Directory", SwingConstants.NORTH_EAST, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.BLACK);
		CustomerDirectory.setBorder(border1);
		contentPane.add(CustomerDirectory);
		CustomerDirectory.setLayout(null);
		
		
		Login loginManager = Login.getInstance();
		
		
		
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
				try {
					loginManager.addCustomer(firstName, lastName, username, password);
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
		
		
		
		
	}
}
