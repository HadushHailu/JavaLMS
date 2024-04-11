package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;

import Library_Management_System.controller.SystemController;
import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.controller.ControllerInterface;

public class PanelViewBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table123;
	private DefaultTableModel model;
	private JPanel panelTable;
	private JScrollPane scrollPane;
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
	
	public PanelViewBook() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 39, 1008, 91);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("#TODO: Buttons and fields for searching book based on different attributes");
		lblNewLabel.setBounds(154, 12, 611, 67);
		panel.add(lblNewLabel);
		
		panelTable = new JPanel();
		panelTable.setBounds(106, 153, 1008, 522);
		add(panelTable);
		panelTable.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1008, 522);
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setBounds(12, 12, 984, 498);
		scrollPane.setViewportView(table);
		
		initJTable();
		
	}
}
