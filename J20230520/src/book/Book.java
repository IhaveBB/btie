package book;

public class Book {
    private String name;
    private String author;
    private double price;
    private boolean isBorrowed;//默认是false
    private String type;

    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBorrowed(boolean b) {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ((isBorrowed==true)?"已被借出":"未被借出")+
                ", type='" + type + '\'' +
                '}';
    }
}
