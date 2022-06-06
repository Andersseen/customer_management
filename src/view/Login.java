package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField passField;
	private JTextField userField;
	
	public controller.UserController userCL;
	private JLabel titleLabel;
	private JButton cancelBtn;
	private JButton accesBtn;
	private JLabel userLabel;
	private JLabel passLabel;

	

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 428);
		setTitle("Login");
		setResizable(false);
		
		initView();
	}

	private void initView() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		accesBtn = new JButton("Access");
		accesBtn.addActionListener(this);
		accesBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		accesBtn.setBackground(SystemColor.activeCaption);
		accesBtn.setBounds(91, 284, 156, 49);
		contentPane.add(accesBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		cancelBtn.setBackground(SystemColor.activeCaption);
		cancelBtn.setBounds(334, 284, 156, 49);
		contentPane.add(cancelBtn);
		
		titleLabel = new JLabel("Login");
		titleLabel.setForeground(SystemColor.text);
		titleLabel.setFont(new Font("Ubuntu", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(192, 27, 186, 49);
		contentPane.add(titleLabel);
		
		passField = new JTextField();
		passField.setBounds(91, 211, 399, 35);
		contentPane.add(passField);
		passField.setColumns(10);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(91, 134, 399, 35);
		contentPane.add(userField);
		
		userLabel = new JLabel("");
		userLabel.setForeground(SystemColor.text);
		userLabel.setBounds(91, 94, 156, 13);
		contentPane.add(userLabel);
		
		passLabel = new JLabel("");
		passLabel.setForeground(SystemColor.text);
		passLabel.setBounds(334, 94, 156, 13);
		contentPane.add(passLabel);
				
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == accesBtn) {
			String user = this.userField.getText();	
			String pass = this.passField.getText();	
			
			this.userLabel.setText(user);
			this.passLabel.setText(pass);
			
		}
		if(e.getSource() == cancelBtn) {
			this.userField.setText("");	
			this.passField.setText("");
			
			this.userLabel.setText("");
			this.passLabel.setText("");
		}
	}

}
