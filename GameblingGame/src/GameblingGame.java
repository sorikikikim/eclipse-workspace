import java.util.Scanner;

class Person {
	private String name;
	public Person(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class Game {
	private Person[] player;
	private int playerNum;
	
	Scanner scanner = new Scanner(System.in);
	
	public void run() {
		System.out.print("갬블링 게임에 참여할 선수 숫자 >> ");
		playerNum = scanner.nextInt();
		scanner.nextLine();
		player = new Person[playerNum];
		
		for (int i = 0; i < playerNum; i++) {
			System.out.print((i + 1) + "번째 선수 이름 >> ");
			player[i] = new Person(scanner.nextLine());
		}
		System.out.println();
	}
	
	public void printResult() {
		int randomNum[] = new int[3];
		int i = 0;
		while (true) {
			i %= playerNum;
			System.out.print(player[i].getName() + " : <Enter> ");
			scanner.nextLine();
			for (int j = 0; j < 3; j++) {
				randomNum[j] = (int)(Math.random() * 3);
				System.out.print(randomNum[j] + "	");
			}
			if ((randomNum[0] == randomNum[1]) && (randomNum[1] == randomNum[2])) {
				System.out.println(player[i].getName() + "님이 이겼습니다!");
				return;
			}
			else {
				System.out.println("아쉽군요!");
			}
			i++;
		}
	}
}

public class GameblingGame {
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
		game.printResult();
	}
}
