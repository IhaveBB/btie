package user;

import operation.*;
import user.User;

import java.util.Scanner;

public class NormalUser extends User {


    public NormalUser(String name) {
        super(name);
        this.iopertions=new Ioperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowedOperation(),
                new ReverOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("************************");
        System.out.println("hello"+name+"欢迎来到普通用户界面");
        System.out.println("0.退出系统");
        System.out.println("1.查找书籍");
        System.out.println("2.借用书籍");
        System.out.println("3.归还书籍");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }
}