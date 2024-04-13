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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

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
	private JTextArea textAreaBio;

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
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent the default close operation
	
		frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            int choice = JOptionPane.showConfirmDialog(frame, "Do you really want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	            	panelAddBook.returnFromAuthor();
	                //frame.dispose(); // Close the frame
	            }
	        }
	    });
		this.panelAddBook = panelAddBook;
	}
	
	
	public void clearFields() {
		textFieldFirstName.setText("");
		textFieldLastName.setText("");
		textFieldTel.setText("");
		textFieldStreet.setText("");
		textFieldCity.setText("");
		textFieldZip.setText("");
		textFieldState.setText("");
		textAreaBio.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 619, 786);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(68, 52, 468, 605);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(46, 20, 104, 31);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(168, 13, 227, 43);
		panel.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(46, 77, 104, 31);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(168, 70, 227, 43);
		panel.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telephone");
		lblNewLabel_1_2.setBounds(46, 139, 104, 31);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(168, 132, 227, 43);
		panel.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Street");
		lblNewLabel_1_3.setBounds(46, 200, 104, 31);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldStreet = new JTextField();
		textFieldStreet.setBounds(168, 193, 227, 43);
		panel.add(textFieldStreet);
		textFieldStreet.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("City");
		lblNewLabel_1_4.setBounds(46, 256, 104, 31);
		panel.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(168, 249, 227, 43);
		panel.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("ZipCode");
		lblNewLabel_1_5.setBounds(46, 369, 104, 31);
		panel.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldZip = new JTextField();
		textFieldZip.setBounds(168, 366, 227, 36);
		panel.add(textFieldZip);
		textFieldZip.setColumns(10);
		
		JLabel lblNewLabel_1_6 = new JLabel("Bio");
		lblNewLabel_1_6.setBounds(46, 432, 104, 31);
		panel.add(lblNewLabel_1_6);
		lblNewLabel_1_6.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textAreaBio = new JTextArea();
		textAreaBio.setFont(new Font("FreeSans", Font.PLAIN, 16));
		textAreaBio.setText("Short Bio..");
		textAreaBio.setLineWrap(true);
		textAreaBio.setBounds(168, 423, 227, 87);
		panel.add(textAreaBio);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnNewButton.setBounds(31, 536, 178, 57);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("State");
		lblNewLabel_1_4_1.setBounds(46, 311, 104, 31);
		panel.add(lblNewLabel_1_4_1);
		lblNewLabel_1_4_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		
		textFieldState = new JTextField();
		textFieldState.setBounds(168, 304, 227, 43);
		panel.add(textFieldState);
		textFieldState.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnClear.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnClear.setBounds(265, 536, 178, 57);
		panel.add(btnClear);
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
						textFieldZip.getText(), textAreaBio.getText().toString());
			}
		});
		
		JLabel lblNewLabel_1_7 = new JLabel("Add new Author");
		lblNewLabel_1_7.setFont(new Font("FreeSans", Font.BOLD, 20));
		lblNewLabel_1_7.setBounds(187, 9, 163, 31);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddBook.returnFromAuthor();
			}
		});
		btnReturn.setBackground(SystemColor.scrollbar);
		btnReturn.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnReturn.setBounds(96, 669, 418, 57);
		frame.getContentPane().add(btnReturn);
	}
}
