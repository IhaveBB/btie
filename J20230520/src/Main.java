import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static User ret(){

        System.out.println("请输入你的名字");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("请选择你的身份：1.管理员 2.普通用户");
        int choice= scanner.nextInt();
        if(choice==1){
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList booklist=new BookList();
        User user=ret();
        while(true){
            int ret= user.menu();
            user.iopertions[ret].work(booklist);

        }
    }
}