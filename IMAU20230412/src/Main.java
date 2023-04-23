import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      /*  int num=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的账户");
        int account=sc.nextInt();
        bankAccount user1= new bankAccount(account);
        System.out.println("请选择您的操作:存款请按1，取款请按2，查询利率请按3，查询余额请按4");
        do {
             num=sc.nextInt();
            switch(num) {

                case 1:
                    System.out.println("请输入您的存款金额");
                    double money1 = sc.nextDouble();
                    user1.depositInfo(money1);
                    break;
                case 2:
                    System.out.println("请输入您的取款金额");
                    double money2 = sc.nextDouble();
                    user1.withdrawalInfo(money2);
                    break;
                case 3:
                    user1.interestInfo();
                    break;
                case 4:
                    user1.balanceInfo();
                    break;
                default:
                    System.out.println("操作失败");
            }
        }while(num!=-1);*/
        Scanner sc = new Scanner(System.in);
        int value=sc.nextInt();
        MyInteger user1 = new MyInteger(value);
        System.out.println(MyInteger.isEven(100));
        System.out.println(MyInteger.isOdd(100));
        System.out.println(MyInteger.isPrimeNumber(100));
        System.out.println(user1.isEven());
        System.out.println(user1.isOdd());
        System.out.println(user1.isPrimeNumber());
    }
}