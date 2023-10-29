import java.util.Scanner;

public class Demo7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			String strArr[] = new String[n];
			for(int i = 0; i < n; i++){
				strArr[i] = sc.next();
			}
			boolean flag = true;
			for(int i = 0; i < n-1; i++){
				if(strArr[i].charAt(strArr[i].length()-1) == strArr[i+1].charAt(0)){
					continue;
				}else{
					flag = false;
				}
			}
			System.out.println(flag?"YES":"NO");
		}
	}
}
