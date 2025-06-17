package market.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import market.login.Login;
import market.login.Manager;
import market.login.User;

public class ManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel managerFirstName;
	private JLabel managerLastName;

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
		
		JPanel ManagerDirectory = new JPanel();
		ManagerDirectory.setBounds(-3, 0, 230, 892);
		TitledBorder border1 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 4), "Manager Directory", SwingConstants.NORTH_EAST, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.BLACK);
		ManagerDirectory.setBorder(border1);
		contentPane.add(ManagerDirectory);
		ManagerDirectory.setLayout(null);
		
		
		Login loginManager = Login.getInstance();
		
		
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		ArrayList<User> tempManagerList = new ArrayList<User>();
		
		for (int i = 0; i < loginManager.getUsers().size(); i++) {
			if (loginManager.getUsers().get(i) instanceof Manager) {
				listModel.addElement(loginManager.getUsers().get(i).getUsername());
				tempManagerList.add(loginManager.getUsers().get(i));
			}
		}
		
		
		JList<String> managerList = new JList<String>(listModel);
		managerList.setBounds(5, 30, 219, 730);
		managerList.setFixedCellHeight(70);
		managerList.setFont(new Font("Arial", Font.PLAIN, 40));
		
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) managerList.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		ManagerDirectory.add(managerList);
		
		managerFirstName = new JLabel("");
		managerFirstName.setBounds(25, 785, 200, 50);
		managerFirstName.setFont(new Font("Arial", Font.PLAIN, 25));
		
		ManagerDirectory.add(managerFirstName);
		
		managerLastName = new JLabel("");
		managerLastName.setBounds(25, 815, 190, 50);
		managerLastName.setFont(new Font("Arial", Font.PLAIN, 25));
		
		ManagerDirectory.add(managerLastName);
		
		
		managerList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedItem = managerList.getSelectedIndex();
				String managerFirstNameText = tempManagerList.get(selectedItem).getFirstName();
				String managerLastNameText = tempManagerList.get(selectedItem).getLastName();
				managerFirstName.setText(managerFirstNameText);
				managerLastName.setText(managerLastNameText);
			}
		});
		
		
		
		
	}
}
