import java.util.Vector;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class SnowFrame extends JFrame {
	public SnowFrame() {
		super("샤갈의 눈 내리는 마을");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new SnowPanel());
		setVisible(true);
	}
	
	class SnowPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("snowback.jpeg");
		private Image img = icon.getImage();
		private final int SNOWS = 50;
		private final int SNOW_SIZE = 10;
		private Vector<Point> v = new Vector<Point>(SNOWS);
		
		public SnowPanel() {
			this.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					//처음 호출될 때, 크기가 처음으로 결정되었을 때
					makeSnow();
					new SnowThread().start();
					SnowPanel.this.removeComponentListener(this);
				}
			});
		}
		
		class SnowThread extends Thread {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(300);
						changeSnowPosition();
						SnowPanel.this.repaint();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void changeSnowPosition() {
			for (int i = 0; i < v.size(); i++) {
				Point p = v.get(i);
				int dir = Math.random() > 0.5 ? 1 : -1;
				int offsetX = (int)(Math.random() * 3) * dir;
				int offsetY = (int)(Math.random() * 7);
				
				p.x += offsetX;
				p.y += offsetY;
				
				if (p.x < 0)
					p.x = 0;
				if (p.y > SnowPanel.this.getHeight())
					p.y = 5;
			}
		}
		
		private void makeSnow() {
			for (int i = 0; i < SNOWS; i++) {
				Point p = new Point((int)(Math.random() * this.getWidth()), 
						(int)(Math.random() * this.getHeight()));
				//getWidth와 getHeight가 처음에는 (0,0)
				System.out.println(p.x + "," + p.y);
				v.add(p);
			}
		}
		
		@Override
		public void paintComponent(Graphics g) { //callback 함수, 내가 호출하면 안됨
			super.paintComponent(g);
			
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
			//System.out.print("1"); //화면에 그려질때마다 paintComponent()가 불려지는 것을 볼 수 있음
			g.setColor(Color.WHITE);
			for (int i = 0; i < v.size(); i++) {
				Point p = v.get(i);
				g.fillOval(p.x, p.y, SNOW_SIZE, SNOW_SIZE);
			}
		}
	}
	public static void main(String[] args) {
		new SnowFrame();
	}
}
