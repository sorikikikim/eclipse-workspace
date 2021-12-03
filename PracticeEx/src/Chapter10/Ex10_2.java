package Chapter10;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Ex10_2 extends JFrame {
	public Ex10_2() {
		setTitle("Action 이벤트 리스너 예제");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setVisible(true);
	}
	
	//내부 클래스로 Action 이벤트 리스너 만들기
	private class MyActionListener implements ActionListener{ 
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			
			Ex10_2.this.setTitle(b.getText());
			// = setTitle(b.getText());
		}
	}

	public static void main(String[] args) {
		new Ex10_2();
	}
}
