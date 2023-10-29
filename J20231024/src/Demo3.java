import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String string = sc.next();
			StringBuilder sb = new StringBuilder(string);

			StringBuilder newString = new StringBuilder();
			newString.append(string);
			newString.append(sb.reverse());
			System.out.println(newString.toString());
		}
	}
}
