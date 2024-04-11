package Library_Management_System.librarysystem;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

public class PanelCheckoutRecord extends JPanel {

	private static final long serialVersionUID = 1L;
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
	
	public PanelCheckoutRecord() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 1176, 622);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		initJTable();

	}

}
