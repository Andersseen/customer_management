package panels;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainList extends JPanel {
	DefaultTableModel model;

	public MainList() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 100);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Citas");
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 700, 100);
		panel.add(lblNewLabel);
		
		JPanel content = new JPanel();
		content.setBounds(0, 98, 700, 364);
		add(content);
				
	}
	
	public void writeTable() {
		
	}
}
