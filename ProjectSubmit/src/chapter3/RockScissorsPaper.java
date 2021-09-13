package chapter3;
import java.util.Scanner;

public class RockScissorsPaper {
	public static void doGame(String[] rockScissorsPaper) {
		Scanner scanner = new Scanner(System.in); //입력을 받아 변환하여 반환시켜주는 scanner를 선언하고 할당한다.
		
		while (true) { //반복문 실행.
			int computerInput = (int)(Math.random()*3); //컴퓨터의 입력(내는 값)은 랜덤으로 선택한다.
			System.out.print("가위 바위 보! >> ");
			String userInput = scanner.next(); //사용자의 입력(내는 값)은 scanner로 키를 읽어 문자열로 반환한다.
			
			if (userInput.equals("그만")) { //사용자가 그만이라고 입력하면 게임을 끝낸다. 가나a
				System.out.println("게임을 종료합니다...");
				break; //while문을 빠져나간다.
			}
			else if (userInput.equals("가위")) { //사용자가 가위를 내는 경우
				System.out.print("사용자 = " + userInput + ", 컴퓨터 = " + rockScissorsPaper[computerInput] + ", ");
				if (rockScissorsPaper[computerInput].equals("가위")) //컴퓨터가 가위를 내는 경우
					System.out.println("비겼습니다.");
				else if (rockScissorsPaper[computerInput].equals("바위")) //컴퓨터가 바위를 내는 경우
					System.out.println("컴퓨터가 이겼습니다.");
				else if (rockScissorsPaper[computerInput].equals("보")) //컴퓨터가 보를 내는 경우
					System.out.println("사용자가 이겼습니다.");
			}
			else if (userInput.equals("바위")) { //사용자가 바위를 내는 경우
				System.out.print("사용자 = " + userInput + ", 컴퓨터 = " + rockScissorsPaper[computerInput] + ", ");
				if (rockScissorsPaper[computerInput].equals("가위")) //컴퓨터가 가위를 내는 경우
					System.out.println("사용자가 이겼습니다.");
				else if (rockScissorsPaper[computerInput].equals("바위"))//컴퓨터가 바위를 내는 경우
					System.out.println("비겼습니다.");
				else if (rockScissorsPaper[computerInput].equals("보")) //컴퓨터가 보를 내는 경우
					System.out.println("컴퓨터가 이겼습니다.");
			}
			else if (userInput.equals("보")) {
				System.out.print("사용자 = " + userInput + ", 컴퓨터 = " + rockScissorsPaper[computerInput] + ", ");
				if (rockScissorsPaper[computerInput].equals("가위")) //컴퓨터가 가위를 내는 경우
					System.out.println("컴퓨터가 이겼습니다.");
				else if (rockScissorsPaper[computerInput].equals("바위")) //컴퓨터가 바위를 내는 경우
					System.out.println("사용자가 이겼습니다.");
				else if (rockScissorsPaper[computerInput].equals("보")) //컴퓨터가 보를 내는 경우
					System.out.println("비겼습니다.");
			}
			else //가위, 바위, 보, 그만 외의 입력이 들어오는 경우
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		String str[] = {"가위", "바위", "보"};
		doGame(str);
	}
}

