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
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelAddBookCopy extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtIsbn;
	private JTextField txtNoOfCopy;
	private DefaultTableModel model;
	private  ControllerInterface ci = new SystemController();
	private JTable table;

	public void initJTable() {
		model = new DefaultTableModel();
		String[] column = {"Book ISBN","Book Title","Total copies"};
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
		
		System.out.println("addcopy: " + row[0] + " " + row[1]);
		row[2] = Integer.toString(book.getCopyNums().size());
		//row[2] = book.getIsbn();
		model.addRow(row);
	}
	
	public void clearForm() {
		txtIsbn.setText("");
    	txtNoOfCopy.setText("1");
	}
	
	/**
	 * Create the panel.
	 */
	public PanelAddBookCopy() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		//setBackground(new Color(173, 216, 230));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(46, 24, 1142, 167);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Book Copy");
		lblNewLabel.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel.setBounds(446, 12, 266, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ISBN");
		lblNewLabel_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1.setBounds(282, 66, 103, 28);
		panel.add(lblNewLabel_1);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(427, 61, 225, 34);
		panel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Copy");
		btnNewButton.setFont(new Font("FreeSans", Font.BOLD, 18));
		btnNewButton.setBounds(678, 61, 219, 80);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("No of Copies");
		lblNewLabel_1_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(279, 115, 120, 28);
		panel.add(lblNewLabel_1_1);
		
		txtNoOfCopy = new JTextField();
		txtNoOfCopy.setBounds(425, 107, 225, 34);
		panel.add(txtNoOfCopy);
		txtNoOfCopy.setText("1");
		txtNoOfCopy.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(42, 232, 1146, 456);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1146, 395);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("FreeSans", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PanelAddBookCopy.class.getResource("/img/icons8-add-button-32.png")));
		lblNewLabel_2.setBounds(422, 1, 43, 48);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblBookCopyInformation = new JLabel("Book Copy information");
		lblBookCopyInformation.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblBookCopyInformation.setBounds(461, 1, 237, 48);
		panel_1.add(lblBookCopyInformation);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMsg=UIValidationRuleSet.addBookCopyValidation(txtIsbn.getText(), txtNoOfCopy.getText());
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				
			    String res = ci.addBookCopy(txtIsbn.getText(), Integer.parseInt(txtNoOfCopy.getText()));
			    if(res=="ok") {
			    	JOptionPane.showMessageDialog(null,"Book copy added successfully!");
			    	initJTable();
			    	clearForm();
			    }
			    else {
			    	JOptionPane.showMessageDialog(null,res);
			    }
			}
		});

	}
}
