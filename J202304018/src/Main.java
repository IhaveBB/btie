import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println(max(11,8,2));
        //System.out.println(factorial(10));
        //System.out.println(sumFactorial(10));
        //fibonacci(10);
        /*Sum s1 = new Sum();
        System.out.println(s1.sum(5,6));
        System.out.println(s1.sum(5.1,5.5,5.6));*/
        /*Max n1=new Max();
        System.out.println(n1.max(5,9));
        System.out.println(n1.max(5.5,5.6,5.9));*/
        //System.out.println(recursionFactorial(5));
        //hannot(5, "A", "B", "C");

    }
    //汉诺塔
    public static void  hannot(int n, String A, String B, String C) {
        if (n == 1) {
            System.out.println("移动盘1"+"从"+A +"到"+C);
        } else {
            hannot(n-1, A, C, B);
            System.out.println("移动盘"+n+"从"+A +"到"+C);
            hannot(n-1, B, A, C);
        }
    }


    //递归法求阶乘
    public static int recursionFactorial(int n){
        if(n<1){
            return 1;
        }
        return recursionFactorial(n-1)*n;
    }
    //求斐波那契数列的第n项。
    public static void fibonacci(int n){
        int []arr=new int[n];
        arr[0]=1;
        arr[1]=1;
        for (int i=2;i<n;i++) {
            arr[i]=arr[i-2]+arr[i-1];
        }
        System.out.println(Arrays.toString(arr));
    }

    //求1！+2！+3！+4！+........+n!的和
    public static int sumFactorial(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=factorial(n);
        }
        return sum;
    }
    //求 N 的阶乘  。
    public static int factorial(int n){
        int sum = 1;
        for(int i=1;i<=n;i++){
            sum=sum*i;
        }
        return sum;
    }

    //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
    //要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static int max(int num1,int num2){
        return num1>num2?num1:num2;
    }
    public static int max(int num1,int num2,int num3){
        return max(num1,num2)>num3?max(num1,num2):num3;
    }
}

//在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
class Max{
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static double max(double a,double b,double c){
        double temp=a>b?a:b;
        return temp>c?temp:c;
    }
}

//在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
class Sum {
    public static int sum(int a, int b) {
        return a + b;
    }
    public static double sum(double a, double b, double c) {
        return a + b + c;
    }
}