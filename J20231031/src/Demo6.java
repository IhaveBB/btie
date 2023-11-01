import java.util.Scanner;

public class Demo6 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int tmp = num1*num2;
			int res = 0;
			
			while(num1%num2 != 0) {
			res = num1%num2;
			num1 = num2;
			num2 = res;
			}
			int gcm = num2;
			
			System.out.println(tmp/gcm);
			
		
		}
	}
}


