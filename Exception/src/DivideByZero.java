import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividend;
		int divisor;
		
		while (true) {
			try {
				System.out.print("나뉨수를 입력 >>");
				dividend = scanner.nextInt();
				System.out.print("나눗수를 입력 >>");
				divisor = scanner.nextInt();
				System.out.println("나누면 " + dividend/divisor);
				break;
				}
			catch (ArithmeticException e) {
				System.out.println("0으로 나누면 안됩니다. 다시 입력하세요.");
				}
			catch (InputMismatchException e) {
				System.out.println("정수만 입력하세요. 다시 입력하세요.");
				scanner.nextLine(); //현재 scanner의 버퍼에 있는 키입력들을 읽어서 버려버린다.
			}
			}
		}

}
