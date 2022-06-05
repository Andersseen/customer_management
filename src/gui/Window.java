package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel titleLabel;


	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 355);
		
		showWindow();
	}
	
	public void showWindow() 
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		titleLabel = new JLabel("Hello World");
		titleLabel.setFont(new Font("Ubuntu", Font.BOLD, 24));
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
