import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 读取测试实例的数量
        
        for (int t = 0; t < M; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if (areAmicableNumbers(A, B)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int sumOfDivisors(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    public static boolean areAmicableNumbers(int A, int B) {
        int sumA = sumOfDivisors(A);
        int sumB = sumOfDivisors(B);
        return sumA == B && sumB == A;
    }
}
