package components;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class MainList extends JPanel {
	private JTable table;
	DefaultTableModel model;

	public MainList() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		
		model = new DefaultTableModel();
		
		table.setModel(model);
		
		model.addColumn("1");
		model.addColumn("2");
		model.addColumn("3");
		model.addColumn("4");
		model.addColumn("5");
		model.addColumn("6");

		table.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		add(table, BorderLayout.CENTER);
		
	}
	
	public void writeTable() {
		
	}

}
