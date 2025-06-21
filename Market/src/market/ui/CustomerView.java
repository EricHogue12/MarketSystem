package market.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import market.login.Login;

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
	}

}
