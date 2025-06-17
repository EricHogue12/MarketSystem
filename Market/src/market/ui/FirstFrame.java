package market.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FirstFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
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
	public FirstFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton customerButton = new JButton("Customer Login");
		customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame();
			    mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				mf.setVisible(true);
				dispose();
			}
		});
		customerButton.setFont(new Font("Yu Gothic", Font.PLAIN, 90));
		customerButton.setBounds(430, 200, 700, 180);
		contentPane.add(customerButton);
		
		JButton managerButton = new JButton("Manager Login");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerValidation mv = new ManagerValidation();
			    mv.setExtendedState(JFrame.MAXIMIZED_BOTH);
				mv.setVisible(true);
				dispose();
			}
		});
		managerButton.setFont(new Font("Yu Gothic", Font.PLAIN, 90));
		managerButton.setBounds(430, 500, 700, 180);
		contentPane.add(managerButton);
		
		JButton button1 = new JButton("");
		button1.setBounds(1, 0, 50, 50);
		contentPane.add(button1);
		
		JButton button2 = new JButton("");
		button2.setBounds(1487, 0, 50, 50);
		contentPane.add(button2);
		
		JButton button3 = new JButton("");
		button3.setBounds(1, 840, 50, 50);
		contentPane.add(button3);
		
		JButton button4 = new JButton("");
		button4.setBounds(1487, 840, 50, 50);
		contentPane.add(button4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1, 416, 1, 2);
		contentPane.add(separator);
	}
}
