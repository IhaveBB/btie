import java.util.Scanner;

public class Demo12 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int FirScore = 0;
		int SecScore = 0;
		while(sc.hasNext()) {
			String str = sc.next();
			if(str.equals("���ӽ���")) {
				FirScore++;
			}else if(str.equals("�Ͷӽ���")){
				SecScore++;
			}
		}
		System.out.println(FirScore);
		System.out.println(SecScore);
	}
}
