package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Library_Management_System.business.Address;
import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelAddBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textIsbn;
	private JTextField texttitle;
	private JTextField textTotalCopy;
	private JRadioButton rdn7Days;
	private JRadioButton rdn21Days;
	private JLayeredPane layeredPane=new JLayeredPane();
	private JTable table;
	private DefaultTableModel model;
	private AuthorsWindow authorWindow;
	private List<Author> authorList = new ArrayList<>();
	private  ControllerInterface ci = new SystemController();

	/**
	 * Create the panel.
	 */
	public void initJTable() {
		model = new DefaultTableModel();
		String[] column = {"Book ISBN","BOOK title","Number of Copies", "Length", "Author"};
		table.setModel(model);
		model.setColumnIdentifiers(column);
		viewBook();
	}
	
	/**
	 * View Book
	 */
	public void viewBook() {
		model.setRowCount(0);
		List<Book> bookList = ci.allBooks();
		
		String[] row = new String[5];
	
 		for(Book book: bookList) {
			row[0] = book.getIsbn();
			row[1] = book.getTitle();
			row[2] = Integer.toString(book.getCopyNums().size());
			row[3] = Integer.toString(book.getMaxCheckoutLength());
			
			//Authors
			row[4] = "";
			for(Author a: book.getAuthors()) {
				row[4] += a.getFirstName() + ", ";
			}
			model.addRow(row);
		}
		
	}
	
	public void setAuthors(String fname, String lname, 
			               String tel, String street, String city, String state,
			               String zip, String zipCode, String bio){
		Author a = new Author(fname, lname, tel, new Address(street, city, state, zipCode), bio);
		authorList.add(a);
		authorWindow.setVisible(false);
		
	}
	public void clearBook() {
		textIsbn.setText("");
		texttitle.setText("");
		textTotalCopy.setText("");
		rdn7Days.setSelected(false);
		authorList.clear();
	}
		
	public PanelAddBook() {
		authorWindow = new AuthorsWindow(this);
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 23, 1167, 303);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(53, 39, 33, 14);
		panel.add(lblNewLabel_1);
		
		textIsbn = new JTextField();
		textIsbn.setBounds(169, 37, 115, 20);
		panel.add(textIsbn);
		textIsbn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setBounds(441, 46, 46, 14);
		panel.add(lblNewLabel_2);
		
		texttitle = new JTextField();
		texttitle.setBounds(518, 37, 219, 34);
		panel.add(texttitle);
		texttitle.setColumns(10);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
	    rdn7Days = new JRadioButton("7 days");
		rdn7Days.setBounds(571, 95, 92, 23);
		panel.add(rdn7Days);
		buttonGroup.add(rdn7Days);
		
	    rdn21Days = new JRadioButton("21 days");
		rdn21Days.setBounds(667, 95, 115, 23);
		panel.add(rdn21Days);
		buttonGroup.add(rdn21Days);
		
		JLabel lblNewLabel_3 = new JLabel("Due Length");
		lblNewLabel_3.setBounds(436, 99, 105, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblTotalCopies = new JLabel("Total Copies");
		lblTotalCopies.setBounds(53, 81, 98, 20);
		panel.add(lblTotalCopies);
		
		textTotalCopy = new JTextField();
		textTotalCopy.setBounds(169, 82, 115, 20);
		panel.add(textTotalCopy);
		textTotalCopy.setColumns(10);
		
		JButton btnAddAuthors = new JButton("Add Author");
		btnAddAuthors.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/icons8-add-button-32.png"));
		btnAddAuthors.setBounds(53, 151, 171, 34);
		//btnAddAuthors.setBackground(new Color(0, 100, 0));
		btnAddAuthors.setForeground(new Color(0, 0, 0));
		btnAddAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authorWindow.setVisible(true);
			}
		});
		panel.add(btnAddAuthors);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = 7;
				if(rdn7Days.isSelected()) {
					length = 7;
				}if(rdn21Days.isSelected()) {
					length = 21;
				}
				
				String errorMsg=UIValidationRuleSet.addbookValidation(textIsbn.getText(), 
						texttitle.getText(), 
						textTotalCopy.getText(),
						authorList);
				
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				
				ci.addBook(textIsbn.getText(), texttitle.getText(), 
						Integer.parseInt(textTotalCopy.getText()), length, authorList);
				
				clearBook();
				viewBook();
			}
		});
				
		btnNewButton_1.setBounds(53, 223, 161, 42);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearBook();
				viewBook();
			}
		});
		btnNewButton_2.setBounds(261, 223, 179, 42);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Add new Book");
		lblNewLabel_1_1.setBounds(345, 12, 115, 14);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 346, 1167, 340);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		initJTable();
	}
}
