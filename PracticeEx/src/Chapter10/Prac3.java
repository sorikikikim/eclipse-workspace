package Chapter10;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Prac3 extends JFrame {
	private JLabel l = new JLabel("Love Jave");
	public Prac3() {
		setTitle("Left 키로 문자열 교체");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(l);
		c.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (l.getText().equals("Love Java"))
						l.setText("avaJ evoL");
					else
						l.setText("Love Java");
				}
			}
		});	
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prac3();
	}
}
