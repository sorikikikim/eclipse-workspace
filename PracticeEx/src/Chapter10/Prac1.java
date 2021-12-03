package Chapter10;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Prac1 extends JFrame {
	public Prac1() {
		setTitle("마무스 올리기 내리기");
		setSize(400, 200);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel l = new JLabel("Love Java");
		l.addMouseListener(new MouseAdapter() { //label위에 마우스를 올려야하므로 l에 마우스 리스너 등
			public void mouseEntered(MouseEvent e) {
				l.setText("사랑해");
			}
			
			public void mouseExited(MouseEvent e) {
				JLabel label = (JLabel)e.getSource();
				l.setText("Love Java");
			}
		});
		c.add(l);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prac1();
	}
}
