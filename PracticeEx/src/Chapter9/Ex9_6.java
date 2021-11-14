package Chapter9;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;

public class Ex9_6 extends JFrame {
	public Ex9_6() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel l = new JLabel("Hello Press Buttons!");
		l.setSize(200, 20);
		l.setLocation(200, 60);
		c.add(l);
		
		for (int i = 1; i < 10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			btn.setSize(50, 30);
			btn.setLocation(10 + i * 25, i * 15);
			c.add(btn);
		}
		setVisible(true);	
	}

	public static void main(String[] args) {
		new Ex9_6();
	}
}
