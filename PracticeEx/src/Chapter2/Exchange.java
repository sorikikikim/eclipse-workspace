package Chapter2;
import java.util.Scanner;

public class Exchange {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("원화를 입력하세요 (단위 원) >> ");
		int input = scanner.nextInt();
		double output = input / 1100;
		System.out.println(input + "원은 $" + output + "입니다.");
	}
}
