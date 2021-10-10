import java.util.Scanner;

public class Game {
	private Player[] players;
	private int owner = 0; //owner을 0(human)으로 시작함. 1은 computer.
	
	public Game() { //게임 시작을 위한 준비
		players = new Player[2];
		Scanner scanner = new Scanner(System.in);
		System.out.println("묵찌빠 게임을 시작합니다.");
		System.out.print("선수이름 입력 >> ");
		players[0]= new Human(scanner.nextLine()); //player 레퍼런스 변수로 Human클래스 객체 업캐스팅
		System.out.print("컴퓨터이름 입력 >> ");
		players[1]= new Computer(scanner.nextLine()); //player 레퍼런스 변수로 Computer클래스 객체 업캐스팅
		System.out.println("2명의 선수를 생성 완료하였습니다.");
		System.out.println();
	}
	
	
	public void run() {
		while (true)
		{
			if (owner == 0) //owner가 human인 경우
			{
				players[0].betting(); //human 먼저 결정
				players[1].betting(); 
			}
			else //owner가 computer인 경우
			{
				players[1].betting(); //computer 먼저 결정
				players[0].betting();
			}
			printResult(); //betting의 결과를 출력하는 함수
			discriminateWinner(); //owner를 결정하고 승자를 판별하는 함수
		}		
	}
	
	private void printResult() {
		System.out.println(players[0].getName() + " : " + players[0].getBet() + ", " + players[1].getName() + " : " + players[1].getBet());
		System.out.println();
	}
	
	private void discriminateWinner() {
		if (players[0].getBet().equals(players[1].getBet())){ //human과 computer의 값이 같은 경우
			System.out.println(players[owner].getName() + "이 이겼습니다."); //owner인 선수가 승리
			System.out.println("게임을 종료합니다.");
			System.exit(0); //시스템 정상 종료
		}
		else if ((players[0].getBet().equals("묵") && players[1].getBet().equals("찌")) ||
				(players[0].getBet().equals("찌") && players[1].getBet().equals("빠")) ||
				(players[0].getBet().equals("빠") && players[1].getBet().equals("묵"))) { //human이 승리하는 경우
			owner = 0; //owner을 human으로 설정함
		}
		else if ((players[1].getBet().equals("묵") && players[0].getBet().equals("찌")) ||
				(players[1].getBet().equals("찌") && players[0].getBet().equals("빠")) ||
				(players[1].getBet().equals("빠") && players[0].getBet().equals("묵"))) { //computer가 승리하는 경우
			owner = 1; //owner을 computer로 설정함
		}
	}
}
