import java.util.Scanner;

public class Demo2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int day = sc.nextInt();
			int count = 1;
			for(int i = 1; i < day; i ++) {
				count = (count + 1)*2;
			}
			System.out.println(count);
			
			
		}
	}
}


