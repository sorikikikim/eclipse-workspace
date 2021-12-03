package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ex10_5 extends JFrame {
	private JLabel l = new JLabel("Hello");
	public Ex10_5() {
		setTitle("Mouse 이벤트 예제");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MyMouseListener());
		/* 익명의 클래스와 객체 생성
		 	c.addMouseListener(new MouseAdapter() { //오버라이딩. 마우스가 눌러지는 순간 호출
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				l.setLocation(x, y);
			}
		});
		*/
		l.setSize(60, 20);
		l.setLocation(10, 10);
		c.add(l);
		
		setVisible(true);
	}
	
	private class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			l.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new Ex10_5();
	}
}
