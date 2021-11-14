package Chapter9;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

public class Ex9_2 extends JFrame {
	public Ex9_2() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 200);
		setLocation(100, 100);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.orange);
		c.add(new JButton("OK"));
		c.add(new JButton("Cancel"));
		c.add(new JButton("Ignore"));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex9_2 frame = new Ex9_2();
	}

}
