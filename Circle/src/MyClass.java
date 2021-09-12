
class Circle {
	private int radius; //멤버변수
	private String name;
	
	public Circle() {
		System.out.println("생성자");
	}
	public Circle(int radius, String name) { //매개변수
		this.radius = radius; //this: 멤버변수 //매개변수
		this.name = name;
		System.out.println("생성자2");
	}
	public double getArea() {
		return 3.14*this.radius*this.radius;
	}
}

public class MyClass {
	public static void main(String [] args) {
		Circle pizza; //Circle 객체를 가리킬 레퍼런스 변수
		pizza = new Circle(10, "자바피자"); //Circle() 이름의 함수 실행. 생성자 실
		double area = pizza.getArea();
		System.out.println("피자의 면적은 " + area);
		
		Circle donut; //레퍼런스 변수
		donut = new Circle();
		donut = new Circle(2, "자바도넛");
		area = donut.getArea();
		System.out.println("도넛의 면적은 " + area);
	}
}

