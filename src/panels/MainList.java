package panels;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import controller.DashboardController;
import model.vo.CustomerVO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainList extends JPanel {
	DefaultTableModel model;
	
	DashboardController dashboardCL;

	private JTable table;

	private JScrollPane scrollPane;

	private JLabel listLabel;

	public MainList() {
		
		initComponennt();		
	}
	
	private void initComponennt() {
		setLayout(new BorderLayout(0, 0));
		
		listLabel = new JLabel("Client List");
		listLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(listLabel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		
	}
	
	public void createTable() {
		table = new JTable();
		
		model = new DefaultTableModel();
		
		table.setModel(model);
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Last Name");
		model.addColumn("Sex");
		model.addColumn("Birthday");
		model.addColumn("Phone");
		model.addColumn("Email");
		model.addColumn("Note");
		model.addColumn("Date");
		model.addColumn("%%");
		model.addColumn("X");
		
		scrollPane.setViewportView(table);
	}
	
	public void getListClients() {
		dashboardCL = new DashboardController();
		ArrayList<CustomerVO> clients =  dashboardCL.getClients();
		
		createTable();
		for( CustomerVO client : clients ) {
			Object[] row = new Object[9];
			
			row[0] = client.getId();
			row[1] = client.getName();
			row[2] = client.getLastName();
			row[3] = client.getSex();
			row[4] = client.getBirthday();
			row[5] = client.getPhone();
			row[6] = client.getEmail();
			row[7] = client.getNote();
			row[8] = client.getDate();
			
			model.addRow(row);
	}
		
	}
}
