package Library_Management_System.librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Library_Management_System.dataaccess.Auth;

import java.awt.Color;

public class DashboardWindow {

	private JFrame frame;
	private Auth auth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardWindow window = new DashboardWindow(Auth.BOTH);
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
	public DashboardWindow(Auth auth) {
		this.auth=auth;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 748, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 722, 421);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dashoard", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("View Books", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("View Members", null, panel_2, null);
		
		//if(auth==Auth.ADMIN||auth==Auth.BOTH) {
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab("Add Books", null, panel_3, null);
			
			JPanel panel_4 = new JPanel();
			tabbedPane.addTab("Add Member", null, panel_4, null);
		//}
		
		//if(auth==Auth.LIBRARIAN||auth==Auth.BOTH) {
			JPanel panel_5 = new JPanel();
			tabbedPane.addTab("Checkout", null, panel_5, null);
			
			JPanel panel_6 = new JPanel();
			tabbedPane.addTab("Checkout Records", null, panel_6, null);
		//}
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Logout", null, panel_7, null);
		
	}

}
