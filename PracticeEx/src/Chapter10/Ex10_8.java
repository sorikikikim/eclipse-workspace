package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class Ex10_8 extends JFrame{
	private JLabel l = new JLabel("HELLO");
	private final int FLYING_UNIT = 10;
	public Ex10_8() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		l.setLocation(50, 50);
		l.setSize(100, 20);
		c.add(l);
		
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
	private class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch (keyCode) {
			case KeyEvent.VK_UP:
				l.setLocation(l.getX(), l.getY() - FLYING_UNIT); break;
			case KeyEvent.VK_DOWN:
				l.setLocation(l.getX(), l.getY() + FLYING_UNIT); break;
			case KeyEvent.VK_LEFT:
				l.setLocation(l.getX() - FLYING_UNIT, l.getY()); break;
			case KeyEvent.VK_RIGHT:
				l.setLocation(l.getX() + FLYING_UNIT, l.getY()); break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex10_8();
	}

}
