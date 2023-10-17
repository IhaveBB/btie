import java.util.Scanner;

public class Demo7 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int day = 0;
		int count = 0;
		while(sc.hasNext()) {
			day = sc.nextInt();
			int weekCount = day/7;
			count += weekCount*2;
			weekCount = day%7;
			if(weekCount == 6) {
				count ++;
			}
			/*
			 * if(day < 6) { System.out.println("0"); continue; } while(day > 0) { day = day
			 * - 6; count++; }
			 */
			System.out.println(count);
			count = 0;
		}
		
	}
}
