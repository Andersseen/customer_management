package panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.DashboardController;

import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdPage extends JPanel implements ActionListener {
	private JTextField inputDelete;
	private JButton btnDelete;
	
	private DashboardController dashboardCL;

	public ThirdPage() {
		setLayout(new BorderLayout(0, 0));
		
		initComponent();
	}
	
	private void initComponent() {
		JLabel deleteLabel = new JLabel("Delete Client");
		deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		add(deleteLabel, BorderLayout.NORTH);
		
		Panel panel = new Panel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		inputDelete = new JTextField();
		inputDelete.setBackground(SystemColor.control);
		inputDelete.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputDelete.setBounds(139, 207, 187, 56);
		panel.add(inputDelete);
		inputDelete.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		btnDelete.setBounds(380, 215, 131, 39);
		panel.add(btnDelete);
	}
	
	public void actionPerformed(ActionEvent e) {
		dashboardCL = new DashboardController();
		if(e.getSource() == btnDelete) {
			
			int number;
			
			number = Integer.parseInt(inputDelete.getText()) ;
			
			dashboardCL.deleteClient(number);
			
		}
	}
}
