import java.util.Scanner;

public class Demo10 {
/**
 * 单词接龙
 *
 * @name: Demo10
 * @author: IhaveBB
 * @date: 2023-10-25 22:38
 **/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			String[] words = new String[n];
			for(int i = 0; i < n; i++){
				words[i] = sc.next();
			}
			boolean flag = true;
			for (int i = 1; i < n; i++) {
				if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
					System.out.println("No");
					flag = false;
				}
			}
			if(flag){
				System.out.println("Yes");
			}
		}
	}
}
