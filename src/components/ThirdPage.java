package components;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class ThirdPage extends JPanel {


	private JLabel titleLabel;

	public ThirdPage() {
		setBackground(new Color(255, 0, 255));
		
		titleLabel = new JLabel("Third page");
		titleLabel.setForeground(SystemColor.text);
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 32));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);

	}

}
