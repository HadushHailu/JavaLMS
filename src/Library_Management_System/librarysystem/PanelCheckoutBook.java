package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelCheckoutBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelCheckoutBook() {
		setLayout(null);
		
		JLabel lblMemberId = new JLabel("Member  ID");
		lblMemberId.setBounds(181, 56, 105, 40);
		add(lblMemberId);
		
		JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setBounds(181, 119, 105, 40);
		add(lblBookIsbn);
		
		textField = new JTextField();
		textField.setBounds(310, 125, 151, 29);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(310, 62, 151, 29);
		add(textField_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(510, 123, 151, 33);
		add(btnSearch);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(701, 123, 151, 33);
		add(btnSearch_1);
		
		table = new JTable();
		table.setBounds(61, 198, 1103, 470);
		add(table);

	}
}
