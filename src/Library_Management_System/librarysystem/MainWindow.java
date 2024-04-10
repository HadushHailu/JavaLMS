package Library_Management_System.librarysystem;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Library_Management_System.dataaccess.Auth;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 738);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashboardWindow(Auth.ADMIN);
			}
		});
		btnNewButton.setBounds(585, 412, 272, 41);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("C059", Font.BOLD, 45));
		lblLogin.setBounds(613, 125, 323, 92);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUserId.setBounds(585, 229, 125, 34);
		frame.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(585, 263, 272, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(585, 309, 125, 34);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(585, 355, 272, 34);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon("~/Documents/MIU/MPP/JavaLMS/img/library.jpg").getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(94, 171, 409, 312);
		frame.getContentPane().add(lblNewLabel);
	}
}
