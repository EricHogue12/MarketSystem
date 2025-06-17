package market.ui;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import market.login.Login;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel txtLoginMessage;
	private JLabel lblTitle;
	
	private Login loginManager = Login.getInstance();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10, false));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font font1 = new Font("Arial", Font.PLAIN, 20);
		Font font2 = new Font("Arial", Font.PLAIN, 18);
		Font titleFont = new Font("Serif", Font.PLAIN, 80);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(600, 300, 100, 20);
		lblUsername.setFont(font1);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(730, 300, 150, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(600, 375, 100, 20);
		lblPassword.setFont(font1);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(730, 375, 150, 25);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtLoginMessage = new JLabel("");
		txtLoginMessage.setBounds(600, 500, 304, 20);
		txtLoginMessage.setFont(font2);
		txtLoginMessage.setForeground(new Color(178, 34, 34));
		contentPane.add(txtLoginMessage);
		
		lblTitle = new JLabel("Hogue Market");
		lblTitle.setBounds(540, 50, 500, 100);
		lblTitle.setFont(titleFont);
		contentPane.add(lblTitle);
		
		
		JLabel banana = new JLabel("");
		banana.setIcon(new ImageIcon(MainFrame.class.getResource("/market/ui/orange2.png")));
		banana.setBounds(1075, 125, 360, 360);
		contentPane.add(banana);
		
		JLabel apple = new JLabel("");
		apple.setIcon(new ImageIcon(MainFrame.class.getResource("/market/ui/apple1.png")));
		apple.setBounds(80, 100, 360, 360);
		contentPane.add(apple);
		
		JLabel fruits = new JLabel("");
		fruits.setIcon(new ImageIcon(MainFrame.class.getResource("/market/ui/fruits3.png")));
		fruits.setBounds(250, 550, 1100, 307);
		contentPane.add(fruits);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = txtUsername.getText();
				char[] passwordChars = txtPassword.getPassword();
				String p = new String(passwordChars);
				passwordChars = new char[0];
				
				if (u.length() > 0 && p.length() > 0) {
					try {
						loginManager.login(u, p);
					}
					catch(Exception e1) {
						txtLoginMessage.setText(e1.getMessage());
					}
				}
			}
		});
		btnOk.setBounds(645, 450, 91, 23);
		contentPane.add(btnOk);
		
		
		
	}
}
