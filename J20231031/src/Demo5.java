import java.util.Scanner;

public class Demo5 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			for(int i = 2; i <= num; i++) {
				boolean flag = false;
				for(int j = 2; j < i; j++) {
					if(i%j == 0) {
						flag = true;
					}
				}
				if(!flag) {
					System.out.println(i);
				}
			}
			
		}
	}
}


