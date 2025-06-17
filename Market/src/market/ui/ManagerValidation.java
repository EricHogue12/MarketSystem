package market.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import market.login.Login;
import market.login.Manager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerValidation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passcode;
	
	private Login loginManager = Login.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerValidation frame = new ManagerValidation();
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
	public ManagerValidation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passcode = new JPasswordField();
		passcode.setBounds(220, 250, 1100, 150);
		passcode.setFont(new Font("Arial", Font.PLAIN, 100));
		contentPane.add(passcode);
		passcode.setColumns(10);
		
		JButton passcodeButton = new JButton("Validate Passcode");
		passcodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] passcodeChars = passcode.getPassword();
				String code = new String(passcodeChars);
				passcodeChars = new char[0];
				if (code.length() > 0) {
					if (Manager.managerCounter == 0) {
						if (Manager.isPasscodeCorrect(code)) {
							Manager m1 = new Manager("Initial", "Manager");
							loginManager.getUsers().add(m1);
							loginManager.setCurrentUser(m1);
							ManagerView mv1 = new ManagerView();
							mv1.setExtendedState(JFrame.MAXIMIZED_BOTH);
							mv1.setVisible(true);
							dispose();
						}
						else {
							FirstFrame ff = new FirstFrame();
							ff.setExtendedState(JFrame.MAXIMIZED_BOTH);
							ff.setVisible(true);
							dispose();
						}
					}
					else {
						try {
							loginManager.login("manager" + String.valueOf(Manager.managerCounter + 1), code);
							ManagerView mv1 = new ManagerView();
							mv1.setExtendedState(JFrame.MAXIMIZED_BOTH);
							mv1.setVisible(true);
							dispose();
						}
						catch (Exception e1) {
							FirstFrame ff = new FirstFrame();
							ff.setExtendedState(JFrame.MAXIMIZED_BOTH);
							ff.setVisible(true);
							dispose();
						}
					}
				}
			}
		});
		passcodeButton.setBounds(320, 500, 900, 200);
		passcodeButton.setFont(new Font("Arial", Font.PLAIN, 100));
		contentPane.add(passcodeButton);
	}
}
