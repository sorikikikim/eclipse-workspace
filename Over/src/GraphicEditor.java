abstract class Shape{ //추상 클래스 //객체를 생성할 수 없다 //설계와 구현(상속에서) 분리
	Shape next;
	
public Shape() {
		next = null;
	}
	
	/*public void draw() { //Overriding 해서 사용하지 않게 됨 -> 추상 메소드 선언
		System.out.println("***Shape***");
	}*/

	abstract public void draw(); //추상 메소드 선언
	//선언되어 있으나 구현되어 있지 않은 메소드
}

class Line extends Shape{
	public void draw() { //추상 메소드를 반드시 Overriding 해야 한다.
		//super.draw(); 오버라이딩한 함수의 이름을 주기 위해
		System.out.println("Line");
	}
	public void show() {
		System.out.print("~~~");
	}
}

class Circle extends Shape{
	public void draw() { //Overriding
		System.out.println("Circle");
	}
}

class Rect extends Shape{
	public void draw() { //Overriding
		System.out.println("Rectangle");
	}
}

public class GraphicEditor {
	
	public static void print(Shape p) { //p는 Shape 객체이거나 Shape을 상속받은 객체에 대한 레퍼런스
		if (p instanceof Line) {
			Line l = (Line)p; //Down casting
			l.show();
			//System.out.println("Line 객체가 넘어왔다");
		}
		p.draw();
	}
	
	public static void paint(Shape p) {
		while (p != null) {
			p.draw(); //동적바인딩
			p = p.next;
		}
	}

	public static void main(String[] args) {
		//Overriding : 동적바인딩을 통해 실행시간 다형성 실현
		//Overloading : 컴파일타임 다형성 실현
		
		/*
		 * Line line = new Line();
		 * 
		 * Shape shape = line; //Up casting
		
		line.draw(); //draw() of Line class 
		//shape.draw(); //draw() of Shape class -> 동적바인딩에 의해 Line의 draw()호출
		
		print(shape);
		print(new Circle());
		print(new Rect());
		 */
		
		Shape start, last, obj;
		
		start = new Line(); //Up casting
		last = start;
		
		obj = new Rect();
		last.next = obj;
		last = obj;
		
		obj = new Line();
		last.next = obj;
		last = obj;
		
		obj = new Circle();
		last.next = obj;
		last = obj;
		
		paint(start);
		
	}
}
