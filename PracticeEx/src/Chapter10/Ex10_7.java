package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ex10_7 extends JFrame {
	private JLabel l = new JLabel();
	
	public Ex10_7() {
		setTitle("Key Code 예제 : F1키:초록색, %키:노란색");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(l);
		
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			Container contentPane = (Container)e.getSource();
			
			l.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력되었음");
			
			if (e.getKeyCode() == KeyEvent.VK_F1)
				contentPane.setBackground(Color.GREEN);
			else if (e.getKeyChar() == '%')
				contentPane.setBackground(Color.YELLOW);
		}
		
	}

	public static void main(String[] args) {
		new Ex10_7();
	}

}
