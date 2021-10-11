
class Point { //사실은 Object를 상속받고 있음
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public boolean equals(Object obj) {
		Point p = (Point)obj; //다운캐스팅
		if (x == p.x && y == p.y) 
			return true;
		return false;
	}
}
public class ObjectEx { //사실은 Object를 상속받고 있음
	
	public static void print(Object obj) { //업캐스팅해서 전달받는다.
		Class c = obj.getClass();//obj가 가리키고 있는 객체의 class에 대해 모든 정보를 가지고 있는 메소드 
		String name = c.getName();
		System.out.println(name); 
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
		
	}
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);
		System.out.println(p); //p -> p.toString();
		print(new String("hello"));
		
		System.out.println();
		System.out.println();
		Point a = new Point(2, 3);
		Point b = new Point(2, 3);
		Point c = a;
		
		if (a == b)
			System.out.println("a == b");
	
		if (a == c) 
			System.out.println("a == c");
		
		if (a.equals(b))
			System.out.println("a equals b");
		
		System.out.println();
		System.out.println();
	
		int n = 10;
		Integer ten = Integer.valueOf(n); //int n을 박싱
		int x = ten.intValue(); //언박싱
		System.out.println(x);
		
		Integer intObject = n; //auto boxing
		System.out.println("intObject = " + intObject);
		int m  = intObject + 10; //auto unboxing;
		System.out.println("m = " + m);
		

	}

}
