import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[] nums = new long[n];
		for(int i = 0; i < n; i++){
			nums[i] = sc.nextLong();
		}
		long sum = 0;
		for(long num : nums){
			sum += num;
		}
		if(k > sum){
			System.out.println("-1");
			return;
		}
		long result = 0;
		for(int i = 1; i < n; i++){
			if(result > sum){
				break;
			}else{
				result = (long) k * i;
			}
		}
		if(result % k == 0){
			System.out.println(result);
		}else {
			System.out.println("-1");
		}

	}

}
