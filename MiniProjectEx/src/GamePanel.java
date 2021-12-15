import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel {
	private JTextField input = new JTextField(20);
	private JLabel text = new JLabel("타이핑해보세요");
	public GamePanel() {
		setLayout(new BorderLayout());
		add(new GameGroundPanel(), BorderLayout.CENTER);
		add(new InputPanel(), BorderLayout.SOUTH);
	}
	
	class GameGroundPanel extends JPanel {
		public GameGroundPanel() {
			setLayout(null);
			text.setSize(100, 30);
			text.setLocation(100, 10);
			add(text);
		}
	}
	
	class InputPanel extends JPanel {
		public InputPanel() {
			setLayout(new FlowLayout());
			this.setBackground(Color.cyan);
			add(input);
		}
	}
}
