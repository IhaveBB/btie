import java.util.Scanner;

public class Demo2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = 0;	
		while(sc.hasNext()) {
				n = sc.nextInt();
				for(int i = 1; i <= n; i++) {
					System.out.print(F(i)+" ");
				}
			}
		
	}
	
	public static int F(int N) {
		if(N == 1 || N == 2) {
			return 1;
		}
		return F(N-1) + F(N -2);
	}
}
