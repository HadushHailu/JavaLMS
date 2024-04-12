package Library_Management_System.librarysystem;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;


import Library_Management_System.controller.SystemController;
import Library_Management_System.controller.ControllerInterface;

public class MainWindow implements WindowManager {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
    private ControllerInterface ci = new SystemController();
    private DashboardWindow db = new DashboardWindow();

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
	
	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}
	
	public MainWindow() {
		initialize();
		centerFrameOnDesktop(frame);
	}

	/**
	 * Enable/Disable this frames visibility
	 */
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public void goToDashBoard() {
		db.toDashboard(true, this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	
	public JFrame getFrame() {
		return frame;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean loginStatus = ci.login(textField.getText(), passwordField.getText());
				//loginStatus =true;
				if(loginStatus) {
					JOptionPane.showMessageDialog(null,"Successful Login!");
					frame.setVisible(false);
					//db.setVisible(true);
					goToDashBoard();
				}else {
					JOptionPane.showMessageDialog(null,"Login Failed!");
				}
			}
		});
		btnNewButton.setBounds(264, 415, 272, 41);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("C059", Font.BOLD, 45));
		lblLogin.setBounds(292, 128, 323, 92);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUserId.setBounds(264, 232, 125, 34);
		frame.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(264, 266, 272, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(264, 312, 125, 34);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(264, 358, 272, 34);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon("~/Documents/MIU/MPP/JavaLMS/img/library.jpg").getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(94, 171, 409, 312);
		frame.getContentPane().add(lblNewLabel);
	}
}
