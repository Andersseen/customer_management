package components;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SecondPage extends JPanel {


	private JLabel titleLabel;

	public SecondPage() {
		setBackground(new Color(128, 0, 0));
		
		titleLabel = new JLabel("Second page");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 32));
		add(titleLabel);

	}

}
