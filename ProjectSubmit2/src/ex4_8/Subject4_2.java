package ex4_8;
import java.util.InputMismatchException;
import java.util.Scanner;

class Phone { //Phone 클래스 선언
	private String name;
	private String tel;
	
	public Phone(String name, String tel) { //Phone클래스의 생성자
		this.name = name; //매개변수로 받은 name 저장
		this.tel =  tel; //매개변수로 받은 tel 저장
	}

	public String getName() { //저장된 name을 반환하는 메소드
		return (this.name);
	}
	public String getTel() { //저장된 tel을 반환하는 메소드
		return (this.tel);
	}
}

class PhoneBook { //PhoneBook 클래스 선언
	private int count;
	private Phone[] phones;
	boolean trueFlag; //저장을 했는지 표시하는 플래그
	
	public PhoneBook() { //PhoneBook클래스의 생성자
		Scanner scanner = new Scanner(System.in);
		
		while (trueFlag == false) //true가 될때까지 반복
		{
			try {
				System.out.print("인원수 >> ");
				this.count = scanner.nextInt(); //int값을 읽어서 저장한다.
				scanner.nextLine(); //버퍼를 비운다.
				trueFlag = true; //저장이 되었다고 표시
				phones = new Phone[this.count]; //phones 배열 선언
				for (int i = 0; i < this.count; i++) { //인원수만큼 반복
					System.out.print("이름과 전화번호 (이름과 번호는 빈 칸 없이 입력) >> ");
					phones[i] = new Phone(scanner.next(), scanner.next()); //배열 원소 객체 생성
					scanner.nextLine(); //버퍼를 비워준다.
				}
				System.out.println("저장되었습니다...");
			}
			catch (InputMismatchException e) { //예외처리 : 인원수에 숫자가 아닌 값이 들어오는 경우
				System.out.println("숫자만 입력해야 합니다. 다시 입력하세요.");
				scanner.nextLine(); //에러가 발생한 줄의 버퍼를 비워준다.
				trueFlag = false; //저장이 되지 않았다고 표시
			}
		}	
	}
	
	public void searchName(String name) { //PhoneBook클래스의 이름 검색 메소드
		for (int i = 0; i < this.count ;i++) {
			if (phones[i].getName().equals(name) == true) { //저장된 이름을 반환한 값이 입력받은 이름과 같은 경우
				System.out.println(phones[i].getName() + "의 번호는 " + phones[i].getTel() + " 입니다."); //저장된 이름과 전화번호 출력
				return ;
			}
		}
		System.out.println(name +" 이 없습니다.");
	}
}

public class Subject4_2 {
	public static void main(String [] args) {
		PhoneBook phoneBook = new PhoneBook(); //폰북 객체 생성
		Scanner scanner = new Scanner(System.in);
		String input; //검색할 이름의 입력 값
		
		while (true)
		{
			System.out.print("검색할 이름 >> ");
			input = scanner.next();
			if (input.equals("그만") == true) //그만이 입력되면
			{
				scanner.close();
				System.exit(0); //프로그램 정상 종료
			}
			else
				phoneBook.searchName(input); //이름 검색 메소드를 호출
		}
	}
}

