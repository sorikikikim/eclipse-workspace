
import java.util.Scanner;

abstract public class Player {
	protected Scanner scanner = new Scanner(System.in);
	protected String bet[] = {"묵", "찌", "빠"};
	protected String name; // 선수 이름
	protected String lastBet = null; // 선수가 최종적으로 낸 값
	protected Player(String name) {
        this.name = name;
    }
	public String getName(){ //선수의 이름을 리턴하는 함수
        return name;
	}
	public String getBet() { //선수가 최종적으로 낸 값을 리턴하는 함수
		return lastBet;
	}
	abstract public String betting(); //선수가 묵,찌,빠 중에서 낼 것을 결정하는 함수
}

class Human extends Player {
	public Human(String name) {
		super(name); //슈퍼클래스의 name을 매개변수로 하는 생성자 호출
	}
	
	public String betting() {
		while (true) {
			System.out.print(name + " >> ");
			String input = scanner.next(); //사람 선수가 낼 값을 입력받음
			for (int i = 0; i < bet.length; i++) { //입력받은 값이 묵,찌,빠 중에 있으면 lastBet으로 설정하고 반환하는 반복문 
				if (input.equals(bet[i])){
					lastBet = input;
					return lastBet;
				}
			}
			System.out.println("묵, 찌, 빠 중에서 입력하세요"); //묵,찌,빠 외의 값을 입력하는 경우
		}
	}
}

class Computer extends Player {
	public Computer(String name) {
		super(name); //슈퍼클래스의 name을 매개변수로 하는 생성자 호출
	}
	
	public String betting() {
		int randomNum = (int)(Math.random() * 3); //난수 생성 (범위 : 0 ~ 2)
		lastBet = bet[randomNum]; //결정한 값을 lastbet으로 설정함
		System.out.println(name + " >> 결정하였습니다.");
		return lastBet;
	}
	
}
