package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	private JTable table;
	private JTable table_1;
	private  ControllerInterface ci = new SystemController();

	/**
	 * Create the panel.
	 */
	public PanelAddBookCopy() {
		setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 24, 608, 197);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Book Copy");
		lblNewLabel.setBounds(190, 0, 266, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ISBN");
		lblNewLabel_1.setBounds(131, 65, 103, 28);
		panel.add(lblNewLabel_1);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(255, 65, 207, 28);
		panel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Copy");
		btnNewButton.setBounds(255, 143, 89, 28);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("No of Copies");
		lblNewLabel_1_1.setBounds(126, 99, 72, 28);
		panel.add(lblNewLabel_1_1);
		
		txtNoOfCopy = new JTextField();
		txtNoOfCopy.setBounds(255, 104, 77, 28);
		panel.add(txtNoOfCopy);
		txtNoOfCopy.setText("1");
		txtNoOfCopy.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 232, 613, 163);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
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
					if(bookList.get(i).getIsbn().equals(txtIsbn.toString())){
						book=bookList.get(i);
					}
				}
				if(book==null) {
					JOptionPane.showMessageDialog(null,"Book not found!!");
					return;
				}
				
				book.addCopy( Integer.valueOf(txtNoOfCopy.toString()));
				bookList.add(i, book);
			}
		});

	}
}
