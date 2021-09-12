import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class UpAndDown {

	public static void main(String[] args) {
		System.out.println("안녕, 게임을 시작합니다.");
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			//수 결정
			int low = 0;//결정한 수보다 낮은 범위
			int high = 99;//결정한 수보다 높은 범위
			int input;//사용자가 입력한 정수 값
			int card;//정답. 숨겨진 값
			
			card = r.nextInt(100); //0-99까지의 임의의 정수 리턴
			
			System.out.println("수를 결정하였습니다. 맞추어보세요.");
			int n = 1;
			while (true) {
				System.out.println(low + "-" + high);
				
				System.out.print(n + ">>");
				try {
					input = scanner.nextInt();//사용자로 부터 입력
				}
				catch(InputMismatchException e) {
					System.out.println("수를 입력하세요.");
					scanner.nextLine();
					continue;
				}
				//사용자가 입력한 수가 low와 high 있는지 확인 처리
				if (input < low || input > high) {
					System.out.println("범위 내에서 입력하세요.");
				}
				else if (input < card) {
					System.out.println("더 높게");
					low = input;
				}//사용자가 입력한 수가 정답보다 작은 경우
				else if (input > card) {
					System.out.println("더 낮게");
					high = input;
				}//사용자가 입력한 수가 정답보다 큰 경우
				else {
					System.out.println("맞았습니다.");
					break;
				}//정답을 맞춘 상황
				n++;
			}	
			//반복할 것인지 입력받아 확인
			System.out.print("그만두려면 n 입력 >>");
			String s = scanner.next(); //문자열 입력
			if (s.equals("n"))
				break; //n이 입력되면 break, 프로그램 종료
		}
	}
}
