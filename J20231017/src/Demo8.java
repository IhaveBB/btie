import java.util.Scanner;

public class Demo8 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
		int max = sc.nextInt();
		for(int i = 0; i < max; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int count = 0;
			int likePeople = 0;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					int tmp = sc.nextInt();
					if(tmp == 1) {
						count ++;
					}
				}
				if(count >= (float)m/2.0) {
					likePeople ++;
					count = 0;
				}
				
			}
			System.out.println(likePeople);
			
		}
		
	}
	}
	
}
