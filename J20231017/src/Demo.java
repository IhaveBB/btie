import java.util.Scanner;

public class Demo {
	public static void main(String [] args) {
		int max = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
		max = sc.nextInt();
		if(max == 1 ) {
			System.out.println("1");
			continue;
		}else if(max == 2) {
			System.out.println("1");
			System.out.println("1");
			continue;
		}
		int cur = 1;
		int pre = 1;
		int arr[] = new int[max];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i < max; i++) {
			arr[i] = cur + pre;
			cur = arr[i];
			pre = arr[i-1];
		}
		for(int i = 0 ; i < arr.length;i ++) {
			System.out.println(arr[i]);
		}
	}
	}

}
