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
		panel.setBounds(21, 23, 1167, 303);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(53, 39, 33, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(169, 37, 115, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setBounds(441, 46, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(518, 37, 219, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdn7Days = new JRadioButton("7 days");
		rdn7Days.setBounds(571, 95, 92, 23);
		panel.add(rdn7Days);
		
		JRadioButton rdn21Days = new JRadioButton("21 days");
		rdn21Days.setBounds(667, 95, 115, 23);
		panel.add(rdn21Days);
		
		JLabel lblNewLabel_3 = new JLabel("Due Length");
		lblNewLabel_3.setBounds(436, 99, 105, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblTotalCopies = new JLabel("Total Copies");
		lblTotalCopies.setBounds(53, 81, 76, 20);
		panel.add(lblTotalCopies);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 82, 115, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAddAuthors = new JButton("Add Author");
		btnAddAuthors.setBounds(53, 151, 130, 34);
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
		btnNewButton_1.setBounds(53, 223, 161, 42);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(261, 223, 179, 42);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add new Book");
		lblNewLabel_1_1.setBounds(345, 12, 115, 14);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 356, 1166, 330);
		add(panel_1);
		panel_1.setLayout(null);

	}
}
