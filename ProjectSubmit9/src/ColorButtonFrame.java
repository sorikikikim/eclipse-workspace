import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorButtonFrame extends JFrame {
	public ColorButtonFrame() {
		super("Ten Color Buttons Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우 창 종료시 프로세스까지 종료
		this.setSize(500, 300);
		Container c = this.getContentPane(); //프레임에 연결된 컨텐트 팬 할당
		c.setLayout(new GridLayout(1, 10)); //컨텐트 팬에 배치관리자 Grid Layout으로 설정 
		Color color[] = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan,
				Color.blue, Color.magenta, Color.gray, Color.pink, Color.lightGray};
		for (int i = 0; i < 10; i++) {		
			JButton b = new JButton(Integer.toString(i));
			b.setOpaque(true);
			b.setBackground(color[i]);
			c.add(b);
		}	
		this.setVisible(true); //창을 화면에 보이도록 설정
	}

	public static void main(String[] args) {
		new ColorButtonFrame();
	}

}
