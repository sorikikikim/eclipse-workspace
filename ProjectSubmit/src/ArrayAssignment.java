import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayAssignment {
	
	public static void ReadArray(int [][] array) {
		Scanner scanner; //scanner는 레퍼런스 변수
		scanner = new Scanner(System.in);
		
		try {
			for (int row = 0; row < array.length; row++) {
				for (int column = 0; column < array[row].length; column++) {
					array[row][column] = scanner.nextInt();
				}
			}
		}
		catch (InputMismatchException e) {
			System.out.println("정수만 입력하세요.");
			scanner.nextLine();
			System.exit(1);
		}
		catch (NoSuchElementException e) {
			System.out.println("입력 개수가 부족합니다.");
			scanner.nextLine();
			System.exit(1);
		}
	}
	
	public static void  TransArray(int [][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				if (array[row][column] < 5) {
					array[row][column] = 0;
				}
				else
					array[row][column] = 1;
			}
		}
	}
	
	public static void PrintArray(int [][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int src[][];
		src = new int [4][4];
		
		System.out.println("한 줄에 4개씩 총 16개의 양수를 입력하세요.");
		ReadArray(src);
		TransArray(src);
		System.out.println("변형한 binary 배열을 출력합니다.");
		PrintArray(src);
	}

}
