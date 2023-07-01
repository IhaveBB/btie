import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String str = input.next();
            if(str.matches("([0-9]{17}X)|([0-9]{18})")){
                System.out.println("身份信息输入正确");
                String birthday = str.substring(6,14);
                System.out.println("出生日期为"+birthday);
                if(birthday.contains("2000")){
                    System.out.println("是千禧宝宝");
                }
                else{
                    System.out.println("不是千禧宝宝");
                }

            }
        }
    }
}