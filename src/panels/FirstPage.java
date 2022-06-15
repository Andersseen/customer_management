package panels;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.DashboardController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstPage extends JPanel implements ActionListener{
	
	private DashboardController dashboardCL;

	private JLabel titleLabel;
	private JTextField inputName;
	private JTextField inputLastName;
	private JTextField inputBirthday;
	private JTextField inputEmail;
	private JTextField inputNote;
	private JTextField inputDate;
	private JTextField inputPhone;
	private JComboBox selectSex;
	private JButton btnAdd;
	private JButton btnClean;
	private JLabel nameLabel;
	private JComponent lastNameLabel;
	private JComponent sexLabel;
	private JComponent birthdayLabel;
	private JComponent noteLabel;
	private JComponent dateLabel;
	private JComponent phoneLabel;
	private Component emailLabel;
	private JPanel panel;

	public FirstPage() {
		setBackground(SystemColor.menu);

		initComponent();
	}
	
	public void initComponent() {
		setLayout(new BorderLayout(0, 0));
		titleLabel = new JLabel("Add Client");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		add(titleLabel, BorderLayout.NORTH);
		
		 panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		inputName = new JTextField();
		inputName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputName.setBounds(63, 44, 200, 30);
		inputName.setColumns(10);
		panel.add(inputName);
		
		inputLastName = new JTextField();
		inputLastName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputLastName.setColumns(10);
		inputLastName.setBounds(413, 44, 200, 30);
		panel.add(inputLastName);
		
		inputBirthday = new JTextField();
		inputBirthday.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputBirthday.setColumns(10);
		inputBirthday.setBounds(63, 119, 200, 30);
		panel.add(inputBirthday);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputEmail.setColumns(10);
		inputEmail.setBounds(413, 200, 200, 30);
		panel.add(inputEmail);
		
		inputNote = new JTextField();
		inputNote.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputNote.setColumns(10);
		inputNote.setBounds(413, 275, 200, 30);
		panel.add(inputNote);
		
		inputDate = new JTextField();
		inputDate.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputDate.setColumns(10);
		inputDate.setBounds(63, 275, 200, 30);
		panel.add(inputDate);
		
		inputPhone = new JTextField();
		inputPhone.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputPhone.setColumns(10);
		inputPhone.setBounds(63, 200, 200, 30);
		panel.add(inputPhone);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnAdd.setBounds(63, 393, 122, 44);
		panel.add(btnAdd);
		
		btnClean = new JButton("Clean");
		btnClean.addActionListener(this);
		btnClean.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnClean.setBounds(229, 393, 122, 44);
		panel.add(btnClean);
		
		 nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		nameLabel.setBounds(63, 10, 200, 29);
		panel.add(nameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lastNameLabel.setBounds(413, 10, 200, 29);
		panel.add(lastNameLabel);
		
		sexLabel = new JLabel("Sex");
		sexLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		sexLabel.setBounds(413, 80, 200, 29);
		panel.add(sexLabel);
		
		birthdayLabel= new JLabel("Birthday");
		birthdayLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		birthdayLabel.setBounds(63, 80, 200, 29);
		panel.add(birthdayLabel);
		
		noteLabel = new JLabel("Note");
		noteLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		noteLabel.setBounds(413, 236, 200, 29);
		panel.add(noteLabel);
		
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		dateLabel.setBounds(63, 236, 200, 29);
		panel.add(dateLabel);
	
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		phoneLabel.setBounds(63, 159, 200, 29);
		panel.add(phoneLabel);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		emailLabel.setBounds(413, 159, 200, 29);
		panel.add(emailLabel);
		
		selectSex = new JComboBox();
		selectSex.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		selectSex.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		selectSex.setBounds(413, 120, 200, 26);
		panel.add(selectSex);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		dashboardCL = new DashboardController();
		if(e.getSource() == btnAdd) {
			dashboardCL.addClient(inputName.getText(), inputLastName.getText(),(String) selectSex.getSelectedItem(), inputBirthday.getText(), inputPhone.getText(), inputEmail.getText(), inputNote.getText(), inputDate.getText());
		}
		if(e.getSource() == btnClean) {
			inputName.setText("");
			inputLastName.setText("");
			inputBirthday.setText("");
			selectSex.setSelectedItem("Hombre");
			
			inputPhone.setText("");
			inputEmail.setText("");
			inputNote.setText("");
			inputDate.setText("");
		}
	}
}
