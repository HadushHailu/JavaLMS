package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class PanelDefault extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelDefault() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/lib222.png"));
		lblNewLabel.setBounds(368, 203, 677, 502);
		add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblWelcome.setFont(new Font("FreeSans", Font.BOLD, 76));
		lblWelcome.setBounds(428, 123, 381, 130);
		add(lblWelcome);

	}

}
