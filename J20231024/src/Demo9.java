import java.util.Scanner;

public class Demo9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String isbn = scanner.nextLine();
			StringBuilder sb = new StringBuilder(isbn);
			isbn = isbn.replace("-", "");

			int sum = 0;
			for (int i = 0; i < 9; i++) {
				sum += Integer.parseInt(String.valueOf(isbn.charAt(i))) * (i + 1);
				//sum += isbn.charAt(i) * (i + 1); 这样是按ASCALL码相乘
			}

			int key = sum % 11;
			String string;
			if(key == 10){
				string = "X";
			}else{
				string = Integer.toString(key);
			}

			if(string.charAt(0) == isbn.charAt(9)) {
				System.out.println("Right");
			} else{
				System.out.println(sb.replace(sb.length()-1, sb.length(), string));
			}
		}
	}
}
