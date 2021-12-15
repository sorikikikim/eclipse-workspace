import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GamePanel extends JPanel {
	private ScorePanel scorePanel;
	private SignPanel signPanel = null;
	private FallingPanel fallingPanel = new FallingPanel();
	
	private Player player = new Player();
	
	private Vector <JLabel> target = new Vector<JLabel>();
	
	private BGM level1BGM = new BGM("ChocolateCookieJam.mp3", true);
	private BGM level2BGM = new BGM("Ignite.mp3", true);
	private BGM level3BGM = new BGM("BurnItAllDown.mp3", true);
	
	private String fallingWords = null;
	private Words randomWord = null;
	private JTextField inputText = new JTextField(30);
	private InputPanel inputPanel = new InputPanel();
	private int fallingDelay = 0;
	private int [] fallingSpeed = {500, 400, 300};
	private int [] generationSpeed = {3000, 3000, 2500};

	//스레드 생성 및 초기화
	private AttachImgWordThread attachImgWordThread = new AttachImgWordThread(target);
	private FallingThread fallingThread = new FallingThread(target, player);
	private MissWordThread missWordThread = new MissWordThread(target);
	
	private boolean isOver = false;
	
	public GamePanel() {
		
	}

	public GamePanel(Player player, ScorePanel scorePanel) {
		this.player = player;
		this.scorePanel = scorePanel;
		
		attachImgWordThread = new AttachImgWordThread(target);
		fallingThread = new FallingThread(target, player);
		randomWord = new Words("words.txt");
		
		setLayout(new BorderLayout());
		signPanel = new SignPanel();
		
		//gamePanel의 북쪽은 간판 부분, 중앙은 단어가 떨어지는 부분, 남쪽은 단어를 입력하는 부분
		add(signPanel, BorderLayout.NORTH);
		add(fallingPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
		
		
		inputText.setHorizontalAlignment(JTextField.CENTER);
		inputText.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		
		inputText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				String text = tf.getText(); //사용자가 입력한 값
				int flag = 0;
				for (int i = 0; i < target.size(); i++) {
					String word = target.get(i).getText(); //떨어지는 단어
					//단어를 맞춘 경우
					if (word.equals(text)) {
						scorePanel.correct(player);
						scorePanel.repaintScore();
						fallingPanel.remove(target.get(i));
						target.remove(i);
						tf.setText(null);
						flag = 1;
						break ;
					}
				}
				//맞추지 못한 경우
				if (flag == 0) {
					scorePanel.wrong(player);
					scorePanel.repaintScore();
					tf.setText(null);
				}	
			}
		});
	}
	
	public void gameStart(Player player) {
		this.player = player;
		//레벨에 따라 재생 곡 다르게 하기
		if (player.getLevel() == 1) {
			level1BGM.start();
		}
		else if (player.getLevel() == 2) {
			level2BGM.start();
		}
		else
			level3BGM.start();
		//게임시작시 단어 생성, 떨어뜨리기, 놓친단어 감지하는 스레드 시작
		attachImgWordThread.start();
		fallingThread.start();
		missWordThread.start();
	}
	
	public void gameOver() {
		if (player.getLevel() == 1) {
			level1BGM.close();
		}
		else if (player.getLevel() == 2) {
			level2BGM.close();
		}
		else
			level3BGM.close();
		attachImgWordThread.interrupt();
		fallingThread.interrupt();
		missWordThread.interrupt();
	}
	
	//레벨에 따라 다른 간판을 보여주는 부분
	class SignPanel extends JPanel {
		private JLabel sign = new JLabel("");
		
		public SignPanel() {
			sign.setFont(new Font("나눔고딕", Font.BOLD, 30));
			sign.setSize(this.getWidth(), this.getHeight());
			makeSign();
			this.add(sign);
		}
		
		public void makeSign() {
			if (player.getLevel() == 1) {
				sign.setText("신규맛집 모모타코");
			}
			else if (player.getLevel() == 2) {
				sign.setText("입소문 난 맛집 모모타코");
			}
			else {
				sign.setText("동네 1위 맛집 모모타코");
			}		
		}
 	}
	//단어가 떨어지는 부분
	class FallingPanel extends JPanel {
		public FallingPanel() {
			setLayout(null);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("fallingPanel.jpeg");
			g.drawImage(icon.getImage(), 0 , 0, fallingPanel.getWidth(), fallingPanel.getHeight() + 50, this);

			setOpaque(false);
		}
	}
	
	//값을 입력받는 부분
	class InputPanel extends JPanel {
		public InputPanel() {
			setLayout(new FlowLayout());
			this.setBackground(Color.LIGHT_GRAY);
			add(inputText);
		}
 	}
	
	//단어와 이미지를 붙여서 생성는 스레드
	private class AttachImgWordThread extends Thread {
		private Vector <JLabel> target;
		
		public synchronized void attachImgWord() {
			//이미지 크기 변경 후 새로운 ImageIcon으로 재생성
			ImageIcon icon = new ImageIcon("takoyaki.png");
			Image  img = icon.getImage();
			Image changeImg = img.getScaledInstance(50,  50, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImg);
			
			//targetLabel에 ImageIcon과 랜덤으로 가져온 단어 붙이기
			JLabel targetLabel = new JLabel("", changeIcon, JLabel.CENTER);
			targetLabel.setVerticalTextPosition(JLabel.CENTER);
			targetLabel.setHorizontalTextPosition(JLabel.RIGHT);
			String newWord = randomWord.getRandomWords();
			
			targetLabel.setText(newWord);
	
			targetLabel.setHorizontalAlignment(JLabel.CENTER);
			targetLabel.setSize(200, 40);
			
			targetLabel.setFont(new Font("Ubuntu", 1, 20));
			targetLabel.setForeground(Color.BLUE);
			
			//랜덤으로 떨어지는 단어들의 x좌표 설정
			int startX = (int)(Math.random() * fallingPanel.getWidth());
			while(true) {
				if ((startX + targetLabel.getWidth()) > fallingPanel.getWidth())
				{
					startX = (int)(Math.random() * fallingPanel.getWidth());
				}
				else
					break;
			}
			targetLabel.setLocation(startX, 0);
			targetLabel.setOpaque(false);
			target.addElement(targetLabel); // 단어들의 벡터 target에 생성한 targetLabel 추가
			fallingPanel.add(targetLabel);
		}
		
		public AttachImgWordThread(Vector <JLabel> target) {
			this.target = target;
		}
		
		@Override
		public void run() {
			while(true) {
				int generationTime = generationSpeed[player.getLevel()-1];
				attachImgWord();
				fallingPanel.repaint();
				try {
					sleep(generationTime);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	
	//단어를 떨어뜨리는 스레드
	private class FallingThread extends Thread {
		private Vector <JLabel> target;
		private Player player;
		
		public FallingThread(Vector<JLabel> target, Player player) {
			this.target = target;
			this.player = player;
			
		}
		
		//다른 스레드와 동기화
		public synchronized void fallingWord(Player player) {
			for (int i = 0; i < target.size(); i++) {
				int x = target.get(i).getX();
				int y = target.get(i).getY();
				if (player.getLevel() == 1)
					target.get(i).setLocation(x, y + 10);
				else if (player.getLevel() == 1)
					target.get(i).setLocation(x, y + 15);
				else
					target.get(i).setLocation(x, y + 20);
				fallingPanel.repaint();
			}
		}
		
		public void run() {
			while (true) {
				fallingDelay = fallingSpeed[player.getLevel() - 1];
				fallingWord(player);
				fallingPanel.repaint();
				try {
					sleep(fallingDelay);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	
	//입력하지 못하고 놓친 단어 감지하는 스레드
	private class MissWordThread extends Thread {
		private Vector <JLabel> target;
		
		public MissWordThread(Vector <JLabel> target) {
			this.target = target;
		}
		
		public void run() {
			while (true) {
				try {
					sleep(1);
					for (int i = 0; i < target.size(); i++) {
						int y = ((JLabel)target.get(i)).getY();
						if (y > fallingPanel.getHeight() + 10) {
							isOver = scorePanel.looseLife(player);
							if (isOver == true) {
								gameOver();
							}
							else {
								fallingPanel.remove(target.get(i));
								target.remove(i);
							}
						}
						
					}
				} catch (InterruptedException e) {
					return ;
				}
			}
		}
	}
}

//words.txt 파일을 읽어 벡터에 저장 후 랜덤으로 단어 추출
class Words {
	private Vector<String> words = new Vector<String>();
	private int index = 0;
	String fileName;
	public Words(String fileName) {
		this.fileName = fileName;
		readFile();
	}
	
	public void readFile() {
		try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			while (scanner.hasNext()) {
				String word = scanner.nextLine();
				words.add(word);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getRandomWords() {
		index = (int)(Math.random() * words.size());
		return words.get(index);
	}
}