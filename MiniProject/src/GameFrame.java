import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GameFrame extends JFrame {
	//게임 프레임에 붙일 시작화면, 게임화면, 점수화면 생성
	private StartPanel startPanel = new StartPanel();
	private GamePanel gamePanel = new GamePanel();
	private ScorePanel scorePanel = new ScorePanel();
	
	private BGM startBGM = new BGM("SeaVilage.mp3", true);
	
	public GameFrame() {
		setTitle("타이핑 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocation (150, 150);
		setContentPane(startPanel); //startPanel을 컨텐트 팬으로 설정
		setResizable(false);
		startBGM.start(); //배경음악 재생
		makeMenu();
		setVisible(true);
	}
	
	//상단 메뉴바 생성
	private void makeMenu() {
		JMenuBar mBar = new JMenuBar();
		setJMenuBar(mBar);
		
		JMenu fileMenu0 = new JMenu("Falling Takoyaki");
		mBar.add(fileMenu0);
	
		JMenu fileMenu1 = new JMenu("Game");
		fileMenu1.add(new JMenuItem("새 게임"));
		fileMenu1.add(new JMenuItem("초기 화면"));
		fileMenu1.addSeparator();
		fileMenu1.add(new JMenuItem("종료"));
		mBar.add(fileMenu1);
		
		JMenu fileMenu2 = new JMenu("BGM");
		fileMenu2.add(new JMenuItem("배경음악 재생"));
		fileMenu2.add(new JMenuItem("배경음악 정지"));
		fileMenu2.addSeparator();
		fileMenu2.add(new JMenuItem("음량 조절"));
		mBar.add(fileMenu2);
		
		JMenu fileMenu3 = new JMenu("Rank");
		fileMenu3.add(new JMenuItem("랭킹 보기"));
		fileMenu3.add(new JMenuItem("사용자 정보 변경"));
		mBar.add(fileMenu3);
		
		JMenu fileMenu4 = new JMenu("Help");
		fileMenu4.add(new JMenuItem("게임 설명"));
		mBar.add(fileMenu4);
	}
	
	//게임 초기화면
	public class StartPanel extends JPanel {
		private JLabel title = new JLabel("Falling Takoyaki");
		private JLabel level = new JLabel("Level	");
		private String[] levelOp = {"Level1", "Level2", "Level3"};
		private JComboBox<String> selectLevel = new JComboBox<String>(levelOp);
		private JLabel id = new JLabel("ID	");
		private JTextField putId = new JTextField(20);
		private JButton startBtn = new JButton("Game Start");
		private JButton rankBtn = new JButton("Ranking");
		private JButton	helpBtn = new JButton("Help");
		
		private JButton	homeBtn = new JButton("Home");
		private Player player = new Player();
		private int score = 0;
		
		
		public StartPanel() {
			setLayout(null);
			
			title.setFont(new Font("Ubuntu", Font.BOLD, 50));
			title.setSize(600, 80);
			title.setLocation(190, 85);
			add(title);
			
			level.setFont(new Font("Ubuntu", Font.BOLD, 20));
			level.setLocation(260, 200);
			level.setSize(200, 30);
			selectLevel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
			selectLevel.setLocation(340, 190);
			selectLevel.setSize(150, 60);
			add(level);
			add(selectLevel);
			
			id.setFont(new Font("Ubuntu", Font.BOLD, 20));
			id.setLocation(270, 250);
			id.setSize(200, 30);
			putId.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			putId.setLocation(340, 250);
			putId.setSize(150, 30);
			add(id);
			add(putId);
			
			startBtn.setFont(new Font("Ubuntu", Font.BOLD, 30));
			startBtn.setLocation(280, 310);
			startBtn.setSize(200, 45);
			add(startBtn);
			
			rankBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
			rankBtn.setLocation(280, 360);
			rankBtn.setSize(100, 40);
			add(rankBtn);
			
			helpBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
			helpBtn.setLocation(380, 360);
			helpBtn.setSize(100, 40);
			add(helpBtn);
			
			
			//Game start 버튼이 눌러진 경우
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					player = new Player(putId.getText(), selectLevel.getSelectedIndex() + 1 , score);
					player.setId(putId.getText());
					player.setLevel(selectLevel.getSelectedIndex() + 1);
					
					setAllInvisible();
					scorePanel= new ScorePanel(player);
					gamePanel = new GamePanel(player, scorePanel);
					getContentPane().setLayout(new BorderLayout());
					startBGM.close();
					splitPane();
					gamePanel.gameStart(player);
				}	
			});
				
			//Help 버튼이 눌러진 경우
			helpBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setAllInvisible();
					JLabel help = new JLabel("게임 설명");
					JLabel help0 = new JLabel("장사를 시작한 타코야끼 집 사장이 손님에게 타코야끼를 판매하려고 한다.");
					JLabel help1 = new JLabel("타코야끼를 만들려면 떨어지는 타코야끼에 적힌 단어를 정확히 입력해야 한다.\n");
					JLabel help2 = new JLabel("올바르게 단어를 입력하면 타코야끼는 더이상 떨어지지 않고 판매 된다.\n");
					JLabel help3 = new JLabel("1 단계는 초당 10픽셀로 떨어지도록 설정하고,\n");
					JLabel help4 = new JLabel("2단계는 속도 가 초당 15픽셀로 떨어지도록 설정하고, ");
					JLabel help5 = new JLabel("3단계는 ­20 픽셀의 속도로 떨어진다. \n");
					JLabel help7 = new JLabel("상단에 하트로 생명을 표현해 단어가 사라질때까지 입력하지 못하는 ");
					JLabel help8 = new JLabel("경우에 생명이 하나씩 사라지도록 한다.\n 단계가 올라갈 때마다 간판에는 1단계(신규 맛집)");
					JLabel help9 = new JLabel("-> 2단계(입소문 난 맛집) -> 3단계(동네 1위 맛집) 이라고 기재된다.\n");
					help.setBounds(300, 80, 900, 100);
					help0.setBounds(200, 120, 900, 100);
					help1.setBounds(200, 140, 900, 100);
					help2.setBounds(200, 160, 900, 100);
					help3.setBounds(200, 180, 900, 100);
					help4.setBounds(200, 200, 900, 100);
					help5.setBounds(200, 220, 900, 100);
					help7.setBounds(200, 240, 900, 100);
					help8.setBounds(200, 260, 900, 100);
					help9.setBounds(200, 280, 900, 100);
					add(help);
					add(help0);
					add(help1);
					add(help2);
					add(help3);
					add(help4);
					add(help5);
					add(help7);
					add(help8);
					add(help9);
					

					help.getParent().add(homeBtn);
					homeBtn.setVisible(true);
					homeBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
					homeBtn.setLocation(330, 400);
					homeBtn.setSize(100, 40);
					homeBtn.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							help.setVisible(false);
							help0.setVisible(false);
							help1.setVisible(false);
							help2.setVisible(false);
							help3.setVisible(false);
							help4.setVisible(false);
							help5.setVisible(false);
							help7.setVisible(false);
							help8.setVisible(false);
							help9.setVisible(false);
							homeBtn.setVisible(false);
							setAllVisible();
						}
					});
				}
				
			});
		}
		
		//좌측은 게임 화면, 우측은 점수 화면
		private void splitPane() {
			JSplitPane hPane = new JSplitPane();
			getContentPane().add(hPane, BorderLayout.CENTER);
			hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
			hPane.setDividerLocation(500);
			hPane.setEnabled(false);
			hPane.setLeftComponent(gamePanel);
			hPane.setRightComponent(scorePanel);
		}
		
		private void setAllInvisible() {
			title.setVisible(false);
			level.setVisible(false);
			selectLevel.setVisible(false);
			id.setVisible(false);
			putId.setVisible(false);
			startBtn.setVisible(false);
			rankBtn.setVisible(false);
			helpBtn.setVisible(false);
		}
		
		private void setAllVisible() {
			title.setVisible(true);
			level.setVisible(true);
			selectLevel.setVisible(true);
			id.setVisible(true);
			putId.setVisible(true);
			startBtn.setVisible(true);
			rankBtn.setVisible(true);
			helpBtn.setVisible(true);
		}
		
		
		//배경 이미지 설정
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("startImg.jpg");
			g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			setOpaque(true);
		}
	}
}

