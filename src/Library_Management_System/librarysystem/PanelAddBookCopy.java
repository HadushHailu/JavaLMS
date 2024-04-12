package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelAddBookCopy extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtIsbn;
	private JTextField txtNoOfCopy;
	private DefaultTableModel model;
	private  ControllerInterface ci = new SystemController();
	private JTable table;

	public void initJTable() {
		model = new DefaultTableModel();
		String[] column = {"Book ISBN","BOOK title","Copy Number"};
		table.setModel(model);
		model.setColumnIdentifiers(column);
		viewBook();
	}
	
	public void viewBook() {
		model.setRowCount(0);
		List<Book> bookList = ci.allBooks();
		
		Book book = null;
		for(Book b: bookList) {
			if(b.getIsbn().equals(txtIsbn.getText())) {
				book = b;
			}
		}
		
		String[] row = new String[5];
	
		row[0] = book.getIsbn();
		row[1] = book.getTitle();
		row[2] = Integer.toString(book.getCopyNums().size());
		model.addRow(row);
		}
	
	/**
	 * Create the panel.
	 */
	public PanelAddBookCopy() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 24, 1142, 178);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Book Copy");
		lblNewLabel.setBounds(190, 0, 266, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ISBN");
		lblNewLabel_1.setBounds(131, 65, 103, 28);
		panel.add(lblNewLabel_1);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(476, 66, 207, 28);
		panel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Copy");
		btnNewButton.setBounds(476, 140, 219, 28);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("No of Copies");
		lblNewLabel_1_1.setBounds(126, 99, 247, 28);
		panel.add(lblNewLabel_1_1);
		
		txtNoOfCopy = new JTextField();
		txtNoOfCopy.setBounds(476, 100, 77, 28);
		panel.add(txtNoOfCopy);
		txtNoOfCopy.setText("1");
		txtNoOfCopy.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 232, 1146, 456);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtIsbn.toString().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter ISBN");
					return;
				}
				List<Book> bookList=ci.allBooks();
				Book book=null;
				int i;
				for(i=0;i<bookList.size();i++) {
					if(bookList.get(i).getIsbn().equals(txtIsbn.getText())){
						book=bookList.get(i);
						break;
					}
				}
				if(book==null) {
					JOptionPane.showMessageDialog(null,"Book not found!!");
					return;
				}
				
				book.addCopy( Integer.valueOf(txtNoOfCopy.getText()));
				bookList.add(i, book);
				
				initJTable();
			}
		});

	}
}
