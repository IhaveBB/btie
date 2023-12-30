import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char [] chars = str.toCharArray();
		for(int i = chars.length-1; i >= 0; i--){
			System.out.print(chars[i]);
		}
	}
}
