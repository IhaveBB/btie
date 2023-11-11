import java.util.Scanner;

public class Demo4 {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,m;
		while(sc.hasNext()) {
			m=sc.nextInt();
			int a=m*m*m;
			int s=m*m-m+1;
			System.out.printf("%d*%d*%d=%d=",m,m,m,a);
			for(i=0;i<m;i++) {
				System.out.printf("%d",s);
				s+=2;
				if (i < m - 1) {
					System.out.printf("+");
				}
			}
			System.out.println();
		}
	}

}