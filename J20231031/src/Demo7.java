/*
import java.util.Scanner;

public class Demo7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong(); // Read as long
			}
			long count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (myContains(arr[i], arr[j])) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static boolean myContains(long num, long x) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (num > 0) {
			sb1.append(num % 10);
			num /= 10;
		}
		while (x > 0) {
			sb2.append(x % 10);
			x /= 10;
		}

		// Compare two strings
		for (int i = 0; i < sb2.length(); i++) {
			if (sb1.indexOf(String.valueOf(sb2.charAt(i))) != -1) {
				return true;
			}
		}
		return false;
	}
}
*/

import java.util.HashMap;
/*
import java.util.HashSet;
import java.util.Scanner;

public class Demo7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			System.out.println(myContains(arr));
		}
	}

	public static int myContains(long[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			HashSet<Integer> hashSet = new HashSet<>();
			long num = arr[i];
			while (num > 0) {
				hashSet.add((int) (num % 10));
				num /= 10;
			}
			//对比
			for(int j = i + 1; j < arr.length; j++){
				num = arr[j];
				boolean flag = false;
				while (num > 0) {
					int digit = ((int) (num % 10));
					if(hashSet.contains(digit)){
						flag = true;
						break;
					}
					num /= 10;
				}
				if(flag){
					count++;
				}
			}
		}
		return count;
	}
}
*/


import java.util.Scanner;
class Demo7 {
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis(); //获取开始时间
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int t = scanner.nextInt();
			long[] a = new long[1024];
			for (int i = 0; i < t; i++) {
				long s = scanner.nextLong();
				int n = 0;
				while (s != 0) {
					n |= (1 << (s % 10));
					s = s / 10;
				}
				a[n]++;
			}
			long s = 0;
			for (int i = 0; i < 1024; i++) {
				for (int j = i; j < 1024; j++) {
					if (i == j) {
						s += a[i] * (a[i] - 1) / 2;
					} else if ((i & j) != 0) {
						s += a[i] * a[j];
					}
				}
			}
			System.out.println(s);
			long endTime=System.currentTimeMillis(); //获取结束时间
			System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		}
	}
}
