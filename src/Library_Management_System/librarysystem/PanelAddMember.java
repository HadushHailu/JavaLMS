package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

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
	//Random randomMemberId = new Random();
	private int maxMemId=1000;
	/**
	 * Create the panel.
	 */
	public void initJTable() {
		model = new DefaultTableModel();
		String[] column = {"Member ID","First Name","Last Name", "Tel", "Address"};
		table.setModel(model);
		model.setColumnIdentifiers(column);
		viewMember();
		txtMemberId.setText(String.valueOf(maxMemId+1));
	}
	

	/**
	 * View Book
	 */
	public void viewMember() {
		model.setRowCount(0);
		List<LibraryMember> memberList = ci.allMembers();
		System.out.println(memberList.size());
		String[] row = new String[5];
	
 		for(LibraryMember member: memberList) {		
 			if(!member.getMemberId().isEmpty() && Integer.valueOf(member.getMemberId()) > maxMemId ) {
 				maxMemId=Integer.valueOf(member.getMemberId());
 			}
			row[0] = member.getMemberId();
			row[1] = member.getFirstName();
			row[2] = member.getLastName();
			row[3] = member.getTelephone();
			
			//Authors
			row[4] = member.getAddress().getStreet() + " " + member.getAddress().getState();
			model.addRow(row);
		}
	}
	public void clearForm() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtTel.setText("");
		txtStreet.setText("");
		txtZip.setText("");
		txtState.setText("");
		txtCity.setText("");	
	}
	
	public PanelAddMember() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		//setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(25, 26, 1151, 268);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddressDetails = new JLabel("Address Details");
		lblAddressDetails.setFont(new Font("FreeSans", Font.BOLD, 18));
		lblAddressDetails.setBounds(47, 104, 162, 30);
		panel.add(lblAddressDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 12, 1110, 80);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMemberId = new JLabel("Member Id");
		lblMemberId.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblMemberId.setBounds(30, 21, 106, 37);
		panel_2.add(lblMemberId);
		
		txtMemberId = new JTextField();
		txtMemberId.setForeground(new Color(123, 104, 238));
		txtMemberId.setFont(new Font("FreeSans", Font.BOLD, 18));
		txtMemberId.setEditable(false);
		txtMemberId.setBounds(139, 20, 61, 37);
		panel_2.add(txtMemberId);
		txtMemberId.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblFirstName.setBounds(233, 22, 121, 36);
		panel_2.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(355, 21, 121, 37);
		panel_2.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblLastName.setBounds(499, 22, 97, 37);
		panel_2.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(597, 21, 137, 37);
		panel_2.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact No.");
		lblContactNumber.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblContactNumber.setBounds(780, 27, 97, 24);
		panel_2.add(lblContactNumber);
		
		txtTel = new JTextField();
		txtTel.setBounds(895, 20, 188, 37);
		panel_2.add(txtTel);
		txtTel.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(255, 0, 0)));
		panel_2_1.setBackground(new Color(255, 250, 240));
		panel_2_1.setBounds(12, 146, 1110, 54);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblState.setBounds(28, 13, 78, 22);
		panel_2_1.add(lblState);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(108, 9, 130, 29);
		panel_2_1.add(txtState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblCity.setBounds(274, 14, 54, 24);
		panel_2_1.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(352, 9, 179, 33);
		panel_2_1.add(txtCity);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblStreet.setBounds(561, 11, 94, 31);
		panel_2_1.add(lblStreet);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(642, 9, 179, 33);
		panel_2_1.add(txtStreet);
		txtStreet.setColumns(10);
		
		JLabel lblZipcode = new JLabel("Zip Code");
		lblZipcode.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblZipcode.setBounds(859, 11, 79, 31);
		panel_2_1.add(lblZipcode);
		
		txtZip = new JTextField();
		txtZip.setBounds(972, 9, 105, 33);
		panel_2_1.add(txtZip);
		txtZip.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/icons8-address-30.png"));
		lblNewLabel.setBounds(12, 104, 70, 30);
		panel.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("FreeSans", Font.BOLD, 18));
		btnAdd.setBounds(117, 212, 133, 44);
		panel.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("FreeSans", Font.BOLD, 18));
		btnClear.setBounds(362, 212, 180, 44);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errorMsg=UIValidationRuleSet.addMemberValidation(txtFirstName.getText(),
						txtLastName.getText(),
						txtTel.getText(),
						txtStreet.getText(),
						txtState.getText(),
						txtCity.getText(),				
						txtZip.getText());
				
				if(!errorMsg.isEmpty()) {
					JOptionPane.showMessageDialog(null,errorMsg);
					return;
				}
				
				ci.addMember(txtMemberId.getText(),
						txtFirstName.getText(),
						txtLastName.getText(),
						txtTel.getText(),
						txtStreet.getText(),
						txtCity.getText(),
						txtState.getText(),
						txtZip.getText());
				
				
				JOptionPane.showMessageDialog(null,"Member added successfully!!");
				clearForm();
				viewMember();	
				txtMemberId.setText(String.valueOf(maxMemId+1));
			}
			
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(25, 317, 1151, 376);
		add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 54, 1151, 322);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("FreeSans", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/hadush/Documents/MIU/MPP/JavaLMS/img/icons8-info-30.png"));
		lblNewLabel_1.setBounds(424, 5, 43, 48);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblMemberInformation = new JLabel("Member information");
		lblMemberInformation.setFont(new Font("FreeSans", Font.BOLD, 16));
		lblMemberInformation.setBounds(460, 5, 237, 48);
		panel_3.add(lblMemberInformation);
		
		initJTable();

	}
}
