package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class Login extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField userField;
	
	public UserController userCL;
	private JLabel titleLabel;
	private JButton cancelBtn;
	private JButton accesBtn;
	private JLabel userLabel;
	private JLabel passLabel;
	private JLabel errorUserLabel;
	private JLabel errorPassLabel;
	private JLabel userTitle;
	private JLabel passTitle;
	private JPanel panel;
	private JPasswordField passField;

	

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		setLocationRelativeTo(null);
		setTitle("Login");
		setResizable(false);
		
		this.userCL = new UserController();
		
		initView();
	}

	private void initView() {
		contentPane = new JPanel();
		contentPane.setFont(new Font("Impact", Font.PLAIN, 20));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(UIManager.getColor("Button.foreground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		accesBtn = new JButton("Entrar");
		accesBtn.setForeground(SystemColor.text);
		accesBtn.addActionListener(this);
		accesBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		accesBtn.setBackground(new Color(204, 102, 255));
		accesBtn.setBounds(344, 334, 156, 49);
		contentPane.add(accesBtn);
		
		cancelBtn = new JButton("Limpiar");
		cancelBtn.setForeground(SystemColor.text);
		cancelBtn.addActionListener(this);
		cancelBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		cancelBtn.setBackground(new Color(153, 0, 51));
		cancelBtn.setBounds(587, 334, 156, 49);
		contentPane.add(cancelBtn);
		
		titleLabel = new JLabel("Login");
		titleLabel.setForeground(SystemColor.text);
		titleLabel.setFont(new Font("Ubuntu", Font.BOLD, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(446, 60, 186, 49);
		contentPane.add(titleLabel);
		
		userField = new JTextField();
		userField.addKeyListener(this);
		userField.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		userField.setForeground(SystemColor.text);
		userField.setOpaque(false);
		userField.setColumns(10);
		userField.setBounds(344, 147, 399, 35);
		contentPane.add(userField);
		
		passField = new JPasswordField();
		passField.addKeyListener(this);
		passField.setOpaque(false);
		passField.setForeground(SystemColor.text);
		passField.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		passField.setBounds(344, 261, 399, 35);
		contentPane.add(passField);
		
		userLabel = new JLabel("");
		userLabel.setForeground(SystemColor.text);
		userLabel.setBounds(91, 94, 156, 13);
		contentPane.add(userLabel);
		
		passLabel = new JLabel("");
		passLabel.setForeground(SystemColor.text);
		passLabel.setBounds(334, 94, 156, 13);
		contentPane.add(passLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(-4, 0, 299, 463);
		contentPane.add(panel);
		
		errorUserLabel = new JLabel("Compo obligatorio");
		errorUserLabel.setVisible(false);
		errorUserLabel.setForeground(new Color(255, 0, 0));
		errorUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorUserLabel.setBounds(344, 192, 399, 13);
		contentPane.add(errorUserLabel);
		
		errorPassLabel = new JLabel("Compo obligatorio");
		errorPassLabel.setVisible(false);
		errorPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorPassLabel.setForeground(new Color(255, 0, 0));
		errorPassLabel.setBounds(344, 306, 399, 13);
		contentPane.add(errorPassLabel);
		
		userTitle = new JLabel("Usuario");
		userTitle.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		userTitle.setForeground(SystemColor.text);
		userTitle.setBounds(344, 112, 156, 25);
		contentPane.add(userTitle);
		
		passTitle = new JLabel("Contaseña");
		passTitle.setForeground(Color.WHITE);
		passTitle.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		passTitle.setBounds(344, 226, 156, 25);
		contentPane.add(passTitle);
				
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == accesBtn) {
			String user = this.userField.getText();	
			String pass = this.passField.getText();	
//			
//			String message = "User : " + user + "  |Pass: " + pass;
//			
//			JOptionPane.showInternalMessageDialog(null, message);
			
			if(!user.equals("") && !pass.equals("")) {
				try {
					if(userCL.checkLogin(user, pass)) {
						JOptionPane.showInternalMessageDialog(null, "Bien");
					}else {
						JOptionPane.showInternalMessageDialog(null, "mal");
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
			}
			
			
			
		}
		if(e.getSource() == cancelBtn) {
			this.userField.setText("");	
			this.passField.setText("");
			
			this.userLabel.setText("");
			this.passLabel.setText("");
			
			errorUserLabel.setVisible(true);
			errorPassLabel.setVisible(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource() == userField) {
			 if(userField.getText().length()==0){
					errorUserLabel.setVisible(true);
				}
				else{
					errorUserLabel.setVisible(false);
				}
		 }
		if(e.getSource() == passField) {
			 if(passField.getPassword().length==0){
					errorPassLabel.setVisible(true);
				}
				else{
					errorPassLabel.setVisible(false);
				}
		 }
	}
}
