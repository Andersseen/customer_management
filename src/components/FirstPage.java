package components;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class FirstPage extends JPanel {

	private JLabel titleLabel;

	public FirstPage() {
		setBackground(SystemColor.activeCaption);
		
		titleLabel = new JLabel("Second Page");
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		add(titleLabel);

	}

}
