package Chapter10;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ex10_10 extends JFrame{
	public Ex10_10() {
		setTitle("Click and Double Click 예제");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		setVisible(true);
	}
	
	private class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				int r = (int)(Math.random() * 256);
				int g = (int)(Math.random() * 256);
				int b = (int)(Math.random() * 256);
				
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r, g, b));
			}
		}
	}
	public static void main(String[] args) {
		new Ex10_10();
	}

}
