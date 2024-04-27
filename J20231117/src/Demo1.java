import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0) break;
			int count = 0;
			int[][] arr = new int[100500][11];

			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				int t = sc.nextInt();
				arr[t-1][x] = 1;
				count++;
			}

			for (int i = count-1; i >= 0; i--) {
				for (int j = 0; j <= 10; j++) {
					if(j == 0){
						arr [i][j] += Math.max(arr [i + 1][j], arr [i + 1][j + 1]);
					}else if(j == 10){
						arr [i][j] += Math.max(arr [i + 1][j], arr [i + 1][j - 1]);
					}else{
						arr [i][j] += treeMax(arr [i + 1][j], arr [i + 1][j + 1],arr[i + 1][j - 1]);
					}
				}
			}


			System.out.println(treeMax(arr[0][4],arr[0][5],arr[0][6])+1);
		}
	}

	public static int treeMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
}

