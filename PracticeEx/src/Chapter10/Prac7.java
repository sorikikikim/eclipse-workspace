package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Font;

public class Prac7 extends JFrame {
	private JLabel l = new JLabel("Love Java");
	public Prac7() {
		setTitle("마우스 휠을 굴려 크기 조절");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(l);
		c.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				Font f = l.getFont();
				int size = f.getSize();
				
				int n = e.getWheelRotation();
				if (n < 0) {
					if (size - 5 > 0)
						l.setFont(new Font("Arial", Font.PLAIN, size - 5));
				}
				else if (size + 5 < 100) {
					l.setFont(new Font("Arial", Font.PLAIN, size + 5));
				}
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new Prac7();
	}
}
