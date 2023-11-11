import java.util.Scanner;

public class Demo3 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int x = sc.nextInt();
				
				System.out.println(Fun(x));
			}
		}
	}
	
	public static int Fun(int x) {
		if(x == 1) {
			return 2;
		}
		return Fun(x-1) + x;
	}
	
}


