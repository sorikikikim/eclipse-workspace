import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NoLayoutEx extends JFrame {
	public NoLayoutEx() {
		setTitle("절대 위치 절대 크기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		Container c = this.getContentPane();
		c.setBackground(Color.YELLOW);
		c.setLayout(null);
		for (int i = 1; i < 10; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setSize(80, 20); //배치(크기, 위치)하지 않으면 보이지 않
			b.setLocation(10 + (i * 30), 10 + (i * 15));
			c.add(b);
			
			b.addActionListener(new ActionListener() { //버튼에 이벤트 핸들러를 작성
				public void actionPerformed(ActionEvent e) { //버튼을 누르면 이 함수 실행
					JButton ba = (JButton)(e.getSource()); //다운 캐스팅
					//ba는 눌러진 버튼
					ba.setBackground(Color.MAGENTA);
					ba.setOpaque(true);
					ba.setBorderPainted(false);
				}
			});
		}
		JLabel text = new JLabel("안녕, GUI!");
		text.setSize(100, 20);
		text.setLocation(200, 300);
		c.add(text);
		
		this.setVisible(true);
	}
	
	public static void main(String [] args) {
		new NoLayoutEx();
	}
}
