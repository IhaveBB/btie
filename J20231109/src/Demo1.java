import javax.swing.*;
import java.util.*;

public class Demo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int t = sc.nextInt();
			for (int i = 1; i <= t; i++) {
				HashMap<Integer,Integer> map = new HashMap<>();
				int n = sc.nextInt();
				int k = sc.nextInt();
				int[] arr = new int[n];
				for (int j = 0; j < n; j++) {
					arr[j] = sc.nextInt();
				}
				Arrays.sort(arr);
				int minScore = arr[n-k];
				int count = 0;
				for (int j = arr.length - 1; j >= 0; j--) {
					count++;
					minScore = arr[j];
					int num =arr[j];
					map.put(num,map.getOrDefault(0,+1));
					//看看set里是不是只有一个数，并且下一个数还和set里的数相等，并且当前数量已达到预期的数量
					if(j > 1 && map.size() == 1 && count == k && map.containsKey(arr[j-1])){
						System.out.println("Case #" + ":-1 -1" );
						return;
					}
					if(j > 1 && count == k && map.containsKey(arr[j-1])){
						while (map.get(num) > 0){
							count--;
							map.put(num,map.getOrDefault(0,-1));
						}
						for (Integer key : map.keySet()){
							if(map.get(key).equals(1)){
								minScore = key;
							}
						}
					}
				}

				System.out.println("Case #" + (i) + ": " + count + " " + minScore);
				}
			}
		}
	}
