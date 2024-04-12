package Library_Management_System.librarysystem;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAddAuthors extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtContactNo;
	private JTextField txtBio;
	private JTextField txtState;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtZipCode;

	/**
	 * Create the panel.
	 */
	public PanelAddAuthors() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 11, 498, 184);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add Authors");
		lblNewLabel_1.setBounds(10, 0, 82, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(10, 25, 60, 14);
		panel.add(lblNewLabel_2);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(80, 22, 118, 20);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(250, 25, 60, 14);
		panel.add(lblNewLabel_3);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(332, 22, 137, 20);
		panel.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contact No.");
		lblNewLabel_4.setBounds(10, 53, 60, 14);
		panel.add(lblNewLabel_4);
		
		txtContactNo = new JTextField();
		txtContactNo.setBounds(80, 53, 118, 20);
		panel.add(txtContactNo);
		txtContactNo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Bio");
		lblNewLabel_5.setBounds(260, 53, 21, 14);
		panel.add(lblNewLabel_5);
		
		txtBio = new JTextField();
		txtBio.setBounds(332, 53, 137, 20);
		panel.add(txtBio);
		txtBio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("State");
		lblNewLabel_6.setBounds(10, 84, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("City");
		lblNewLabel_6_1.setBounds(250, 84, 46, 14);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Street");
		lblNewLabel_6_2.setBounds(10, 117, 46, 14);
		panel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Zip Code");
		lblNewLabel_6_3.setBounds(250, 117, 46, 14);
		panel.add(lblNewLabel_6_3);
		
		txtState = new JTextField();
		txtState.setBounds(80, 84, 118, 20);
		panel.add(txtState);
		txtState.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(332, 84, 137, 20);
		panel.add(txtCity);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(80, 111, 118, 20);
		panel.add(txtStreet);
		
		txtZipCode = new JTextField();
		txtZipCode.setColumns(10);
		txtZipCode.setBounds(332, 111, 137, 20);
		panel.add(txtZipCode);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(10, 150, 60, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 216, 498, 72);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Author List");
		lblNewLabel.setBounds(10, 11, 107, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(24, 329, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(123, 329, 89, 23);
		add(btnNewButton_1);

	}

}
