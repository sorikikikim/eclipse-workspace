import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JMenu;

public class GameFrame extends JFrame {
	public GameFrame() {
		setTitle("타이핑 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		splitPane(); //JSplitPane을 생성하여 컨텐트팬의 center에 부착
		makeMenu();
		makeToolBar();
		setResizable(false);
		setVisible(true);
	}
	
	private void splitPane() {
		JSplitPane hPane = new JSplitPane();
		getContentPane().add(hPane, BorderLayout.CENTER);
		hPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		hPane.setDividerLocation(500);
		hPane.setEnabled(false);
		hPane.setLeftComponent(new GamePanel());
		
		JSplitPane pPane = new JSplitPane();
		pPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pPane.setDividerLocation(300);
		pPane.setTopComponent(new ScorePanel());
		pPane.setBottomComponent(new EditPanel());
		hPane.setRightComponent(pPane);
	}
	
	private void makeMenu() {
		JMenuBar mBar = new JMenuBar();
		setJMenuBar(mBar);
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem("열기"));
		fileMenu.add(new JMenuItem("닫기"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("종료"));
		mBar.add(fileMenu);
	}
	
	private void makeToolBar() {
		JToolBar tBar = new JToolBar();
		tBar.add(new JButton("열기"));
		tBar.add(new JButton("닫기"));
		getContentPane().add(tBar, BorderLayout.NORTH);
	}
}
