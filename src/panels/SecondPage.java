package panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class SecondPage extends JPanel {
	private JTextField inputEdit;

	/**
	 * Create the panel.
	 */
	public SecondPage() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Edit Client");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		add(lblNewLabel, BorderLayout.NORTH);
		
		Panel panel = new Panel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		inputEdit = new JTextField();
		inputEdit.setBackground(SystemColor.control);
		inputEdit.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		inputEdit.setBounds(103, 198, 242, 46);
		panel.add(inputEdit);
		inputEdit.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		btnEdit.setBounds(415, 204, 105, 33);
		panel.add(btnEdit);

	}
}
