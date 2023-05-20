package operation;

import book.BookList;

public class ExitOperation implements Ioperation{
    @Override
    public void work(BookList booklist) {
        for (int i = 0; i < booklist.getUsedSize(); i++) {
            booklist.setBooks(i,null);
        }
        System.exit(0);
        System.out.println("退出系统成功");
    }
}