package Library_Management_System.librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class DashboardWindow implements WindowManager{

	private JFrame frame;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 968, 807);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
