package Chapter9;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.GridLayout;

public class Prac3 extends JFrame {
	public Prac3() {
		setTitle("Ten Color Frame");
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 10));
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			c.add(btn);
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prac3();
	}
}
