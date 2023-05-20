package operation;

import book.Book;
import book.BookList;
import java.util.Scanner;

public class BorrowedOperation implements Ioperation{
    @Override
    public void work(BookList booklist) {
        System.out.println("请输入您要借的书名");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        for (int i = 0; i < booklist.getUsedSize(); i++) {
            Book book = new BookList().getBooks(i);
            if (booklist.getBooks(i).getName().equals(name)) {
                if (booklist.getBooks(i).isBorrowed(true)) {
                    System.out.println("该书已经借阅");
                } else {
                    System.out.println("借阅成功");
                    booklist.getBooks(i).setBorrowed(true);
                }
                return;
            }
        }
        System.out.println("没有查找到此书籍");
    }
}
