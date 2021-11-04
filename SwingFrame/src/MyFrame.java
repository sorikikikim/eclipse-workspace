import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MyFrame extends JFrame{
	JTextField tf = new JTextField(15);
	public MyFrame() {
		super("나의 GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private class NorthPanel extends JPanel {
		public NorthPanel() {
			setLayout(new FlowLayout());
			this.setBackground(Color.gray);
			add(new JLabel("수식 입력"));
			this.add(tf);
		}
		
	}
	
	private class SouthPanel extends JPanel {
		public SouthPanel() {
			setLayout(new FlowLayout());
			this.setBackground(Color.YELLOW);
			this.add(new JLabel("계산결과"));
			this.add(tf);
		}
	}
	
	private class CenterPanel extends JPanel {
		public CenterPanel() {
			setLayout(new GridLayout(4, 4, 5, 5));
			this.setBackground(Color.MAGENTA);
			for (int i = 0; i < 10; i++) {
				JButton b = new JButton(Integer.toString(i));
				b.addActionListener(new MyAction());
				add(b);
			}
			add(new JButton("CE"));
			add(new JButton("계산"));
			
			JButton btn [] = {new JButton("+"), new JButton("-"), new JButton("x"),
					new JButton("/")};
			
			for (int i = 0; i < btn.length; i++) {
				btn[i].setBackground(Color.cyan);
				add(btn[i]);
			}
			
		}
	}
	
	class MyAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)(e.getSource());
			String s = b.getText();
			tf.setText(tf.getText() + s);
		}
		
	}
	public static void main(String[] args) {
		new MyFrame();

	}

}
