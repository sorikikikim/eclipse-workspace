
class Point { //사실은 Object를 상속받고 있음
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
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
		//System.out.println(p); //p -> p.toString();
		print(new String("hello"));
	}

}
