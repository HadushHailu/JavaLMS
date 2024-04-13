package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.BookCopy;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;
import Library_Management_System.dataaccess.Auth;
import Library_Management_System.dataaccess.User;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelCheckoutBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBookIsbn;
	private JTextField txtMemberId;
	private JTable tableRecord;
	private JTable tableBook;
	private  ControllerInterface ci = new SystemController();
	private DefaultTableModel modelRecord = new DefaultTableModel();
	private DefaultTableModel modelBook = new DefaultTableModel();
	private Random rand = new Random();
	private User session = SystemController.session;

	/**
	 * Create the panel.
	 */
	
	public void logicAddBook() {
		viewBookISBN();
		//get Member
		List<LibraryMember> memberList=ci.allMembers();
		LibraryMember member=null;
		int i;
		for(i=0;i<memberList.size();i++) {
			if(memberList.get(i).getMemberId().equals(txtMemberId.getText())) {
				member=memberList.get(i);
				break;
			}
		}
		if(member==null) {
			return;
		}
		
		//get Book
		List<Book> bookList=ci.allBooks();
		BookCopy bcc = null;
		for(Book book: bookList) {
			for(BookCopy bc: book.getCopies()) {
				if(book.getTitle().equals("Antartica") && bc.getCopyNum() == 1) {
					System.out.println("This book");
					bc.changeAvailability();
					bcc = bc;
				}
				System.out.println("Book info: " + book.getTitle()+ " "+bc.getCopyNum() +" " + bc.isAvailable());
			}
		}
				
		User user = new User("123", "123", Auth.LIBRARIAN);
		ci.addCheckoutEntry(
				Integer.toString(rand.nextInt(1000)),
				member,
				user,
				bcc,
				LocalDate.now(),
				LocalDate.now().plusDays(20)
				);
		ci.addBook(bookList);
	}
	
	public void logic2AddBook() {
		viewBookISBN();
//		String memberId=txtMemberId.getText();
//		String bookIsbn=txtBookIsbn.getText();
//		if(memberId.isEmpty()||bookIsbn.isEmpty()) {
//			return;
//		}
//		
		//verify memberID do in separate method and check whether member is null or not
		List<LibraryMember> memberList=ci.allMembers();
		LibraryMember member=null;
		int i;
		for(i=0;i<memberList.size();i++) {
			if(memberList.get(i).getMemberId().equals(txtMemberId.getText())) {
				member=memberList.get(i);
				break;
			}
		}
		if(member==null) {
			//show error message
			return;
		}
		
//		//verify book isbn do in separate method and check whether book is null or not
		boolean isCopyAvailable = false;
		List<Book> bookList=ci.allBooks();
		Book book=null;
		for(int j=0;j<bookList.size();j++) {
			if(bookList.get(j).getIsbn().equals(txtBookIsbn.getText())){
				book=bookList.get(j);
				if(book.getNextAvailableCopy() != null) {
					BookCopy bc = book.getNextAvailableCopy();
					System.out.println("BookCopy num:" + bc.getCopyNum());
					System.out.println("BookCopy avialability:" + bc.isAvailable());
					System.out.println("Copy available");
					bc.changeAvailability();
					System.out.println("Now BookCopy avialability:" + bc.isAvailable());
					isCopyAvailable = true;
					
					User user = new User("123", "123", Auth.LIBRARIAN);
					ci.addCheckoutEntry(
							Integer.toString(rand.nextInt(1000)),
							member,
							user,
							bc,
							LocalDate.now(),
							LocalDate.now().plusDays(book.getMaxCheckoutLength())
							);
					ci.addBook(bookList);
					break;
				}else {
					System.out.println("NO available copy!");
				}
			}
			
		}
		
		if(book==null) {
			//show error message
			JOptionPane.showMessageDialog(null,"Book not found!!");
			return;
		}
		
		viewRecord();
	}
	public void initJTableRecord() {
		String[] column = {"Entry id", "Member ID", "Member Full Name", "Book title", "Checkout Date", "Due Date"};
		tableRecord.setModel(modelRecord);
		modelRecord.setColumnIdentifiers(column);
		viewRecord();
	}
	
	public void initJTableBook() {
		String[] column = {"Book ISBN", "Book title", "Available copies", "Loan period", "Due Date"};
		tableBook.setModel(modelBook);
		modelBook.setColumnIdentifiers(column);
		viewBook();
	}
	
	public void viewRecord() {
		modelRecord.setRowCount(0);
		List<CheckoutEntry> entryList = ci.allCheckoutEntry();
		
		String[] row = new String[7];
	
 		for(CheckoutEntry entry: entryList) {
			row[0] = entry.getReocordId();
			row[1] = entry.getMember().getMemberId();
			//row[2] = entry.getUser().getAuthorization().toString();
			row[2] = entry.getMember().getFirstName() + " " + entry.getMember().getLastName();
			row[3] = entry.getBookCopy().getBook().getTitle();
			row[4] = entry.getCheckoutDate().toString();
			row[5] = entry.getDueDate().toString();
			modelRecord.addRow(row);
		}
		
	}
	public void viewBook() {
		modelBook.setRowCount(0);
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
			modelBook.addRow(row);
		}
		
	}
	
	public void viewBookISBN() {
		modelBook.setRowCount(0);
		List<Book> bookList = ci.allBooks();
		
		String[] row = new String[5];
	
		Book b = null;
 		for(Book book: bookList) {
 			System.out.println(book.getIsbn() + " " + txtBookIsbn.getText());
 			if(book.getIsbn().equals(txtBookIsbn.getText())) {
 				System.out.println("They are equall");
 				b = book;
 				break;
 			}
		}
 		
 		if(b != null) {
	 		row[0] = b.getIsbn();
			row[1] = b.getTitle();
			row[2] = Integer.toString(b.getCopyNums().size());
			row[3] = Integer.toString(b.getMaxCheckoutLength());
			
			//Authors
			row[4] = "";
			for(Author a: b.getAuthors()) {
				row[4] += a.getFirstName() + ", ";
			}
			modelBook.addRow(row);
			
			BookCopy bc = b.getNextAvailableCopy();
			if( bc != null) {
				System.out.println(bc.getCopyNum());
				bc.changeAvailability();
			}else {
				System.out.println("Not available!");
				JOptionPane.showMessageDialog(null,"Book Not available!");
			}
 		}
 		else {
 			JOptionPane.showMessageDialog(null,"Invalid ISBN!");
 		}
	}
	
	public PanelCheckoutBook() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBorder(new LineBorder(new Color(0, 128, 0), 1, true));
		panel.setBounds(45, 12, 1143, 147);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMemberId = new JLabel("Member  ID");
		lblMemberId.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblMemberId.setBounds(138, 32, 144, 40);
		panel.add(lblMemberId);
		
		JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblBookIsbn.setBounds(138, 84, 105, 40);
		panel.add(lblBookIsbn);
		
		txtBookIsbn = new JTextField();
		txtBookIsbn.setBounds(250, 89, 186, 35);
		panel.add(txtBookIsbn);
		txtBookIsbn.setColumns(10);
		
		txtMemberId = new JTextField();
		txtMemberId.setBounds(250, 32, 186, 35);
		panel.add(txtMemberId);
		txtMemberId.setColumns(10);
		
		JButton btnSearch = new JButton("Search ISBN");
		btnSearch.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnSearch.setBounds(470, 68, 161, 56);
		panel.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMsg=UIValidationRuleSet.checkoutValidation(txtBookIsbn.getText());
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				
				viewBookISBN();
			}
		});
		
		JButton btnSearch_1 = new JButton("Checkout Book");
		btnSearch_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMsg=UIValidationRuleSet.checkoutValidation(txtMemberId.getText(),txtBookIsbn.getText());
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				
				String res=ci.addCheckoutEntry(txtMemberId.getText(), txtBookIsbn.getText(), session);
				if(res=="ok") {
					JOptionPane.showMessageDialog(null,"Checkout successfully!");
					viewRecord();
					viewBook();
					txtBookIsbn.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null,res);
				}
				
			}
		});
		btnSearch_1.setBounds(670, 68, 186, 56);
		panel.add(btnSearch_1);
		//btnSearch_1.setEnabled(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new LineBorder(new Color(0, 128, 0)));
		panel_1.setBounds(510, 171, 678, 522);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 66, 678, 456);
		panel_1.add(scrollPane);
		
		tableRecord = new JTable();
		scrollPane.setViewportView(tableRecord);
		
		JLabel lblRecordInformation = new JLabel("Checkout Entry information");
		lblRecordInformation.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblRecordInformation.setBounds(149, 12, 237, 40);
		panel_1.add(lblRecordInformation);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/icons8-info-30.png"));
		lblNewLabel.setBounds(116, 6, 43, 48);
		panel_1.add(lblNewLabel);
		
		JButton btnRefreshBookRecord = new JButton("Refresh");
		btnRefreshBookRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Refresh book record
				viewRecord();
			}
		});
		btnRefreshBookRecord.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnRefreshBookRecord.setBounds(386, 9, 182, 46);
		panel_1.add(btnRefreshBookRecord);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBorder(new LineBorder(new Color(0, 128, 0)));
		panel_2.setBounds(46, 172, 434, 521);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 66, 434, 455);
		panel_2.add(scrollPane_1);
		
		tableBook = new JTable();
		scrollPane_1.setViewportView(tableBook);
		
		JLabel lblBookInformation = new JLabel("Book Information");
		lblBookInformation.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblBookInformation.setBounds(55, 12, 170, 40);
		panel_2.add(lblBookInformation);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBook();
			}
		});
		btnRefresh.setBounds(220, 8, 182, 46);
		panel_2.add(btnRefresh);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/icons8-info-30.png"));
		lblNewLabel_1.setBounds(22, 6, 43, 48);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(22, 6, 43, 48);
		panel_2.add(lblNewLabel_2);
		//table.setEnabled(false);
		initJTableRecord();
		initJTableBook();

	}
}
