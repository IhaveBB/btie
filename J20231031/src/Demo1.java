import java.util.Scanner;

public class Demo1 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int m = 3;
				for(int j = 0; j < x; j++) {
					m = (m-1)*2;
				}
				System.out.println(m);
			}
		}
	}
	
}


