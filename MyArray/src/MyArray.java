import java.util.Scanner;

public class MyArray {
	public static void pr(int [] a) {
		/*for (int i=0; i<a.length; i++)
		{
			System.out.print(a[i] + " ");
		}*/
		
		for (int k : a) { //k에 a에서 값을 가져와서 하나씩 넣는다.
			System.out.print(k + " ");
		}
	}
	
	public static void read(int [] a) {
		Scanner scanner; //scanner는 레퍼런스 변수
		scanner = new Scanner(System.in);
		
		System.out.println("정수 " + a.length +"개를 입력하세요");
		for (int i=0; i<a.length; i++)
		{
			a[i] = scanner.nextInt();
		}
		
	}
	
	public static int big(int [] a) {
		int max = a[0];
		for(int i=0; i<a.length; i++)
		{
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int intArray []; //배열에 대한 레퍼런스 변수 //배열 선언 단계
		intArray = new int [10]; //배열 생성 단계
		//int intArray = new int [5]; 동일
		//int [] intArray = new int [5]; 동일
		
		read(intArray);
		int max = big(intArray);
		
		System.out.print("가장 큰 값은 " + max);
		//delete, free라는 연산자가 없다. 반환할 수 없다. 반환하지 않아도 된다.
		//garbage collection
		
	}

}
