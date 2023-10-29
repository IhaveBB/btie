import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sb1 = in.nextLine();
        String sb2 = in.nextLine();
        StringBuilder sb3 = new StringBuilder(sb1);
        int k = 0;
        for(int i = 0; i < sb3.length(); i++) {
            if(sb3.charAt(i) == sb2.charAt(k)) {

            }
        }



    }
}
}