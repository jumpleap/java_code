package book;

/**
 * 图书类
 */
public class Book {
    private String bookName;//书名
    private String author;//作者
    private double price;//价格
    private String type;//类型
    private boolean isBorrowed;//是否借出

    public Book(String bookName, String author, double price, String type) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + (isBorrowed == false ? "在馆":"已借出") +
                '}';
    }
}
