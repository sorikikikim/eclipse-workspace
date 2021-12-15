import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicEditor extends JFrame {
	public GraphicEditor() {
		setTitle("마우스로 그리기");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private Point start = null; //마우스가 눌러진 위치
		private Point end = null; ; //마우스를 뗀 위치
		public MyPanel() {
			MyMouse ml = new MyMouse();
			this.addMouseListener(ml);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
		
		class MyMouse extends MouseAdapter {
		
			public void mousePressed(MouseEvent e) {
				start = e.getPoint();
			}
			
			public void mouseReleased(MouseEvent e) {
				end = e.getPoint();
				Graphics g = MyPanel.this.getGraphics(); //MyPanel을 그리는 Graphics
				g.drawLine(start.x, start.y, end.x, end.y);
			}
		}
	}
	public static void main(String[] args) {
		new GraphicEditor();
	}

}
