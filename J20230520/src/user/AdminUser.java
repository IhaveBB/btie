package user;
import book.ShowOperation;
import operation.*;
import user.User;
import java.util.Scanner;

public class AdminUser extends User {

    @Override
    public int menu() {
        System.out.println("************************");
        System.out.println("hello "+name+" 欢迎来到管理员界面");
        System.out.println("0.退出系统");
        System.out.println("1.添加书籍");
        System.out.println("2.删除书籍");
        System.out.println("3.查找书籍");
        System.out.println("4.显示所有书籍");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

    public AdminUser(String name) {
        super(name);
        this.iopertions = new Ioperation[]{
                new ExitOperation(),
                new AddOperation(),
                new DelOperation(),
                new FindOperation(),
                new ShowOperation()
        };

    }
}
