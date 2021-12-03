package Chapter10;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Ex10_6 extends JFrame {
	private JLabel [] keyLabel;
	public Ex10_6() {
		setTitle("keyListener 예제");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		
		keyLabel = new JLabel [3];
		keyLabel[0] = new JLabel(" getKeyCode() ");
		keyLabel[1] = new JLabel(" getKeyChar() ");
		keyLabel[2] = new JLabel(" getKeyText() ");
		
		for (int i = 0; i < 3; i++) {
			keyLabel[i].setBackground(Color.YELLOW);
			keyLabel[i].setOpaque(true);
			c.add(keyLabel[i]);
		}
		
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char keyChar = e.getKeyChar();
			int keyCode = e.getKeyCode();
			
			keyLabel[0].setText(Integer.toString(keyCode));
			keyLabel[1].setText(Character.toString(keyChar));
			keyLabel[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("KeyPressed");
		}
		
		public void keyReleased(KeyEvent e) {
			System.out.println("KeyReleased");
		}
		
		public void keyTyped(KeyEvent e) {
			System.out.println("KeyTyped");
		}
	}

	public static void main(String[] args) {
		new Ex10_6();

	}

}
