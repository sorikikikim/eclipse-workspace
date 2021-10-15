package Chapter4;
import java.util.Scanner;

class Song {
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song() {
		title = "";
		artist = "";
		year = 0;
		country = "";
	}
	
	public Song(String title, String artist, int year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	public void show() {
		System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title); 
	}
}
public class SongShow {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("노래 제목을 입력하세요 >> ");
		String title = scanner.nextLine();
		System.out.print("가수이름을 입력하세요 >> ");
		String artist = scanner.nextLine();
		System.out.print("노래 발표 연도를 입력하세요 >> ");
		int year = scanner.nextInt();
		System.out.print("국적을 입력하세요 >> ");
		String country = scanner.next();
		System.out.println();
		
		Song song = new Song(title, artist, year, country);
		song.show();
		scanner.close();
	}

}
