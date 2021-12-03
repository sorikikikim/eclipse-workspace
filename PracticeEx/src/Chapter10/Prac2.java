package Chapter10;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class Prac2 extends JFrame {
	public Prac2() {
		setTitle("드래깅하는 동안 YELLOW 그외에는 GREEN");
		setSize(500, 200);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.GREEN);
		MyMouseListener myML = new MyMouseListener();
		c.addMouseListener(myML);
		c.addMouseMotionListener(myML);
		setVisible(true);
	}
	
	private class MyMouseListener implements MouseListener, MouseMotionListener {
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {
			Component com = (Component)e.getSource();
			com.setBackground(Color.GREEN);
		}
		
		public void mouseDragged(MouseEvent e) {
			Component com = (Component)e.getSource();
			com.setBackground(Color.YELLOW);
		}
		
		public void mouseMoved(MouseEvent e) {}
	}
	public static void main(String[] args) {
		new Prac2();
	}

}
