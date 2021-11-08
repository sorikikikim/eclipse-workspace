import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.io.FileReader;

public class WordSearch {
	private Vector<String> v = new Vector<String>(30000);
	public WordSearch() {
		
	}
	private void readFile() {
		try {
			Scanner fscanner = new Scanner(new FileReader("words.txt"));
			while (fscanner.hasNext()) { //다음에 읽을것이 남아있으면
 				String word = fscanner.nextLine();
 				v.add(word.trim());
			}
			fscanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void readFile2() {
		try { //file open 하는 이유 : 파일이 있는지 확인, 읽을 수 있는지 확인
			FileReader fin = new FileReader("words.txt");//문자 단위로 읽음
			int c;
			
			StringBuffer sb = new StringBuffer();
			while ((c = fin.read()) != -1) { //파일 끝까지 읽기, 파일의 끝을 만날때까지
				if (c == '\n') {
					v.add(sb.toString().trim()); //trim은 뒤에 붙은 빈칸을 제거
					sb.setLength(0); //sb에 들어있는 문자열 모두 지우기
				}
				sb.append((char)c);
			}
			if (sb.length() != 0)
				v.add(sb.toString().trim());
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	private void processQuery() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("단어 >> ");	
			String searchWord = scanner.nextLine();
			if (searchWord.equals("그만"))
				break;
			int n = v.size();
			for (int i = 0; i < n; i++) {
				String word = v.get(i);
				if (word.length() < searchWord.length())
					continue;
				String w = word.substring(0, searchWord.length());
				if (w.equals(searchWord))
					System.out.println(word);
			}
		}
	}
	
	public void run() {
		readFile();
		System.out.println("파일 읽기 완료. 단어 개수는 " + v.size());
		processQuery();
	}
	
	public static void main(String[] args) {
		WordSearch w = new WordSearch();
		w.run();
	}

}
