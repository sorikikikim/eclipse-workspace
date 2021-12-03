package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class Ex10_9 extends JFrame{
	private JLabel l = new JLabel("No Mouse Event");
	public Ex10_9() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setSize(500, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(l);
		c.setBackground(Color.cyan);
		//c.addMouseListener(new MyMouseListener()); 기존의 방법이 아닌 두개의 리스너를 등록하기 위해
		MyMouseListener MListener = new MyMouseListener();
		c.addMouseListener(MListener);
		c.addMouseMotionListener(MListener);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	private class MyMouseListener implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {
			l.setText("mousePressed(" + e.getX() + ", " + e.getY() + ")");
		}
		
		public void mouseReleased(MouseEvent e) {
			l.setText("mouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}
		
		public void mouseEntered(MouseEvent e) {
			Component com = (Component)e.getSource();
			com.setBackground(Color.cyan);
		}
		
		public void mouseExited(MouseEvent e) {
			Component com = (Component)e.getSource();
			com.setBackground(Color.yellow);
		}
		
		public void mouseDragged(MouseEvent e) {
			l.setText("mouseDragged(" + e.getX() + ", " + e.getY() + ")");
		}
		
		public void mouseMoved(MouseEvent e) {
			l.setText("mouseMoved(" + e.getX() + ", " + e.getY() + ")");
		}
	}
	public static void main(String[] args) {
		new Ex10_9();
	}
}
