import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신여부 입력");
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.next(); //키를 읽어 문자열 변환해줘.
		String city = scanner.next();
		int age = scanner.nextInt();
		double weight = scanner.nextDouble();
		boolean isSingle = scanner.nextBoolean();
		
		System.out.print("이름은 " + name + ", ");
		System.out.print("도시는 " + city + ", ");
		System.out.print("나이는 " + age + ", ");
		System.out.print("체중은 " + weight + ", ");
		System.out.println("독신여부는 " + isSingle + " 입니다.");
	}

}
