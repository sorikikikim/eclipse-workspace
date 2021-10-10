import java.util.Scanner;

public class Player {
	private String name;
	
	public Player() {
		name = "";
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String toString() {
		return "[" + name + "]";
	}
	public boolean turn() {
		System.out.print(toString() + ": <Enter>");
		scanner.nextLine(); //엔터키 입력받기 위해 기다림
		
		//3개의 정수를 랜덤하게 생성
		int n [] = new int [3];
		for (int i = 0; i < 3; i++) {
			n[i] = (int)(Math.random() * 3) + 1;
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print("\t" + n[i]);
		}
		
		for (int i = 0; i < 3; i++) {
			if (n[0] != n[1]) {
				return false;
			}
		}
		
		return true;
	}
}

public class GameblingGameClass {
	public int nPlayers = 0;
	private Player [] players = null;
	
	public GameblingGameClass() {
		
	}
	
	private void createPlayers() {
		private Scanner scanner = new Scanner(System.in);
		
		System.out.print("선수 수?");
		nPlayers = scanner.nextInt();
		scanner.nextLine(); //입력되어 있는 엔터키를 읽어서 버림
		players = new Player[nPlayers];
	
		for (int i = 0; i < nPlayers; i++) {
			System.out.print((i + 1) + "번째 선수 이름");
			String name = scanner.nextLine();
			players[i] = new Player(name);
		}
	}

	public void run() {
		System.out.println("게임을 시작합니다..");
		createPlayers();
		
		int index = 0;
		while (true) {
			if (players[index].turn()) {
				System.out.println(players[index].getName() + "님이 이겼습니다.");
				break;
			}
			else {
				System.out.println("아쉽군요!");
			}
			index++;
			index %= nPlayers;
		}
	}
	
	public static void main(String[] args) {
		GameblingGameClass game = new GameblingGameClass();
		game.run();

	}

}
