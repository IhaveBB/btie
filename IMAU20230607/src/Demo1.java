import java.util.Scanner;

public class Demo1 {
//[@$!%*#?&.]
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&.])";
        String regex = "[A-Z]{1}[0-9a-zA-Z@$!%*#?&.]{7,}";
            String password = input.next();
            if(password.matches(regex)){
                System.out.println("请重新确认您的密码");
                String password2 = input.next();
                if(password2.equals(password)){
                    System.out.println("成功");
                }
                else{
                    System.out.println("确认密码不一致");
                }
            }
            else {
                System.out.println("请重新输入密码");
            }


    }
}
