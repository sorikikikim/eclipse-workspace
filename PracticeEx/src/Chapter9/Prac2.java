package Chapter9;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;

public class Prac2 extends JFrame {
	public Prac2() {
		setTitle("BorderLayout Practice");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 7));
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("Center"), BorderLayout.CENTER);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Prac2();
	}

}
