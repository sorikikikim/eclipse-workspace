package Chapter9;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;

public class Prac6 extends JFrame {
	public Prac6() {
		setTitle("Random Labels");
		setSize(300, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		for (int i = 0; i < 20; i++) {
			JLabel l = new JLabel();
			l.setSize(10, 10);
			l.setLocation((int)(Math.random() * 200) + 50, (int)(Math.random() * 200) + 50);
			l.setBackground(Color.BLUE);
			l.setOpaque(true);
			c.add(l);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new Prac6();
	}
}
