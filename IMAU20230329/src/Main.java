/*//随机字母
public class Main {
    public static void main(String[] args) {
        //取值(n,m）(m-n+1)+n
        Capital();
        number();
        Lowercase();
    }
    public static void Capital()
    {
        int num = (int) (Math.random() * 26)+65;
        int Capital = (char)num;
        System.out.printf("随机大写字母%c\n",Capital);
    }
    public static void Lowercase()
    {
        int num = (int) (Math.random() * 26)+97;
        int Lowercase = (char)num;
        System.out.printf("随机小写字母%c\n",Lowercase);
    }
    public static void number()
    {
        int num = (int) (Math.random() * 1000);
        System.out.printf("随机数字%d\n",num);
    }
}*/


/*//统计元音和辅音
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "0";
        str = sc.nextLine();
        countVowelsAndConsonants(str);
    }

    public static void countVowelsAndConsonants(String str){
        int n=0;
        int vomels=0;
        int consonants=0;
        str.replace(" ","");
        for(int i=0;i<str.length();i++){
            n = str.toLowerCase().charAt(i);
                if (n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u') {
                    vomels++;
                } else if(n>=97&&n<=122){
                    consonants++;
                }
        }
        System.out.printf("%d %d",vomels,consonants);
    }
}




//判断元音辅音
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "0";
        str = sc.nextLine();
        isVowelsConsonants(str);
    }

    public static void isVowelsConsonants(String str) {
        int n = str.toLowerCase().charAt(0);
        if (n >= 65 || n <= 122) {
            if (n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u') {
                System.out.println("元音");
            } else if (n <= 65 || n >= 122) {
                System.out.println("输入错误");
            } else {
                System.out.println("辅音");
            }
        }
    }
}*/


/*//输出一个数的逆序数
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        for(int i=str.length()-1;i>=0;i--) {
            System.out.printf("%c",str.charAt(i));
        }
    }
}*/



/*
//输入字符串序列，判断是否包含IMAU，并统计单词的个数
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        judgeContainIMAU(str);
        System.out.println();
        System.out.print(judgeNumberOfWords(str));
    }
    public static void judgeContainIMAU(String str){
        boolean sign = str.contains("IMAU");
        if(sign) {
            System.out.printf("YES");
        }
    }
    public static int judgeNumberOfWords(String str){
        int num=0;
        for(int i=0;i<str.length()-1;i++) {
            if(str.charAt(i)==' ') {
                num++;
            }
        }
        return num+1;
    }
}
*/

