package Library_Management_System.librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class DashboardWindow implements WindowManager{

	private JFrame frame;
	private JLayeredPane layeredPane;
	JPanel panelCheckoutRecord;
	JPanel panelCheckoutBook;
	JPanel panelViewMember;
	JPanel panelViewBook;
	JPanel panelSearch;
	JPanel panelLogout;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardWindow window = new DashboardWindow();
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
	public DashboardWindow() {
		initialize();
	}
	
	/**
	 * Enable/Disable this frames visibility
	 */
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1363, 981);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.focus"));
		panel.setBounds(12, 29, 231, 903);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCheckoutBook = new JButton("Checkout Record");
		btnCheckoutBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCheckoutRecord);
			}
		});
		btnCheckoutBook.setBounds(23, 252, 184, 37);
		panel.add(btnCheckoutBook);
		
		JButton btnCheckoutBook_1 = new JButton("Checkout Book");
		btnCheckoutBook_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCheckoutRecord);
			}
		});
		btnCheckoutBook_1.setBounds(23, 159, 184, 37);
		panel.add(btnCheckoutBook_1);
		
		JButton btnViewMemebers = new JButton("View Memebers");
		btnViewMemebers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelViewMember);
			}
			
		});
		btnViewMemebers.setBounds(23, 361, 184, 37);
		panel.add(btnViewMemebers);
		
		JButton btnCheckoutBook_2_1 = new JButton("View Books");
		btnCheckoutBook_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelViewBook);
			}
		});
		btnCheckoutBook_2_1.setBounds(23, 464, 184, 37);
		panel.add(btnCheckoutBook_2_1);
		
		JButton btnCheckoutBook_2_1_1 = new JButton("Search ");
		btnCheckoutBook_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSearch);
			}
		});
		btnCheckoutBook_2_1_1.setBounds(23, 587, 184, 37);
		panel.add(btnCheckoutBook_2_1_1);
		
		JButton btnCheckoutBook_2_1_1_1 = new JButton("Logout");
		btnCheckoutBook_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSearch);
			}
		});
		btnCheckoutBook_2_1_1_1.setBounds(23, 709, 184, 37);
		panel.add(btnCheckoutBook_2_1_1_1);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(255, 29, 1064, 893);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelCheckoutBook = new JPanel();
		panelCheckoutBook.setBackground(new Color(252, 233, 79));
		layeredPane.add(panelCheckoutBook, "name_22549706918724");
		panelCheckoutBook.setLayout(null);
		
		JLabel lblCheckoutBook = new JLabel("Checkout Book");
		lblCheckoutBook.setBounds(356, 339, 373, 149);
		panelCheckoutBook.add(lblCheckoutBook);
		
		panelCheckoutRecord = new JPanel();
		panelCheckoutRecord.setBackground(new Color(114, 159, 207));
		layeredPane.add(panelCheckoutRecord, "name_22646448329131");
		panelCheckoutRecord.setLayout(null);
		
		JLabel lblCheckoutMember = new JLabel("Checkout Member");
		lblCheckoutMember.setBounds(328, 333, 373, 149);
		panelCheckoutRecord.add(lblCheckoutMember);
		
		panelViewMember = new JPanel();
		panelViewMember.setBackground(Color.ORANGE);
		layeredPane.add(panelViewMember, "name_22649802221187");
		panelViewMember.setLayout(null);
		
		JLabel lblViewMember = new JLabel("View Member");
		lblViewMember.setBounds(317, 338, 373, 149);
		panelViewMember.add(lblViewMember);
		
		panelViewBook = new JPanel();
		panelViewBook.setBackground(new Color(245, 222, 179));
		layeredPane.add(panelViewBook, "name_22655784066342");
		panelViewBook.setLayout(null);
		
		JLabel lblViewBook = new JLabel("Search");
		lblViewBook.setBounds(245, 318, 373, 149);
		panelViewBook.add(lblViewBook);
		
		panelSearch = new JPanel();
		panelSearch.setBackground(new Color(224, 255, 255));
		layeredPane.add(panelSearch, "name_22660738656236");
		panelSearch.setLayout(null);
		
		JLabel lblLogoutPanel_1 = new JLabel("Logout Panel");
		lblLogoutPanel_1.setBounds(194, 275, 373, 149);
		panelSearch.add(lblLogoutPanel_1);
		
		panelLogout = new JPanel();
		panelLogout.setBackground(new Color(238, 232, 170));
		layeredPane.add(panelLogout, "name_22663689985961");
		panelLogout.setLayout(null);
		
		JLabel lblLogoutPanel = new JLabel("Logout Panel");
		lblLogoutPanel.setBounds(234, 330, 373, 149);
		panelLogout.add(lblLogoutPanel);
	}
}
