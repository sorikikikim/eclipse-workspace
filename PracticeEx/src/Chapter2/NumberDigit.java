package Chapter2;
import java.util.Scanner;

public class NumberDigit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("2자리수 정수 입력(10~99) >> ");
			int input = scanner.nextInt();
			int tenDigit = input / 10;
			int oneDigit = input % 10;
			if (tenDigit == oneDigit) {
				System.out.println("10의 자리와 1의 자리의 수가 같습니다");
				break;
			}
			else
				System.out.println("10의 자리와 1의 자리의 수가 다릅니다");
		}
	}
}
