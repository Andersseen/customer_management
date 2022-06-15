package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import panels.FirstPage;
import panels.MainList;
import panels.SecondPage;
import panels.ThirdPage;

import components.MyButton;
import controller.DashboardController;

public class Dashboard extends JFrame implements ActionListener{
	
	private DashboardController dashboardCL;

	private JPanel bg;
	private JPanel panelSide;
	private MyButton btn2;
	private MyButton btn3;
	private MyButton btn1;
	private JPanel panelTop;
	private JLabel titleTopLabel;
	private JPanel contentPanel;
	private JButton btnMain;
	private MainList mainList = new MainList();
	private JLabel userNameLabel;


	public Dashboard() {
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 600);
		setLocationRelativeTo(null);
		setTitle("Index");
		setResizable(false);
		getContentPane().setLayout(null);
		
		initPrimary();
		
		this.dashboardCL = new DashboardController();
		
		userNameLabel.setText(DashboardController.userName);
	}
	
	
	private void initPrimary() {
		
		bg = new JPanel();
		bg.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bg);
		bg.setLayout(null);
		
		panelSide = new JPanel();
		panelSide.setBackground(new Color(128, 0, 128));
		panelSide.setBounds(0, 0, 200, 600);
		getContentPane().add(panelSide);
		
		btnMain = new MyButton();
		btnMain.setText("List");
		btnMain.addActionListener(this);
		btnMain.setBounds(0, 135, 200, 34);
		panelSide.add(btnMain);
		
		
		btn1 = new MyButton();
		btn1.setText("Add");
		btn1.setBounds(0, 179, 200, 34);
		btn1.addActionListener(this);
		
		btn2 = new MyButton();
		btn2.setText("Edit");
		btn2.setBounds(0, 223, 200, 34);
		btn2.addActionListener(this);
		
		btn3 = new MyButton();
		btn3.setText("Delete");
		btn3.setBounds(0, 267, 200, 34);
		btn3.addActionListener(this);
		
		
		panelSide.setLayout(null);
		panelSide.add(btn2);
		panelSide.add(btn3);
		panelSide.add(btn1);
		
		userNameLabel = new JLabel("User");
		userNameLabel.setForeground(SystemColor.text);
		userNameLabel.setFont(new Font("Ubuntu", Font.BOLD, 30));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setBounds(0, 0, 200, 101);
		panelSide.add(userNameLabel);

		panelTop = new JPanel();
		panelTop.setBackground(SystemColor.info);
		panelTop.setBounds(200, 0, 700, 60);
		getContentPane().add(panelTop);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		titleTopLabel = new JLabel("Gestion de clientes");
		titleTopLabel.setBackground(SystemColor.info);
		titleTopLabel.setFont(new Font("Ubuntu", Font.BOLD, 24));
		titleTopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(titleTopLabel, BorderLayout.CENTER);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(200, 60, 700, 540);
		bg.add(contentPanel);
		
		mainList.setSize(700, 540);
		mainList.setLocation(0,0);
		
		mainList.getListClients();
		
		contentPanel.removeAll();
		contentPanel.setLayout(null);
		contentPanel.add(mainList);
		contentPanel.revalidate();
		contentPanel.repaint();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnMain) {

			mainList.setSize(700, 540);
			mainList.setLocation(0,0);
			mainList.getListClients();
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(mainList);
			contentPanel.revalidate();
			contentPanel.repaint();
			
		}
		if(e.getSource() == btn1) {

			FirstPage page1 = new FirstPage();
			page1.setSize(700, 540);
			page1.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(page1);
			contentPanel.revalidate();
			contentPanel.repaint();
			
		}
		
		if(e.getSource() == btn2) {

			SecondPage page2 = new SecondPage();
			page2.setSize(700, 540);
			page2.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(page2);
			contentPanel.revalidate();
			contentPanel.repaint();

		}
		
		if(e.getSource() == btn3) {

			ThirdPage page3 = new ThirdPage();
			page3.setSize(700, 540);
			page3.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(page3);
			contentPanel.revalidate();
			contentPanel.repaint();

		}

	}
}
