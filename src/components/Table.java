package components;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Table extends JPanel {
	private JTable table;
	private DefaultTableModel model;


	public Table() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		
		table = new JTable();
		model = new DefaultTableModel();
		
		table.setModel(model);
		table.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Last Name");
		model.addColumn("Sex");
		model.addColumn("Birthday");
		model.addColumn("Phone");
		model.addColumn("Email");
		model.addColumn("Note");
		model.addColumn("Date");
		
		
		scrollPane.setViewportView(table);
	}

}
