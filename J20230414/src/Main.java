import javax.crypto.interfaces.PBEKey;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(countNine());
        //System.out.println(sum());
        /*
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            game(num);
        }*/
        //extractDigit(12375);
        //simulatedLogin();
        //project1();
        System.out.printf("%d ",getGCD(32,16));
        System.out.printf("%d",getGCD(16,32));

    }

    //求2个整数的最大公约数
    public static int getGCD(int num1, int num2) {
        int max=Math.max(num1,num2);
        int min=Math.min(num1,num2);
        int temp=0;
        while (max != 0) {
            temp = min % max;
            min = max;
            max = temp;
        }
        return min;
    }

    //获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
        public static void project1() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int n = 31;
        while (n >= 0) {
            if (n % 2 == 1) {
                System.out.print((input >> n) & 1);
            }
            n--;
        }
        System.out.println("");
        int j = 30;
        while (j >= 0) {
            if (j % 2 == 0) {
                System.out.print((input >> j) & 1);
            }
            j--;
        }
    }

    //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,
    //密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
    public static void simulatedLogin() {
        Scanner sc=new Scanner(System.in);
        int count = 0;
        String password = "imau";
        for (int i = 0; i < 3; i++) {
            String input = sc.nextLine();
            if (input.equals(password)) {
                System.out.println("输入正确");
                break;
            } else {
                count++;
                System.out.println("输入错误");
            }
            if (count == 3) {
                break;
            }
        }
    }

    //输出一个整数的每一位，如：123的每一位是3，2，1
    public static void extractDigit(int num){
        int temp=0;
        while(num!=0){
            temp=num%10;
            num=num/10;
            System.out.print(temp+" ");
        }
    }
    //完成猜数字游戏   ，用户输入数
        public static void game(int num){
        int n=(int)(Math.random()*300+1);
        if(n>num){
            System.out.printf("您输入的数字%d,对方输入的数字%d,结果：小于",num,n);
        }
        else if(n<num){
            System.out.printf("您输入的数字%d,对方输入的数字%d,结果：大于",num,n);
        }
        else{
            System.out.printf("您输入的数字%d,对方输入的数字%d,结果：等于",num,n);
        }
    }


    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static double sum(){
        double sum=0;
        int sign=-1;
        for(double i=1;i<=100;i++){
            sign=sign*-1;
            sum=sum+sign*(1/i);
        }
        return sum;
    }
    ////编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static int countNine(){
        int count=0;
        for(int i=1;i<100;i++){
            if(i%10==9){
                count++;
            }
            if(i/10==9){
                count++;
            }
        }
        return count;
    }


}


