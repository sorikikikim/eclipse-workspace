package Chapter9;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

public class Prac8 extends JFrame {
	public Prac8() {
		setTitle("여러 개의 패널을 가진 프레임");
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.GRAY);
		p1.add(new JButton("열기"));
		p1.add(new JButton("닫기"));
		p1.add(new JButton("나가기"));
		c.add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		for (int i = 0; i < 10; i++) {
			JLabel l = new JLabel("*");
			l.setSize(10, 10);
			l.setLocation((int)(Math.random() * 200) + 50, (int)(Math.random() * 200) + 50);
			l.setForeground(Color.RED); //글자색 설정
			p2.add(l, BorderLayout.CENTER);
		}
		c.add(p2);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.YELLOW);
		p3.add(new JButton("Word Input"));
		p3.add(new JTextField(15));
		c.add(p3, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prac8();
	}
}
