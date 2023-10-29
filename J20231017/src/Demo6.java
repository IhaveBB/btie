import java.util.Scanner;

public class Demo6 {
	public static void main(String []args) {
		//输入数据包含多组，每组数据占一行，每行包含一道题目，格式保证符合上述规定，且不包含任何空白字符。输入的所有整数均不含前导0。
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String str = sc.next();
			StringBuilder sb = new StringBuilder(str);
			int addIndex = str.indexOf('+');
			int removeIndex = str.indexOf('-');
			int dengyuIndex = str.indexOf('=');
			int a = 0;
			int b = 0;
			int c = 0;
			
			if(str.indexOf('+') != -1) {
				 a = Integer.parseInt(str.substring(0, addIndex));
				 b = Integer.parseInt(str.substring(addIndex, dengyuIndex));
				 c = Integer.parseInt(str.substring(dengyuIndex+1,str.length()));
			}else {
				 a = Integer.parseInt(str.substring(0, removeIndex));
				 b = Integer.parseInt(str.substring(removeIndex, dengyuIndex));
				 c = Integer.parseInt(str.substring(dengyuIndex+1,str.length()));
			}
			if(a + b != c) {
				System.out.println("No");
			}else {
				System.out.println("Yes");
			}
		}
		
	}
}
