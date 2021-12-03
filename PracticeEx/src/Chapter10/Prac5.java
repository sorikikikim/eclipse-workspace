package Chapter10;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Prac5 extends JFrame {
	private JLabel l = new JLabel("Love Java");
	public Prac5() {
		setTitle("+, - 키로 폰트 크기 조절");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(l);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				Font f = l.getFont();
				int size = f.getSize();
				if (e.getKeyChar() == '+') 
					l.setFont(new Font("Arial", Font.PLAIN, size + 5));
				if (e.getKeyChar() == '-') {
					if (size - 5 > 0)
						l.setFont(new Font("Arial", Font.PLAIN, size - 5));
				}
			}
		});
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new Prac5();
	}
}
