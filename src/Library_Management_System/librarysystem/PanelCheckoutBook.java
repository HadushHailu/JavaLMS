package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Library_Management_System.business.Book;
import Library_Management_System.business.CheckoutEntry;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelCheckoutBook extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBookIsbn;
	private JTextField txtMemberId;
	private JTable table;
	private  ControllerInterface ci = new SystemController();

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
		
		txtBookIsbn = new JTextField();
		txtBookIsbn.setBounds(310, 125, 151, 29);
		add(txtBookIsbn);
		txtBookIsbn.setColumns(10);
		
		txtMemberId = new JTextField();
		txtMemberId.setColumns(10);
		txtMemberId.setBounds(310, 62, 151, 29);
		add(txtMemberId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String memberId=txtMemberId.getText();
				String bookIsbn=txtBookIsbn.getText();
				if(memberId.isEmpty()||bookIsbn.isEmpty()) {
					return;
				}
				
				//verify memberID do in separate method and check whether member is null or not
				List<LibraryMember> memberList=ci.allMembers();
				LibraryMember member=null;
				int i;
				for(i=0;i<memberList.size();i++) {
					if(memberList.get(i).getMemberId().equals(memberId)) {
						member=memberList.get(i);
						break;
					}
				}
				if(member==null) {
					//show error message
					return;
				}
				
				//verify book isbn do in separate method and check whether book is null or not
				List<Book> bookList=ci.allBooks();
				Book book=null;
				for(i=0;i<bookList.size();i++) {
					if(bookList.get(i).getIsbn().equals(bookIsbn)){
						book=bookList.get(i);
						break;
					}
				}
				if(book==null) {
					//show error message
					JOptionPane.showMessageDialog(null,"Book not found!!");
					return;
				}
				
				CheckoutEntry checkout=new CheckoutEntry(
						"",  //record id
						member,
						null, //user
						book, 
						LocalDate.now(),
						LocalDate.now().plusDays(book.getMaxCheckoutLength())
						);
			}
		});
		btnSearch.setBounds(510, 123, 151, 33);
		add(btnSearch);
		
		JButton btnSearch_1 = new JButton("Checkout");
		btnSearch_1.setEnabled(false);
		btnSearch_1.setBounds(701, 123, 151, 33);
		add(btnSearch_1);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBounds(61, 198, 1103, 470);
		add(table);

	}
}
