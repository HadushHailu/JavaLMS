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
		lblNewLabel.setIcon(new ImageIcon(PanelDefault.class.getResource("/img/b96d5fb990ab8767ae3e5bde1dcce65b.jpg")));
		lblNewLabel.setBounds(438, 216, 402, 418);
		add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblWelcome.setFont(new Font("FreeSans", Font.BOLD, 76));
		lblWelcome.setBounds(412, 122, 381, 130);
		add(lblWelcome);

	}

}
