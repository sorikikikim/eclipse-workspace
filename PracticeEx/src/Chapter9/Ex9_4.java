package Chapter9;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

public class Ex9_4 extends JFrame {
	public Ex9_4() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(100, 100);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30, 20));
		c.setBackground(Color.lightGray);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("div"), BorderLayout.WEST);
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex9_4();
	}
}
