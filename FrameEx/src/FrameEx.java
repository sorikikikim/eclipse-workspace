import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class FrameEx extends JFrame {
	public FrameEx() { 
		this.setTitle("300x300 스윙 프레임 만들기");
		//super("300x300 스윙 프레임 만들기"); //JFrame의 생성자 호출
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,200);
		this.setSize(300, 300);
		this.setResizable(false);
		Container c = this.getContentPane(); //컨텐트팬 영역의 객체를 알려줘
		c.setBackground(Color.ORANGE);
		//c.setLayout(new FlowLayout());
		//c.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 100));
		/*c.setLayout(new BorderLayout(30, 10));
		c.add(new JButton("OK"), BorderLayout.NORTH);
		c.add(new JButton("Cancel"), BorderLayout.SOUTH);
		c.add(new JButton("Ignore"), BorderLayout.EAST);
		c.add(new JButton("Hello"), BorderLayout.WEST);
		c.add(new JButton("Exit"), BorderLayout.CENTER);*/
		//c.add(new JLabel("안녕하세요, 여러분!"));
		c.setLayout(new GridLayout(4,3, 5,5));
		for (int i = 0; i < 12; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setBackground(Color.GREEN);
			b.setFont(new Font("고딕체", Font.ITALIC, 20));
			b.setOpaque(true);
			b.setBorderPainted(false);
			c.add(b);
		}
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		FrameEx frame = new FrameEx();
		//System.out.println("메인 종료합니다.");
	}
}
