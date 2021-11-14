package Chapter9;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class Prac7 extends JFrame {
	public Prac7() {
		setTitle("계산기 프레임");
		setSize(350, 250);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.GRAY);
		p1.add(new JLabel("수식입력"));
		p1.add(new JTextField(13));
		c.add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 4, 3, 3));
		for (int i = 0; i < 10; i++)
			p2.add(new JButton(Integer.toString(i)));
		p2.add(new JButton("CE"));
		p2.add(new JButton("계산"));
		JButton add = new JButton("+");
		add.setBackground(Color.GREEN);
		add.setOpaque(true);
		add.setBorderPainted(false);
		JButton sub = new JButton("-");
		sub.setBackground(Color.GREEN);
		sub.setOpaque(true);
		sub.setBorderPainted(false);
		JButton mul = new JButton("x");
		mul.setBackground(Color.GREEN);
		mul.setOpaque(true);
		mul.setBorderPainted(false);
		JButton div = new JButton("/");
		div.setBackground(Color.GREEN);
		div.setOpaque(true);
		div.setBorderPainted(false);
		p2.add(add);
		p2.add(sub);
		p2.add(mul);
		p2.add(div);
		c.add(p2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.YELLOW);
		p3.add(new JLabel("계산 결과"));
		p3.add(new JTextField(10));
		c.add(p3, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prac7();
	}
}
