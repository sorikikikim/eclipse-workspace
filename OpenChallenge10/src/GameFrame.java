import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	public GameFrame() {
		super("게임");
		this.setContentPane(new GamePanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}

	class GamePanel extends JPanel {
		private JLabel label [] = new JLabel [3]; 
		private JLabel resultLabel = new JLabel("시작합니다.");
		
		public GamePanel() {
			this.setBackground(Color.ORANGE);
			this.setLayout(null);
			for (int i = 0; i < label.length; i++) {
				label[i] = new JLabel("0");
				label[i].setSize(60, 30);
				label[i].setLocation(30 + i * 80, 50);
				label[i].setBackground(Color.MAGENTA);
				label[i].setForeground(Color.YELLOW);
				label[i].setOpaque(true);
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
				label[i].setHorizontalAlignment(JLabel.CENTER);
				add(label[i]);
			}
			resultLabel.setSize(100, 20);
			resultLabel.setLocation(100, 200);
			add(resultLabel);
			
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == '\n') {
						int x1 = (int) (Math.random() * 5);
						label[0].setText(Integer.toString(x1));
						int x2 = (int) (Math.random() * 5);
						label[1].setText(Integer.toString(x2));
						int x3 = (int) (Math.random() * 5);
						label[2].setText(Integer.toString(x3));
						if (x1 == x2 && x1 == x3) { //성공
							resultLabel.setText("성공!");
						}
						else {
							resultLabel.setText("아쉽군요");
						}
					}
				}
			});
		}
	}
	public static void main(String[] args) {
		new GameFrame();
	}

}
