package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

public class Prac4 extends JFrame {
	private JLabel l = new JLabel("Love Java");
	public Prac4() {
		setTitle("Left 키로 문자열 이동");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(l);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					l.setText(l.getText().substring(1) + l.getText().charAt(0));
			}
		});
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Prac4();
	}
}
