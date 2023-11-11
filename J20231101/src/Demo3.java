import java.util.Scanner;

public class Demo3 {
	/**
	 * 验证尼科彻斯定理，即：任何一个正整数的立方都可以写成一串连续奇数的和。
	 *
	 * @name: Demo3
	 * @author: IhaveBB
	 * @date: 2023-11-04 16:37
	 **/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int head = getHeadNum(n);
			System.out.print(n + "*" + n + "*" + n + "=" + n * n * n + "=");
			for (int i = 0; i < n - 1; i++) {
				System.out.print(head + "+");
				head += 2;
			}
			System.out.print(head);
			System.out.println();
		}
	}

	public static int getHeadNum(int n) {
		int nSquare = n * n;
		int head = 0;
		// 如果接受的数字是偶数，给它变成奇数
		int nn = n;
		if (n % 2 == 0) {
			nn = n - 1;
		}
		// 如果这个数平方后是偶数，也变成奇数
		if (nSquare % 2 == 0) {
			nSquare = nSquare - 1;
		}
		head = nSquare - (nn / 2) * 2;
		return head;
	}
}
