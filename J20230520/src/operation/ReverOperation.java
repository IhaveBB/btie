package operation;
import book.Book;
import book.BookList;
import operation.Ioperation;

import java.util.Scanner;

public class ReverOperation implements Ioperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("请输入你要借的书的书名");
        Scanner scanner=new Scanner(System.in);
        String name= scanner.nextLine();
        for (int i = 0; i < booklist.getUsedSize(); i++) {
            Book book = new BookList().getBooks(i);
            if (booklist.getBooks(i).getName().equals(name)) {
                booklist.getBooks(i).setBorrowed(false);
                System.out.println("归还成功！！");
                return;
            }
        }
    }
}