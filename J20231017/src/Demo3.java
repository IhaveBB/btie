import java.util.Scanner;

public class Demo3 {
	public static void main(String []args) {
		int max = 0;
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean flag = true;
		while(sc.hasNext()) {
			num = sc.nextInt();
			if(flag) {
				max = num;
				flag = false;
			}
			if(num == -1) {
				break;
			}
			max = Math.max(max,num);
			
		}
		System.out.println(max);
	}
}
