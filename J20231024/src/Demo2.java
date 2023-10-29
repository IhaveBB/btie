import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String string = sc.next();
			StringBuilder newString = new StringBuilder(string);
			System.out.println(newString.reverse().toString().equals(string)?"Y":"N");
		}
	}
}
