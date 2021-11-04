import java.util.Vector;
import java.util.Scanner;

class Word {
	private String eng, kor;
	
	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	
	public String getEng() {return eng;}
	public String getKor() {return kor;}	
}

public class WordQuiz {
	private String name;
	private Vector<Word> v = new Vector<Word>();

	public WordQuiz(String name) {
		this.name = name;
		v.add(new Word("animal", "동물"));
		v.add(new Word("house", "집"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("money", "돈"));
		v.add(new Word("building", "건물"));
		v.add(new Word("score", "점수"));
	}
	
	private boolean exist(int [] n, int index) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == index)
					return true;
		}
		return false;
	}
	
	private int makeExample(int ex [], int answerIndex) {
		int n [] = new int [ex.length];
		for (int i = 0; i < n.length; i++) {
			n[i] = -1;
		}
		
		for (int i = 0; i < ex.length; i++) {
			int index;
			do {
				index = (int)(Math.random() * v.size()); //벡터 중에서 한 항목 선택
			} while (index == answerIndex || exist(n, index));
			
			n[i] = index;
 		}
		for (int i = 0; i < n.length; i++) //배열 n을 ex에 복사
			ex[i] = n[i];
		
		return (int)(Math.random() * n.length); //정답이 들어가는 보기 위치 결정하여 리턴
	}
	
	public void run() {
		System.out.println(name + "의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다." );
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			//답으로 사용할 영어 단어 선택
			int answerIndex = (int)(Math.random() * v.size()); //정답이 들어있는 벡터 항목에 대한 인덱스
			
 			//보기 4개 만들기
			int example [] = new int [4]; //벡터 항목에 대한 인덱스를 저장
			int answerLocation = makeExample(example, answerIndex); //정답이 들어갈 보기의 위치
			example[answerLocation] = answerIndex;
			
			//문제(영어) 단어 출력
			String eng = v.get(answerIndex).getEng(); //정답(문제)의 영어단어
			System.out.println(eng + "?");
			//보기 화면 출력
			for (int i = 0; i < example.length; i++) {
				System.out.print("(" + (i + 1) + ")" + v.get(example[i]).getKor() + " ");
			}
			System.out.print(": >> ");
			
			//사용자 입력, -1 입력되면 break
			int in = scanner.nextInt();
			if (in == -1)
				break;
			
			//판단
			in--; //0-3까지의 인덱스로 
			if (in == answerLocation) //정답!!
				System.out.println("Excellent!!");
			else
				System.out.println("No. !!");
			System.out.println();
		}
		System.out.println(name + "을 종료합니다.");
	}

	public static void main(String[] args) {
		WordQuiz quiz = new WordQuiz("\"명품영어\"");
		quiz.run();
	}

}
