package Chapter9;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

public class Prac4 extends JFrame {
	public Prac4() {
		setTitle("Ten Color Buttons Frame");
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 10));
		Color color[] = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan,
				Color.blue, Color.magenta, Color.gray, Color.pink, Color.lightGray};
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			btn.setOpaque(true);
			btn.setBorderPainted(false);
			btn.setBackground(color[i]);
			c.add(btn);
		}	
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Prac4();
	}

}
