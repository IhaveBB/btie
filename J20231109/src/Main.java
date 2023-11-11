import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] scores = new int[n];
			for (int i = 0; i < n; i++) {
				scores[i] = sc.nextInt();
			}
			Arrays.sort(scores);
			int sum = 0;
			int min = -1;
			for (int i = n - 1; i >= 0 && k > 0; i--) {
				sum++;
				if (min == -1) {
					min = scores[i];
				} else if (scores[i] != min) {
					break;
				}
				k--;
			}
			System.out.println("Case #" + t + ": " + sum + " " + min);
		}
	}
}
