package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelAddBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLayeredPane layeredPane=new JLayeredPane();

	/**
	 * Create the panel.
	 */
	public PanelAddBook() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 23, 557, 189);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setBounds(158, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(10, 39, 33, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(59, 36, 115, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setBounds(211, 39, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 36, 219, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdn7Days = new JRadioButton("7 days");
		rdn7Days.setBounds(315, 80, 57, 23);
		panel.add(rdn7Days);
		
		JRadioButton rdn21Days = new JRadioButton("21 days");
		rdn21Days.setBounds(389, 80, 70, 23);
		panel.add(rdn21Days);
		
		JLabel lblNewLabel_3 = new JLabel("Due Length");
		lblNewLabel_3.setBounds(240, 84, 56, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblTotalCopies = new JLabel("Total Copies");
		lblTotalCopies.setBounds(10, 81, 76, 20);
		panel.add(lblTotalCopies);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 81, 115, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Authors");
		lblNewLabel_4.setBounds(8, 112, 46, 25);
		panel.add(lblNewLabel_4);
		
		JButton btnAddAuthors = new JButton("Add");
		btnAddAuthors.setBounds(59, 112, 63, 23);
		btnAddAuthors.setBackground(new Color(0, 100, 0));
		btnAddAuthors.setForeground(new Color(0, 0, 0));
		btnAddAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PanelAddAuthors
				//layeredPane.add(new PanelAddAuthors());
			}
		});
		panel.add(btnAddAuthors);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(10, 148, 57, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(83, 148, 70, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 231, 557, 82);
		add(panel_1);
		panel_1.setLayout(null);

	}
}
