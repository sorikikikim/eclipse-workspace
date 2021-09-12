
public class My2DArray {

	public static void main(String[] args) {
		int n[][];
		n = new int [3][5];
		
		for (int i=0; i<n.length; i++) {
			for (int j=0; j<n[i].length; j++) {
				n[i][j] = i*j;
			}
		}
		
		for (int i=0; i<n.length; i++) {
			for (int j=0; j<n[i].length; j++) {
				System.out.print(n[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
