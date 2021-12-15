import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("그래픽");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("map.png");
		private Image img = icon.getImage();

		public MyPanel() {
			this.setBackground(Color.yellow);
			
			/*
			ImageIcon icon = new ImageIcon("map.png");
			JLabel label = new JLabel(icon);
			setLayout(null);
			label.setSize(200, 200);
			label.setLocation(100, 100);
			add(label);
			//JLabel 컴포넌트로 이미지 그리기
			//장점 : 이미지 그리기 간편하고 쉬움, 이미지가 컴포넌트이므로 이벤트 발생 가능
			//단점 : 이미지 크기 조절 불가, 원본 크기로만 그리기 가능
			*/
		}
		
		public void paintComponent(Graphics g) { //JPanel의 paintComponent()를 오버라이딩
			super.paintComponent(g); //원래 JPanel에 작성된 paintComponent()를 호출 
			
			g.setClip(100, 100, 200, 200);
			Color c = this.getBackground();
			g.setColor(c);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			//ImageIcon icon = new ImageIcon("map.png");
			//Image img = icon.getImage();
			//
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null); //(0, 0) 위치에서 원본크기로 그린다.
			
			g.setColor(Color.magenta);
			g.drawLine(0, 0, 100, 100);
			g.setColor(Color.blue);
			//g.fillRect(100, 100, this.getWidth() - 200, this.getHeight() - 200); //칠하기
			g.setColor(Color.magenta);
			//g.fillOval(100, 100, this.getWidth() - 200, this.getHeight() - 200);
			//그리는 순서에 따라 앞에 그려지는지 뒤로 그려지는지 달라짐
			
			g.setColor(Color.green);
			for (int i = 0; i < 10; i++) {
				g.drawRect(10 + i * 10, 10 + i * 10, 50, 50); //그리기
			}
			g.setColor(new Color(47, 160, 157));
			g.setFont(new Font("Gothic", Font.BOLD, 20));
			g.drawString("자바는 재밌다!", 20, 20);
			
			
			
		}
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
