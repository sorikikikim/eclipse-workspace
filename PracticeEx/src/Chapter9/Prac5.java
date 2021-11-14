package Chapter9;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

public class Prac5 extends JFrame {
	public Prac5() {
		setTitle("4x4 Color Frame");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 4));
		Color color[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, 
				Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY, Color.RED, Color.ORANGE};
		for (int i = 0; i < 16; i++) {
			JLabel l = new JLabel(Integer.toString(i));
			l.setOpaque(true);
			l.setBackground(color[i % 10]);
			c.add(l);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new Prac5();
	}
}
