package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Library_Management_System.business.Address;
import Library_Management_System.business.Author;
import Library_Management_System.business.Book;
import Library_Management_System.business.LibraryMember;
import Library_Management_System.controller.ControllerInterface;
import Library_Management_System.controller.SystemController;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAddMember extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMemberId;
	private DefaultTableModel model;
	private  ControllerInterface ci = new SystemController();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtTel;
	private JTextField txtStreet;
	private JTextField txtZip;
	private JTextField txtState;
	private JTextField txtCity;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public void initJTable() {
		model = new DefaultTableModel();
		String[] column = {"Member ID","First Name","Last Name", "Tel", "Address"};
		table.setModel(model);
		model.setColumnIdentifiers(column);
		viewBook();
	}
	

	/**
	 * View Book
	 */
	public void viewBook() {
		model.setRowCount(0);
		List<LibraryMember> memberList = ci.allMembers();
		System.out.println(memberList.size());
		String[] row = new String[5];
	
 		for(LibraryMember member: memberList) {
			row[0] = member.getMemberId();
			row[1] = member.getFirstName();
			row[2] = member.getLastName();
			row[3] = member.getTelephone();
			
			//Authors
			row[4] = member.getAddress().getStreet() + " " + member.getAddress().getState();
			model.addRow(row);
		}
		
	}
	
	public PanelAddMember() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 24, 1151, 125);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddressDetails = new JLabel("Address Details");
		lblAddressDetails.setBounds(23, 58, 115, 15);
		panel.add(lblAddressDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 11, 912, 36);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMemberId = new JLabel("Member Id");
		lblMemberId.setBounds(10, 0, 70, 37);
		panel_2.add(lblMemberId);
		
		txtMemberId = new JTextField();
		txtMemberId.setBounds(81, 8, 97, 19);
		panel_2.add(txtMemberId);
//		txtMemberId.setText("1004");
//		txtMemberId.setEnabled(false);
		txtMemberId.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(216, 11, 70, 15);
		panel_2.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(296, 9, 127, 18);
		panel_2.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(458, 11, 55, 15);
		panel_2.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(523, 8, 115, 20);
		panel_2.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact No");
		lblContactNumber.setBounds(670, 11, 62, 15);
		panel_2.add(lblContactNumber);
		
		txtTel = new JTextField();
		txtTel.setBounds(739, 8, 137, 20);
		panel_2.add(txtTel);
		txtTel.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(23, 84, 912, 36);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(10, 11, 54, 15);
		panel_2_1.add(lblState);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(74, 8, 97, 18);
		panel_2_1.add(txtState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(216, 11, 31, 15);
		panel_2_1.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(257, 8, 127, 18);
		panel_2_1.add(txtCity);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(419, 11, 54, 15);
		panel_2_1.add(lblStreet);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(470, 9, 115, 18);
		panel_2_1.add(txtStreet);
		txtStreet.setColumns(10);
		
		JLabel lblZipcode = new JLabel("Zip Code");
		lblZipcode.setBounds(616, 11, 54, 15);
		panel_2_1.add(lblZipcode);
		
		txtZip = new JTextField();
		txtZip.setBounds(691, 9, 127, 18);
		panel_2_1.add(txtZip);
		txtZip.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 160, 1151, 42);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ci.addMember(txtMemberId.getText(),
						txtFirstName.getText(),
						txtLastName.getText(),
						txtTel.getText(),
						txtStreet.getText(),
						txtCity.getText(),
						txtState.getText(),
						txtZip.getText());
				viewBook();	
			}
			
		});
		btnAdd.setBounds(10, 11, 110, 25);
		panel_1.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(147, 11, 89, 25);
		panel_1.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 219, 1141, 474);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		initJTable();

	}
}
