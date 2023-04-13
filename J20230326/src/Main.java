/*
//统计出现的小写数字
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        int count[] = new int[26];
        do {
            str = sc.nextLine();
        } while (str.charAt(0) == '#');
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (Character.isLowerCase(tmp)) {
                int sign = tmp - 97;//计算数组下标
                count[sign]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            System.out.printf("%c %d\n", c, count[i]);
        }
    }
}*/





/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
        int length = str.length();
        for(int i=0;i<length;i++) {
            if(!Character.isLetterOrDigit(str.charAt(i))) {
                System.out.print("请不要输入字母以外的数字");
                break;
            }
        }
        for(int i=0;i<length/2;i++) {
            int j=-1;
            int k=length;
            j++;
            k--;
            if(str.charAt(j)==str.charAt(k)) {
                System.out.printf("是回文");
                break;
            }
            else {
                System.out.printf("不是回文");
                break;
            }
        }

    }
}
*/

/*

//是素数和回文
import java.util.*;
public class Main {
    public static void main(String[] args) {
        for (int k = 1; k <= 10000; k++) {
            if (isPalindrome(k) && isPrime(k)) {
                System.out.printf("%d是回文且是素数\n", k);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int n) {
        String str = Integer.toString(n);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


*/


