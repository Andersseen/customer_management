package panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controller.DashboardController;
import view.Dashboard;

public class EditClient extends JFrame implements ActionListener{
	
	private DashboardController dashboardCL;

	private JLabel titleLabel;
	private JTextField inputName;
	private JTextField inputLastName;
	private JTextField inputEmail;
	private JTextField inputNote;
	private JTextField inputPhone;
	private JComboBox selectSex;
	private JButton btnEdit;
	private JButton btnCancel;
	private JLabel nameLabel;
	private JComponent lastNameLabel;
	private JComponent sexLabel;
	private JComponent birthdayLabel;
	private JComponent noteLabel;
	private JComponent dateLabel;
	private JComponent phoneLabel;
	private Component emailLabel;
	private JPanel panel;

	private SimpleDateFormat format;

	private Date fechaTxt;

	private JDateChooser inputDate;
	
	private JTextField inputDateString;
	private JTextField inputBirthdayString;

	private int id;
	

	
	public EditClient() {
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setDefaultCloseOperation(0);
		setBounds(200, 60, 1000, 500);
		setLocationRelativeTo(null);
		setTitle("Editar Cliente");
		setResizable(false);
		getContentPane().setLayout(null);
		setBackground(SystemColor.menu);

		initComponent();
	}
	
	public EditClient(int id,String name,String lastName, String sex,String birthday, String phone,String email,String note,String date) {
		 this.id = id;
		
		getContentPane().setBackground(SystemColor.activeCaptionBorder);

		setUndecorated(true);
		setDefaultCloseOperation(0);
		setBounds(200, 60, 1000, 500);
		setLocationRelativeTo(null);
		setTitle("Editar Cliente");
		setResizable(false);
		getContentPane().setLayout(null);
		setBackground(SystemColor.menu);

		setComponent(name,lastName,sex,birthday,phone,email,note,date);
	}
	
	

	public void initComponent() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		titleLabel = new JLabel("Edit Client");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		getContentPane().add(titleLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		inputName = new JTextField();
		inputName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputName.setBounds(188, 55, 200, 30);
		inputName.setColumns(10);
		panel.add(inputName);
		
		inputLastName = new JTextField();
		inputLastName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputLastName.setColumns(10);
		inputLastName.setBounds(538, 55, 200, 30);
		panel.add(inputLastName);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputEmail.setColumns(10);
		inputEmail.setBounds(538, 211, 200, 30);
		panel.add(inputEmail);
		
		inputNote = new JTextField();
		inputNote.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputNote.setColumns(10);
		inputNote.setBounds(538, 286, 200, 30);
		panel.add(inputNote);
		
		inputPhone = new JTextField();
		inputPhone.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputPhone.setColumns(10);
		inputPhone.setBounds(188, 211, 200, 30);
		panel.add(inputPhone);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnEdit.setBounds(323, 351, 122, 44);
		panel.add(btnEdit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnCancel.setBounds(491, 351, 122, 44);
		panel.add(btnCancel);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		nameLabel.setBounds(188, 21, 200, 29);
		panel.add(nameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lastNameLabel.setBounds(538, 21, 200, 29);
		panel.add(lastNameLabel);
		
		sexLabel = new JLabel("Sex");
		sexLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		sexLabel.setBounds(538, 91, 200, 29);
		panel.add(sexLabel);
		
		birthdayLabel= new JLabel("Birthday");
		birthdayLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		birthdayLabel.setBounds(188, 91, 200, 29);
		panel.add(birthdayLabel);
		
		noteLabel = new JLabel("Note");
		noteLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		noteLabel.setBounds(538, 247, 200, 29);
		panel.add(noteLabel);
		
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		dateLabel.setBounds(188, 262, 200, 29);
		panel.add(dateLabel);
	
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		phoneLabel.setBounds(188, 170, 200, 29);
		panel.add(phoneLabel);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		emailLabel.setBounds(538, 170, 200, 29);
		panel.add(emailLabel);
		
		selectSex = new JComboBox();
		selectSex.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		selectSex.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		selectSex.setBounds(538, 131, 200, 26);
		panel.add(selectSex);
		
		inputDate = new JDateChooser();
		inputDate.setDateFormatString("dd-MM-yyyy");
		inputDate.setBounds(188, 286, 200, 30);
		panel.add(inputDate);
				
	}
	
	private void setComponent(String name,String lastName, String sex,String birthday, String phone,String email,String note,String date) {

		getContentPane().setLayout(new BorderLayout(0, 0));
		titleLabel = new JLabel("Edit Client");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		getContentPane().add(titleLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		inputName = new JTextField();
		inputName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputName.setBounds(188, 55, 200, 30);
		inputName.setColumns(10);
		inputName.setText(name);
		panel.add(inputName);
		
		inputLastName = new JTextField();
		inputLastName.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputLastName.setColumns(10);
		inputLastName.setBounds(538, 55, 200, 30);
		inputLastName.setText(lastName);
		panel.add(inputLastName);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputEmail.setColumns(10);
		inputEmail.setBounds(538, 211, 200, 30);
		inputEmail.setText(email);
		panel.add(inputEmail);
		
		inputNote = new JTextField();
		inputNote.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputNote.setColumns(10);
		inputNote.setBounds(538, 286, 200, 30);
		inputNote.setText(note);
		panel.add(inputNote);
		
		inputPhone = new JTextField();
		inputPhone.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputPhone.setColumns(10);
		inputPhone.setBounds(188, 211, 200, 30);
		inputPhone.setText(phone);
		panel.add(inputPhone);
		
		selectSex = new JComboBox();
		selectSex.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		selectSex.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		selectSex.setBounds(538, 131, 200, 26);
		selectSex.setSelectedItem(sex);
		panel.add(selectSex);
		
		inputDateString = new JTextField();
		inputDateString.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputDateString.setColumns(10);
		inputDateString.setBounds(188, 286, 200, 30);
		inputDateString.setText(date);
		panel.add(inputDateString);
		
		inputBirthdayString = new JTextField();
		inputBirthdayString.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputBirthdayString.setColumns(10);
		inputBirthdayString.setBounds(188, 130, 200, 30);
		inputBirthdayString.setText(birthday);
		panel.add(inputBirthdayString);
		
//		inputBirthday = new JDateChooser();
//		inputBirthday.setDateFormatString("dd-MM-yyyy");
//		inputBirthday.setBounds(188, 130, 200, 30);
//		inputBirthday.setDate(birthday);
//		panel.add(inputBirthday);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		btnEdit.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnEdit.setBounds(323, 351, 122, 44);
		panel.add(btnEdit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		btnCancel.setBounds(491, 351, 122, 44);
		panel.add(btnCancel);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		nameLabel.setBounds(188, 21, 200, 29);
		panel.add(nameLabel);
		
		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		lastNameLabel.setBounds(538, 21, 200, 29);
		panel.add(lastNameLabel);
		
		sexLabel = new JLabel("Sex");
		sexLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		sexLabel.setBounds(538, 91, 200, 29);
		panel.add(sexLabel);
		
		birthdayLabel= new JLabel("Birthday");
		birthdayLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		birthdayLabel.setBounds(188, 91, 200, 29);
		panel.add(birthdayLabel);
		
		noteLabel = new JLabel("Note");
		noteLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		noteLabel.setBounds(538, 247, 200, 29);
		panel.add(noteLabel);
		
		dateLabel = new JLabel("Date");
		dateLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		dateLabel.setBounds(188, 262, 200, 29);
		panel.add(dateLabel);
	
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		phoneLabel.setBounds(188, 170, 200, 29);
		panel.add(phoneLabel);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Ubuntu", Font.BOLD, 20));
		emailLabel.setBounds(538, 170, 200, 29);
		panel.add(emailLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dashboardCL = new DashboardController();
		if(e.getSource() == btnEdit) {
			

			dashboardCL.editClient(inputName.getText(),
					inputLastName.getText(),
					(String) selectSex.getSelectedItem(),
					inputBirthdayString.getText(),
					inputPhone.getText(),
					inputEmail.getText(),
					inputNote.getText(),
					inputDateString.getText(),id);
			
			this.setVisible(false);
			MainList list = new MainList();
			list.refresh();
		}
		if(e.getSource() == btnCancel) {
			this.setVisible(false);
		}
	}
}
