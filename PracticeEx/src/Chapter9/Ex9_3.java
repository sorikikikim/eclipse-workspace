package Chapter9;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Color;
import java.awt.FlowLayout;

public class Ex9_3 extends JFrame {
	public Ex9_3() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocation(100, 100);
		
		Container c = getContentPane();
		c.setBackground(Color.lightGray);
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex9_3();
	}

}
