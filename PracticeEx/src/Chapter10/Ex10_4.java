package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex10_4 extends JFrame {
	private JLabel l = new JLabel("Hello");
	public Ex10_4() {
		setTitle("Mouse 이벤트 예제");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MyMouseListener());
		l.setSize(60, 20);
		l.setLocation(10, 10);
		c.add(l);
		setVisible(true);
	}

	class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e) { //마우스가 눌러지는 순간 호출
			int x = e.getX();
			int y = e.getY();
			l.setLocation(x, y);
		}
		
		public void mouseReleased(MouseEvent e) { //마우스를 놓는 순간 호출
			
		}
		
		public void mouseClicked(MouseEvent e) { //마우스를 놓는 순간 호출. 눌린 위치와 동일
			
		}
		
		public void mouseEntered(MouseEvent e) { //마우스가 컴포넌트 위에 올라오는 순간 호출
			
		}
		
		public void mouseExited(MouseEvent e) { //마우스가 컴포넌트를 벗어나는 순간 호출
			
		}
	}
	
	public static void main(String[] args) {
		new Ex10_4();
	}
}
