package Chapter5;
import java.util.Scanner;

class Km2Mile extends Converter {
	public Km2Mile(double ratio) {
		this.ratio = ratio;
	}
	protected double convert(double src) {
		return src / ratio;
	}
	
	protected String getSrcString() {
		return "km";
	}
	
	protected String getDestString() {
		return "mile";
	}
}

public class KmMile {

	public static void main(String[] args) {
		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();
	}

}
