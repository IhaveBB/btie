import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //向上取整
            int likeThreshold = (int) Math.ceil((float) m / 2);
            int likePeople = 0;

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    int tmp = sc.nextInt();
                    if (tmp == 1) {
                        count++;
                    }
                }

                if (count >= likeThreshold) {
                    likePeople++;
                }
            }

            System.out.println(likePeople);
        }
    }
}
