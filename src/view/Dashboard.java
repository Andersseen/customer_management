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

import panels.AddClient;
import panels.MainList;


import components.MyButton;
import controller.DashboardController;

public class Dashboard extends JFrame implements ActionListener{
	
//	private DashboardController dashboardCL;

	private JPanel bg;
	private JPanel panelSide;
	private MyButton btnAdd;
	private JPanel panelTop;
	private JLabel titleTopLabel;
	private JPanel contentPanel;
	private JButton btnMain;
	private MainList mainList;
	private AddClient pageAdd;
	private JLabel userNameLabel;


	public Dashboard() {
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 600);
		setLocationRelativeTo(null);
		setTitle("Index");
		setResizable(false);
		getContentPane().setLayout(null);
		
		initPrimary();
		
//		this.dashboardCL = new DashboardController();
		
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
		btnMain.setText("Lista de clientes");
		btnMain.addActionListener(this);
		btnMain.setBounds(0, 135, 200, 34);
		panelSide.add(btnMain);
		
		
		btnAdd = new MyButton();
		btnAdd.setText("Agregar cliente");
		btnAdd.setBounds(0, 179, 200, 34);
		btnAdd.addActionListener(this);
		
		
		panelSide.setLayout(null);
		panelSide.add(btnAdd);
		
		userNameLabel = new JLabel("User");
		userNameLabel.setForeground(SystemColor.text);
		userNameLabel.setFont(new Font("Ubuntu", Font.BOLD, 30));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setBounds(0, 0, 200, 101);
		panelSide.add(userNameLabel);

		panelTop = new JPanel();
		panelTop.setBackground(SystemColor.info);
		panelTop.setBounds(200, 0, 1000, 60);
		getContentPane().add(panelTop);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		titleTopLabel = new JLabel("Gestion de clientes");
		titleTopLabel.setBackground(SystemColor.info);
		titleTopLabel.setFont(new Font("Ubuntu", Font.BOLD, 24));
		titleTopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(titleTopLabel, BorderLayout.CENTER);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(200, 60, 1000, 540);
		bg.add(contentPanel);
		
		mainList = new MainList();
		mainList.setSize(990, 540);
		mainList.setLocation(0,0);
				
		contentPanel.removeAll();
		contentPanel.setLayout(null);
		contentPanel.add(mainList);
		contentPanel.revalidate();
		contentPanel.repaint();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnMain) {

			mainList = new MainList();
			mainList.setSize(990, 540);
			mainList.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(mainList);
			contentPanel.revalidate();
			contentPanel.repaint();
			
		}
		if(e.getSource() == btnAdd) {

			pageAdd = new AddClient();
			pageAdd.setSize(1000, 540);
			pageAdd.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(pageAdd);
			contentPanel.revalidate();
			contentPanel.repaint();
			
		}
		
	}
}
