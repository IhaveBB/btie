package operation;

import book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

public class FindOperation implements Ioperation {
    @Override
    public void work(BookList booklist) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要查找的书籍名称：");
        String name= scanner.nextLine();
        for (int i = 0; i < booklist.getUsedSize(); i++) {
            if (booklist.getBooks(i).getName().equals(name)){
                System.out.println(booklist.getBooks(i));
                return;
            }
        }
        System.out.println("未找到相关书籍");
    }
}