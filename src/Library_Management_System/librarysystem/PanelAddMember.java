package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

import javax.swing.JButton;
import javax.swing.JTable;

public class PanelAddMember extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	private  ControllerInterface ci = new SystemController();

	/**
	 * Create the panel.
	 */
	public void initJTable() {
		model = new DefaultTableModel();
		String[] column = {"ID","Book Name","Author"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		viewBook();
	}
	

	/**
	 * View Book
	 */
	public void viewBook() {
		List<Book> bookList = ci.allBooks();
		String[] row = new String[3];
		for(int i = 0; i < 10; i++) {
 		for(Book book: bookList) {
			System.out.println(book.getIsbn());
			
			//Authors
			row[0] = "";
			for(Author s: book.getAuthors())
				row[0] += s.getFirstName();
			//IDs
			row[1] = book.getTitle();
			row[2] = book.getIsbn();
			model.addRow(row);
		}
		}
	}
	
	public PanelAddMember() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 23, 1151, 107);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 12, 70, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(26, 56, 70, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(375, 12, 70, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(375, 67, 70, 15);
		panel.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(126, 10, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 160, 1151, 107);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(37, 41, 117, 25);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 290, 1141, 390);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		initJTable();

	}
}
