import java.util.Scanner;

public class Demo5 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int breathe = 0;
		int publse = 0;
		int count = 0;
		while(sc.hasNext()) {
		num = sc.nextInt();
		String []str = new String[100];
		for(int i = 0; i < num; i++) {
			boolean flag = true;
			String name = sc.next();
			breathe = sc.nextInt();
			publse = sc.nextInt();
			if(breathe >=15 && breathe <= 20 && publse >= 50 && publse <= 70) {
				flag = false;
			}
			if(flag) {
				str[count] = name;
				count++;
			}
		}
		for(int i = 0;i < count; i++) {
			System.out.println(str[i]);
		}
	}
	}
}
