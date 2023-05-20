package operation;

import book.Book;
import book.BookList;
import java.util.Scanner;

public class AddOperation implements Ioperation {
    @Override
    public void work(BookList bookList){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书籍的名称");
        String name = sc.nextLine();
        System.out.println("请输入书籍的作者");
        String author = sc.nextLine();
        System.out.println("请输入书籍的价格");
        double price = sc.nextDouble();
        System.out.println("请输入书的类型");
        String type = sc.nextLine();
        Book book = new Book(name, author, price, type);
        int size =bookList.getUsedSize();
        bookList.setBooks(size,book);
        bookList.setUsedSize(size+1);
        System.out.println("添加成功");
    }
}
