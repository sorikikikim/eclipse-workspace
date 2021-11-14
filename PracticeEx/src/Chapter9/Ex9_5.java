package Chapter9;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex9_5 extends JFrame {
	public Ex9_5() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(100, 100);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 2, 0, 5));
		c.setBackground(Color.lightGray);
		c.add(new JLabel("이름"));
		c.add(new JTextField());
		c.add(new JLabel("학번"));
		c.add(new JTextField());
		c.add(new JLabel("학과"));
		c.add(new JTextField());
		c.add(new JLabel("과목"));
		c.add(new JTextField());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex9_5();
	}
}
