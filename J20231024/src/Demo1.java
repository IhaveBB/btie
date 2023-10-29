import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String string = sc.nextLine();
			String newString = string.replaceAll("[^[a-zA-Z]]", "");
			System.out.println(newString.toString());
		}
	}
}
