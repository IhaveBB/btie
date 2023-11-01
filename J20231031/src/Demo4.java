import java.util.Scanner;

public class Demo4 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			int ge = num%10;
			int shi = num/10%10;
			int bai = num/100%10;
			System.out.println(Math.pow(ge, 3)+Math.pow(shi, 3)+Math.pow(bai, 3) == num?"1":"0");
			
		}
	}
}


