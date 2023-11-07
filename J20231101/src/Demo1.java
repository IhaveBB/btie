import java.io.File;
import java.util.Scanner;

public class Demo1 {
/**
 *
 *
 * @name: Demo1
 * @author: IhaveBB
 * @date: 2023-11-02 18:10
 **/
	static int sum = 0;
	static int[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int []arr = new int [n];
			for(int i = 0; i < n; i++){
				arr[i] = sc.nextInt();
			}
			dp = arr;
			for(int i = 0; i < arr.length; i++){
				back_content(arr,i);
				dp[i] = 1;
			}
		}
	}
	private static void back_content(int[] arr,int num) {
		for (int i = 0; i < arr.length; i++) {
			if(dp[i] == 0){
				similar(arr,i,num);
				dp[i] = 1;
				back_content(arr,num);
				dp[i] = 0;
			}
		}
	}

	private static void similar(int[] arr, int i, int num) {

	}


}
