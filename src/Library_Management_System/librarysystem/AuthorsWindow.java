package Library_Management_System.librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthorsWindow implements WindowManager{

	private JFrame frame;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldTel;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldZip;
	private PanelAddBook panelAddBook;
	private JTextField textFieldState;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AuthorsWindow window = new AuthorsWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	/**
	 * Create the application.
	 */
	public AuthorsWindow(PanelAddBook panelAddBook) {
		initialize();
		centerFrameOnDesktop(frame);
		this.panelAddBook = panelAddBook;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1.setBounds(68, 53, 104, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(218, 52, 190, 31);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(68, 111, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(218, 110, 190, 31);
		frame.getContentPane().add(textFieldLastName);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telephone");
		lblNewLabel_1_2.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(68, 173, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(218, 172, 190, 31);
		frame.getContentPane().add(textFieldTel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Street");
		lblNewLabel_1_3.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(68, 234, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textFieldStreet = new JTextField();
		textFieldStreet.setColumns(10);
		textFieldStreet.setBounds(218, 233, 190, 31);
		frame.getContentPane().add(textFieldStreet);
		
		JLabel lblNewLabel_1_4 = new JLabel("City");
		lblNewLabel_1_4.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(68, 290, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(218, 289, 190, 31);
		frame.getContentPane().add(textFieldCity);
		
		JLabel lblNewLabel_1_5 = new JLabel("ZipCode");
		lblNewLabel_1_5.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(68, 407, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		textFieldZip = new JTextField();
		textFieldZip.setColumns(10);
		textFieldZip.setBounds(218, 406, 190, 31);
		frame.getContentPane().add(textFieldZip);
		
		JLabel lblNewLabel_1_6 = new JLabel("Bio");
		lblNewLabel_1_6.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(68, 468, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(218, 468, 190, 82);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_7 = new JLabel("Add new Author");
		lblNewLabel_1_7.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(207, 0, 163, 31);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMsg=UIValidationRuleSet.addAuthorValidation(textFieldFirstName.getText(), textFieldLastName.getText(), 
						textFieldTel.getText(),textFieldState.getText(),textFieldCity.getText(), textFieldStreet.getText(), 
						textFieldZip.getText()
				);
				
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				
				panelAddBook.setAuthors(textFieldFirstName.getText(), textFieldLastName.getText(), 
						textFieldTel.getText(),textFieldStreet.getText(), textFieldCity.getText(), textFieldState.getText(),
						textFieldZip.getText(), textArea.getText(), lblNewLabel_1_7.getText());
			}
		});
		btnNewButton.setBounds(207, 576, 190, 43);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("State");
		lblNewLabel_1_4_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_4_1.setBounds(68, 345, 104, 31);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		textFieldState = new JTextField();
		textFieldState.setColumns(10);
		textFieldState.setBounds(218, 344, 190, 31);
		frame.getContentPane().add(textFieldState);
	}
}
