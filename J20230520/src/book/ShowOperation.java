package book;

import book.BookList;
import operation.Ioperation;

public class ShowOperation implements Ioperation {
    @Override
    public void work(BookList booklist) {
        for (int i = 0; i < booklist.getUsedSize(); i++) {
            System.out.println(booklist.getBooks(i));
        }
    }
}