package book;

public class BookList {
    public int usedSize;
    private Book[] Books=new Book[10];
    //通过构造函数存入几本基础书籍
    public BookList() {
        this.Books[0] = new Book("三国演义", "罗贯中", 66, "小说");
        this.Books[1] = new Book("西游记", "吴承恩", 67, "小说");
        this.Books[2] = new Book("红楼梦", "曹雪芹", 68, "小说");
        this.Books[3] = new Book("活着", "余华", 69, "小说");
        this.usedSize = 4;
    }
    public Book getBooks(int pos) {
        return Books[pos];
    }
    public void setBooks(int pos, Book book) {
        Books[pos] = book;
    }
    public int getUsedSize() {
        return usedSize;
    }
    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }



}