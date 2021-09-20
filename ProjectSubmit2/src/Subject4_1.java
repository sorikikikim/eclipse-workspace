class Memo { //Memo 클래스 선언
	private String name; 
	private String time;
	private String content;
	
	public Memo(String name, String time, String content) { //Memo클래스의 생성자
		this.name = name;
		this.time = time;
		this.content = content;
	}
	
	public boolean isSameName(Memo m) { //객체간에 이름이 같은지 판별하는 메소드
		return (this.name == m.name); //같으면 true 반환
	}
	public void show(){ //객체의 필드 값을 출력하는 메소드
		System.out.println(name+ " " + time + " " + content);
	}
	public int length() { //content필드의 길이를 반환하는 메소드
		return (this.content.length());
	}
}

public class Subject4_1 {
	public static void main(String[] args) {
		Memo a = new Memo("황수연", "10:10", "자바 과제 있음"); //Memo클래스의 객체 a 생성 
		Memo b = new Memo("마이클", "10:15", "저녁 알바 취소됨"); //Memo클래스의 객체 b 생성 
		Memo c = new Memo("조민화", "11:30", "사랑하는 사람이 생겼어요"); //Memo클래스의 객체 c 생성 
		a.show(); //객체 a의 필드 값 출력
		if (a.isSameName(b)) //객체 a와 객체 b가 같은 이름이면
			System.out.println("동일한 사람입니다.");
		else //다른 이름이면
			System.out.println("다른 사람입니다.");
		System.out.println("a의 메모 텍스트의 길이는 " + a.length());
		}
}


