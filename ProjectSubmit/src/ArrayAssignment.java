import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayAssignment {
	
	public static void readArray(int [][] array) { //배열을 입력받아 예외처리를 하는 함수
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		try {
			for (int row = 0; row < array.length; row++) { //배열의 행을 array.lenght만큼
				for (int column = 0; column < array[row].length; column++) { //배열의 열을 array의 각 행.length만큼
					array[row][column] = scanner.nextInt(); //정수로 입력 받는다.
				}
			}
		}
		catch (InputMismatchException e) { //예외처리 1.정수가 아닌 수를 입력받는 경우
			System.out.println("정수만 입력하세요.");
			System.exit(1); //프로세스 종료
		}
		catch (NoSuchElementException e) { //예외처리 2.배열의 원소의 개수가 16개보다 적은 경우
			System.out.println("입력 개수가 부족합니다.");
			System.exit(1); //프로세스 종료
		}
		scanner.close();
	}
	
	public static void  transformArray(int [][] array) { //입력받은 배열을 이진 배열로 변형하는 함수
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				if (array[row][column] < 5) //배열의 원소가 5보다 작은 경우
					array[row][column] = 0; //0으로 치환
				else //배열의 원소가 5보다 같거나 큰 경우
					array[row][column] = 1; //1로 치환
			}
		}
	}
	
	public static void printArray(int [][] array) { //배열을 출력하는 함수
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column] + " "); //배열의 각 원소 출력
			}
			System.out.println(); //한 행마다 개행을 해준다.
		}
	}

	public static void main(String[] args) {
		int src[][];
		src = new int [4][4];
		
		System.out.println("한 줄에 4개씩 총 16개의 양수를 입력하세요.");
		readArray(src);
		transformArray(src);
		System.out.println("변형한 binary 배열을 출력합니다.");
		printArray(src);
	}
}



