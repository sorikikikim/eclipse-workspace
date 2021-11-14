package Chapter9;
import javax.swing.JFrame;

public class Ex9_1 extends JFrame{
	public Ex9_1() {
		setTitle("300x300 스윙 프레임 만들기");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Ex9_1 frame = new Ex9_1();
	}

}
