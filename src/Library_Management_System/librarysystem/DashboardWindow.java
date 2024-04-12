package Library_Management_System.librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;
import Library_Management_System.dataaccess.Auth;
import Library_Management_System.dataaccess.User;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DashboardWindow implements WindowManager{

	private JFrame frame;
	private JLayeredPane layeredPane;
	private JPanel panelCheckoutRecord;
	private JPanel panelCheckoutBook;
	private JPanel panelViewMember;
	private JPanel panelViewBook;
	private JPanel panelAddMember;
	private JPanel panelAddBook;
	private JPanel panelAddBookCopy;
	private JPanel panelLogout;
    private User session;
    private  ControllerInterface ci = new SystemController();
    
    private MainWindow mainWindow;
    
    JButton btnCheckoutBook;
    JButton btnAddMember;
    JButton btnAddBook;
    JButton btnBookCopy;
	
    JLabel lblSession;

    public void logout() {
    	mainWindow.getFrame().setVisible(true);
    	frame.setVisible(false);
    }
	
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

	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}
	
	/**
	 * Create the application.
	 */
	public DashboardWindow() {
		initialize();
		centerFrameOnDesktop(frame);
	}
	
	public void setSession() {
		
		System.out.println(session.getAuthorization());
		
		if(session.getAuthorization() == Auth.ADMIN) {
			btnCheckoutBook.setEnabled(false);
			lblSession.setText("ADMIN");
		}
		
		if(session.getAuthorization() == Auth.LIBRARIAN) {
		    btnAddMember.setEnabled(false);
		    btnAddBook.setEnabled(false);
		    btnBookCopy.setEnabled(false);	
		    lblSession.setText("LIBRARIAN");
		}
		if(session.getAuthorization() == Auth.BOTH) {
			lblSession.setText("SUPER");
		}
		
	}
	
	/**
	 * Enable/Disable this frames visibility
	 */
	public void setVisible(boolean b) {
		frame.setVisible(b);
		session = ((SystemController)ci).session;
		setSession();
	}
	
	public void toDashboard(boolean b, MainWindow mainWindow) {
		frame.setVisible(b);
		session = ((SystemController)ci).session;
		setSession();
		this.mainWindow = mainWindow;
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
		frame.getContentPane().setBackground(new Color(238, 238, 236));
		frame.setBounds(100, 100, 1300, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTab = new JPanel();
		panelTab.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTab.setBounds(33, 170, 1234, 79);
		frame.getContentPane().add(panelTab);
		panelTab.setLayout(null);
		
		btnAddMember = new JButton("Add Member ");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAddMember);
			}
		});
		btnAddMember.setBounds(904, 12, 207, 51);
		panelTab.add(btnAddMember);
		
		btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAddBook);
			}
		});
		btnAddBook.setBounds(321, 12, 207, 51);
		panelTab.add(btnAddBook);
		
		btnBookCopy = new JButton("Add Book Copy");
		btnBookCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAddBookCopy);
			}
		});
		btnBookCopy.setBounds(620, 12, 212, 51);
		panelTab.add(btnBookCopy);
		
		btnCheckoutBook = new JButton("Checkout Book");
		//btnCheckoutBook.setBorder(BorderFactory.createLineBorder(Color.blue));
		//btnCheckoutBook.setBackground(new Color(255, 228, 196));
		btnCheckoutBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCheckoutBook);
			}
		});
		btnCheckoutBook.setBounds(10, 12, 220, 51);
		panelTab.add(btnCheckoutBook);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(33, 261, 1234, 699);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelCheckoutBook = new PanelCheckoutBook();
		panelCheckoutBook.setBackground(new Color(252, 233, 79));
		layeredPane.add(panelCheckoutBook);
		panelCheckoutBook.setLayout(null);
			
		panelCheckoutRecord = new JPanel();
		panelCheckoutRecord.setBackground(new Color(114, 159, 207));
		layeredPane.add(panelCheckoutRecord);
		panelCheckoutRecord.setLayout(null);
		
		JLabel lblCheckoutMember = new JLabel("Checkout Member");
		lblCheckoutMember.setBounds(328, 333, 373, 149);
		panelCheckoutRecord.add(lblCheckoutMember);
		
		panelAddBook = new PanelAddBook();
		panelAddBook.setBackground(new Color(245, 222, 179));
		layeredPane.add(panelAddBook);
		panelAddBook.setLayout(null);
		
		panelAddBookCopy = new PanelAddBookCopy();
		layeredPane.add(panelAddBookCopy);
		panelAddBookCopy.setLayout(null);
		
		panelViewMember = new JPanel();
		panelViewMember.setBackground(Color.ORANGE);
		layeredPane.add(panelViewMember, "name_22649802221187");
		panelViewMember.setLayout(null);
		
		JLabel lblViewMember = new JLabel("View Member");
		lblViewMember.setBounds(317, 338, 373, 149);
		panelViewMember.add(lblViewMember);
		
		panelViewBook = new PanelViewBook();
		panelViewBook.setBackground(new Color(245, 222, 179));
		layeredPane.add(panelViewBook);
		panelViewBook.setLayout(null);
		
		JLabel lblViewBook = new JLabel("Search");
		lblViewBook.setBounds(245, 318, 373, 149);
		panelViewBook.add(lblViewBook);
		
		panelAddMember = new PanelAddMember();
		panelAddMember.setBackground(new Color(224, 255, 255));
		layeredPane.add(panelAddMember);
		panelAddMember.setLayout(null);
		
		panelLogout = new PanelLogout();
		panelLogout.setBackground(new Color(224, 0, 0));
		layeredPane.add(panelLogout);
		panelLogout.setLayout(null);
		
		JLabel lblLogoutPanel_1 = new JLabel("Logout search");
		lblLogoutPanel_1.setBounds(194, 275, 373, 149);
		panelAddMember.add(lblLogoutPanel_1);
		
		ImageIcon image = new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/icons8-user-100.png");
		JLabel lblAuthoIcon = new JLabel(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/user(2).png"));
		lblAuthoIcon.setBounds(1121, 28, 76, 64);
		frame.getContentPane().add(lblAuthoIcon);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/Double-J-Design-Ravenna-3d-Books.128.png"));
		lblNewLabel_1.setBounds(536, 0, 146, 158);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLibray = new JLabel("Libray");
		lblLibray.setForeground(new Color(210, 105, 30));
		lblLibray.setFont(new Font("FreeSans", Font.BOLD, 50));
		lblLibray.setBounds(665, 36, 167, 46);
		frame.getContentPane().add(lblLibray);
		
		JLabel lblManagement = new JLabel("Management System ®");
		lblManagement.setForeground(new Color(46, 139, 87));
		lblManagement.setFont(new Font("FreeSans", Font.BOLD, 18));
		lblManagement.setBounds(675, 85, 204, 28);
		frame.getContentPane().add(lblManagement);
		
		lblSession = new JLabel("Librarian");
		lblSession.setBounds(1197, 30, 70, 28);
		frame.getContentPane().add(lblSession);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logout();
			}
		});
		lblLogout.setBounds(1197, 60, 70, 15);
		frame.getContentPane().add(lblLogout);
		
//		JLabel lblLogoutPanel = new JLabel("Logout Panel");
//		lblLogoutPanel.setBounds(234, 330, 373, 149);
//		panelLogout.add(lblLogoutPanel);
	}
}
