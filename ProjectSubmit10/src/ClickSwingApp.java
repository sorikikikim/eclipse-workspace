//클릭 연습용 스윙 응용프로그램을 작성하라. JLabel을 이용하여 문자열이 “C”인 레이블을 하나 만들고 초기 위치를 (100,100)으로 하라. 문자열을 클릭할 때 마다 레이블은 프레임 내의 랜덤한 위치로 움직인다.
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ClickSwingApp extends JFrame{
	private JLabel click = new JLabel("C");
	public ClickSwingApp() {
		super("클릭 연습용 응용프로그램"); //setTitle
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 닫을 시 프로세스 종료
		this.setSize(500, 500); //프레임 크기 설정
		click.setSize(30, 30); //레이블의 크기 설정
		click.setLocation(100, 100); //레이블의 초기위치 설정
		Container c = this.getContentPane(); //프레임에 연결된 컨텐트팬 할당
		c.setLayout(null); //컴포넌트의 위치를 랜덤으로 결정하기 위해 배치관리자 제거
		c.addMouseListener(new SetLocation()); //마우스 리스너 등록
		c.add(click); //컨테이너에 click 레이블 추가
		
		this.setVisible(true); //프레임 출력
	}
	
	private class SetLocation extends MouseAdapter{
		public void mouseClicked(MouseEvent e) { //마우스가 눌러진 위치에서 그대로 놓는 순간 호출
			Container c = (Container)e.getSource(); //마우스가 클릭된 컨텐트팬
			int width = c.getWidth(); //너비와 높이를 받아서
			int height = c.getHeight();
			int x = (int)(Math.random() * (width - 50)) + 20; //랜덤으로 좌표 설정
			int y = (int)(Math.random() * (height - 50)) + 20;
			click.setLocation(x, y); //레이블의 랜덤 위치 설정
		}
	}
	
	public static void main(String[] args) {
		new ClickSwingApp(); //프레임 생성
	}
}

