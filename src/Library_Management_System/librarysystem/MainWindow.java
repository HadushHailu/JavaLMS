package Library_Management_System.librarysystem;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent the default close operation
		
		frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            int choice = JOptionPane.showConfirmDialog(frame, "Do you really want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	            	frame.dispose(); // Close the frame
	            }
	        }
	    });
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
	
	public void FromMainWindowOnLogout() {
		frame.setVisible(true);
		textField.setText("");
		passwordField.setText("");
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 769, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(184, 246, 432, 430);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnNewButton.setBounds(52, 280, 333, 72);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setForeground(Color.BLACK);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(142, 24, 143, 92);
		panel.add(lblLogin);
		lblLogin.setFont(new Font("FreeSans", Font.BOLD, 45));
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(53, 142, 125, 34);
		panel.add(lblUserId);
		lblUserId.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setBounds(175, 144, 208, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 196, 125, 34);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 198, 216, 34);
		panel.add(passwordField);
		passwordField.setEchoChar('*');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMsg=UIValidationRuleSet.loginValidation(textField.getText(), passwordField.getText());
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				boolean loginStatus = ci.login(textField.getText(), passwordField.getText());
				//loginStatus =true;
				if(loginStatus) {
					JOptionPane.showMessageDialog(null,"Successful Login!");
					frame.setVisible(false);
					//db.setVisible(true);
					goToDashBoard();
				}else {
					JOptionPane.showMessageDialog(null,"Invalid username or password!");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon("~/Documents/MIU/MPP/JavaLMS/img/library.jpg").getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(94, 171, 409, 312);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainWindow.class.getResource("/img/Double-J-Design-Ravenna-3d-Books.128.png")));
		lblNewLabel_1.setBounds(272, 75, 153, 147);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLibray = new JLabel("Libray");
		lblLibray.setForeground(new Color(210, 105, 30));
		lblLibray.setFont(new Font("FreeSans", Font.BOLD, 50));
		lblLibray.setBounds(402, 102, 167, 46);
		frame.getContentPane().add(lblLibray);
		
		JLabel lblManagement = new JLabel("Management System ®");
		lblManagement.setForeground(new Color(46, 139, 87));
		lblManagement.setFont(new Font("FreeSans", Font.BOLD, 18));
		lblManagement.setBounds(412, 150, 204, 28);
		frame.getContentPane().add(lblManagement);
	}
}
