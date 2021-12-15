import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	private Player player = new Player();
	private GamePanel gamePanel = new GamePanel();
	private int score = 0; //점수
	private int life = 5; // 생명
	private JLabel [] lifeImg = new JLabel[life];
	private JLabel sell = new JLabel("매출    ₩");
	private JLabel lifeL = new JLabel("생명 ");
	private JLabel user = new JLabel("");
	private JLabel sellLabel = new JLabel(Integer.toString(score));
	private JLabel OverLabel = new JLabel("영업중...");
	
	public ScorePanel() {
		
	}
	
	public ScorePanel(Player player) {
		setLayout(null);
		
		this.player = player;
		user = new JLabel("플레이어 ID : " + player.getId());
		user.setFont(new Font("나눔고딕", 1, 15));
		user.setSize(200,20);
		user.setLocation(65, 155);
		add(user);
		
		sell.setFont(new Font("나눔고딕", 1, 15));
		sell.setSize(90,20);
		sell.setLocation(65, 120);
		add(sell);
		
		lifeL.setFont(new Font("나눔고딕", 1, 15));
		lifeL.setSize(50,20);
		lifeL.setLocation(65, 95);
		add(lifeL);
		
		sellLabel.setFont(new Font("나눔고딕", 1, 15));
		sellLabel.setSize(100,20);
		sellLabel.setLocation(140, 120);
		add(sellLabel);
		
		//생명을 표시하는 하트 이미지
		ImageIcon icon = new ImageIcon("heart.png");
		Image  img = icon.getImage();
		Image changeImg = img.getScaledInstance(30,  30, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		
		for (int i = 0; i < life; i++) {
			lifeImg[i] = new JLabel(changeIcon);
			lifeImg[i].setSize(50, 50);
			lifeImg[i].setLocation(25 * i + 95, 80);
			add(lifeImg[i]);
		}
		
		OverLabel.setFont(new Font("Ubuntu",1,15));
		OverLabel.setSize(200, 50);
		OverLabel.setLocation(30, 300);
		add(OverLabel);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("scorePanel.jpeg");
		ImageIcon icon2 = new ImageIcon("rightBottom.png");
		g.drawImage(icon.getImage(), 0 , 0, this.getWidth(), this.getHeight() / 2 + 100, this);
		g.drawImage(icon2.getImage(), 0 ,this.getHeight() / 2 + 50, this.getWidth(), this.getHeight() - 300 , this);
		setOpaque(false);
	}
	
	synchronized void correct(Player player) {
		score += 500;
	
		player.setScore(score);
		sellLabel.setText(Integer.toString(score));
		System.out.println(score);
		sellLabel.getParent().repaint();
	}
	
	synchronized void wrong(Player player) {
		score -= 500;
	
		player.setScore(score);
		sellLabel.setText(Integer.toString(score));
		System.out.println(score);
		sellLabel.getParent().repaint();
	}
	
	public void repaintScore() {
		sellLabel.getParent().repaint();
	}
	
	public void initPlayerInfo(String name, int level, int score) {
		player = new Player(name, level, score);
	}
	
	synchronized boolean looseLife(Player player) {
		life--;
		boolean isTrue = false;
		
		switch(life) {
		case 4: //생명이 4개
			lifeImg[4].setVisible(false);
			break;
		case 3: //생명이 3개 
			lifeImg[3].setVisible(false);
			break;
		case 2: //생명이 2개 
			lifeImg[2].setVisible(false);
			break;
		case 1: //생명이 1개
			lifeImg[1].setVisible(false);
			break;
		case 0: //생명이 0개 
			lifeImg[0].setVisible(false);
			
			OverLabel.setText("GAME OVER!!!");
			OverLabel.setLocation(30, 300);
		
		
			// 게임 종료 후 .txt 파일에 정보 저장
			Player p = new Player(player.getId(), player.getLevel(), player.getScore());
			p.backupPlayer();
			
			//종료, 재시작 
			String [] option = {"종료", "다시시작"};
			int prompt = JOptionPane.showOptionDialog(gamePanel, player.getId() + "님은 " + player.getScore() + "점 입니다.\n게임을 종료합니다.",
					"게임 종료", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
			isTrue = true;
			// "종료" 선택 -> 프레임 닫기
			if (prompt == 0) { 
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
			// "다시시작" 선택 -> 새 프레임 열기
			else if (prompt == 1) { 
				GameFrame f = new GameFrame();
			}
			break;
		}
		return isTrue;
	}
}