import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	private GamePanel gamePanel = new GamePanel("@", "M");
	public GameFrame() {
		super("몬스터로부터 도망가기");
		setContentPane(gamePanel);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
	}
	
	class MonsterThread extends Thread {
		private JLabel avataLabel = null;
		private JLabel monsterLabel = null;
		private long delay;
		
		public MonsterThread(JLabel avataLabel, JLabel monsterLabel, long delay) {
			this.avataLabel = avataLabel;
			this.monsterLabel = monsterLabel;
			this.delay = delay;
		}
		@Override
		public void run() {
			while (true) {
				//x의 위치 조정
				if (monsterLabel.getX() < avataLabel.getX())
					monsterLabel.setLocation(monsterLabel.getX() + 5, monsterLabel.getY());
				else
					monsterLabel.setLocation(monsterLabel.getX() - 5, monsterLabel.getY());
				//y의 위치 조정
				if (monsterLabel.getY() < avataLabel.getY())
					monsterLabel.setLocation(monsterLabel.getX(), monsterLabel.getY() + 5);
				else
					monsterLabel.setLocation(monsterLabel.getX(), monsterLabel.getY() - 5);
				
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					return; //스레드 종료
				}
			}
		}
	}
	
	class GamePanel extends JPanel {
		private String avataChar, monsterChar;
		private JLabel avataLabel = null;
		private JLabel monsterLabel [] = new JLabel [10];
		
		public GamePanel(String avataChar, String monsterChar) {
			this.avataChar = avataChar;
			this.monsterChar = monsterChar;
			this.avataLabel = new JLabel(avataChar);
			//this.monsterLabel = new JLabel(monsterChar);
			
			setLayout(null);
			
			avataLabel.setSize(30, 30);
			avataLabel.setLocation(10, 10);
			add(avataLabel);
			
			for (int i = 0; i < 10; i++) {
				monsterLabel[i] = new JLabel(monsterChar);
				monsterLabel[i].setSize(30, 30);
				monsterLabel[i].setLocation((int)(Math.random() * 200), (int)(Math.random() * 200));
				add(monsterLabel[i]);
				MonsterThread th = new MonsterThread(avataLabel, monsterLabel[i], 200);
				th.start();
			}
			
			this.addKeyListener(new MyKey());
			//MonsterThread th = new MonsterThread(avataLabel, monsterLabel, 200);
			//th.start();
		}
		
		class MyKey extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					for (int i = 0; i < 10; i++) {
						monsterLabel[i].setLocation((int)(Math.random() * 200), (int)(Math.random() * 200));
					}
					monsterLabel[0].getParent().repaint();
					return ;
				}
				int x = avataLabel.getX();
				int y = avataLabel.getY();
				int code = e.getKeyCode();
				switch (code) {
					case KeyEvent.VK_UP: avataLabel.setLocation(x, y - 10); break;
					case KeyEvent.VK_DOWN: avataLabel.setLocation(x, y + 10); break;
					case KeyEvent.VK_LEFT: avataLabel.setLocation(x-10, y); break;
					case KeyEvent.VK_RIGHT: avataLabel.setLocation(x+10, y); break;
				}
				
				avataLabel.getParent().repaint();
				
			}
		}
	}

	public static void main(String[] args) {
		new GameFrame();

	}

}
