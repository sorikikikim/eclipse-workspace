package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Prac6 extends JFrame {
	private JLabel l = new JLabel("c");
	public Prac6() {
		setTitle("클릭 연습용 응용프로그램");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		l.setSize(20, 20);
		l.setLocation(100, 100);
		c.add(l);
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = (int)(Math.random() * (c.getWidth() - 50));
				int y = (int)(Math.random() * (c.getHeight() - 50));
				l.setLocation(x, y);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prac6();
	}
}
