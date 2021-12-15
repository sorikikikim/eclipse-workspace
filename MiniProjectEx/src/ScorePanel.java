import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	private JLabel text = new JLabel("점수");
	private JLabel score = new JLabel("0");
	
	public ScorePanel() {
		this.setBackground(Color.YELLOW);
		setLayout(null);
		
		text.setSize(50, 20);
		text.setLocation(10, 10);
		add(text);
		
		score.setSize(10, 20);
		score.setLocation(70, 10);
		add(score);
	}
}
