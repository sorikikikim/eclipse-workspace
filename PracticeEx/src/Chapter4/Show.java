package Chapter4;

class TV {
	private String name;
	private int year;
	private int size;
	
	protected TV(String name, int year, int size) {
		this.name = name;
		this.year = year;
		this.size = size;
	}
	
	public void show() {
		System.out.println(name + "에서 만든 " + year + "년형 " + size + "인치 TV");
	}y7
	
}

public class Show {

	public static void main(String[] args) {
		TV myTV = new TV("LG", 2017, 32);
		myTV.show();
	}

}
