package operation;

import book.BookList;

import java.util.Scanner;

public class DelOperation implements Ioperation{
    @Override
    public void work(BookList booklist){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的书名：");
        String name = sc.nextLine();
        int k=-1;
        for(int i=0;i<booklist.getUsedSize();i++){
            if(booklist.getBooks(i).getName().equals(name)){
                k=i;
                break;
            }
        }
        if(k==-1){
            System.out.println("未查找到您要删除的书籍");
            return;
        }
        for (int i = k; i < booklist.getUsedSize()-1; i++) {
            booklist.setBooks(i,booklist.getBooks(i+1));
        }
        booklist.setUsedSize(booklist.getUsedSize()-1);
        System.out.println("删除成功！！");

    }
}
