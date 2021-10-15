package Chapter4;
import java.util.Scanner;

class Dictionary {
	private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
	private static String [] eng = {"love", "baby", "money", "future", "hope"};
	public static String kor2Eng(String word) {
		int findIndex = -1;
		String findWord;
		
		for (int i = 0; i < kor.length; i++) {
			if (word.equals(kor[i])) {
				findIndex = i;
				break ;
			}
		}
		if (findIndex == -1)
			findWord = "저의 사전에 없습니다.";
		else
			findWord = eng[findIndex];
		return (findWord);
	}
}

public class DicApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String kor;
		String eng;
		Dictionary dic = new Dictionary();
		
		System.out.println("한영 단어 검색 프로그램입니다.");
		while (true) {
			System.out.print("한글 단어? ");
			kor = scanner.nextLine();
			if (kor.equals("그만"))
				return;
			eng = dic.kor2Eng(kor);
			System.out.println(kor + "는 " + eng);
		}
	}

}
