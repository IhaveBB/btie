import java.util.Scanner;

public class Demo4 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String str = null;
		int count = 0;
		while(sc.hasNext()) {
		str = sc.next();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' || str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				count ++;
			}
		}
		System.out.println(count);
		count = 0;
		}
		
	}
}
