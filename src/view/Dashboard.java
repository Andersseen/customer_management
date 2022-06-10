package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import components.FirstPage;
import components.MainList;
import components.SecondPage;
import components.ThirdPage;
import controller.DashboardController;

public class Dashboard extends JFrame implements ActionListener{
	
	private DashboardController dashboardCL;

	private JPanel bg;
	private JPanel panelSide;
	private JButton btn2;
	private JButton btn3;
	private JButton btn1;
	private JPanel panelTop;
	private JLabel titleTopLabel;
	private JPanel contentPanel;
	private JButton btnMain;
	private MainList mainList = new MainList();
	private JLabel userNameLabel;


	public Dashboard() {
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
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
		panelSide.setBounds(0, 0, 200, 463);
		getContentPane().add(panelSide);
		
		btnMain = new JButton("List");
		btnMain.addActionListener(this);
		btnMain.setBounds(50, 124, 85, 21);
		panelSide.add(btnMain);
		
		btn1 = new JButton("1");
		btn1.setBounds(50, 180, 85, 21);
		btn1.addActionListener(this);
		
		btn2 = new JButton("2");
		btn2.setBounds(50, 253, 85, 21);
		btn2.addActionListener(this);
		
		btn3 = new JButton("3");
		btn3.setBounds(50, 319, 85, 21);
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
		panelTop.setBounds(200, 5, 600, 100);
		getContentPane().add(panelTop);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		titleTopLabel = new JLabel("Gestion de clientes");
		titleTopLabel.setBackground(SystemColor.info);
		titleTopLabel.setFont(new Font("Ubuntu", Font.BOLD, 24));
		titleTopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(titleTopLabel, BorderLayout.CENTER);
		
		contentPanel = new JPanel();
		contentPanel.setBounds(200, 103, 600, 360);
		bg.add(contentPanel);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnMain) {

			mainList.setSize(600, 360);
			mainList.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(mainList);
			contentPanel.revalidate();
			contentPanel.repaint();
			
		}
		if(e.getSource() == btn1) {

			FirstPage page1 = new FirstPage();
			page1.setSize(600, 360);
			page1.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(page1);
			contentPanel.revalidate();
			contentPanel.repaint();
			
		}
		
		if(e.getSource() == btn2) {

			SecondPage page2 = new SecondPage();
			page2.setSize(600, 360);
			page2.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(page2);
			contentPanel.revalidate();
			contentPanel.repaint();

		}
		
		if(e.getSource() == btn3) {

			ThirdPage page3 = new ThirdPage();
			page3.setSize(600, 360);
			page3.setLocation(0,0);
			
			contentPanel.removeAll();
			contentPanel.setLayout(null);
			contentPanel.add(page3);
			contentPanel.revalidate();
			contentPanel.repaint();

		}

	}
}
