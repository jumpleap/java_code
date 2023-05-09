package book;


/**
 * 图书管理类：对图书进行相应操作
 */
public class BookList {
    private Book[] books = new Book[10];
    private int currentSize = 0;

    public BookList() {
        initBooks();
    }

    /**
     * 初始化几个图书对象
     */
    public void initBooks() {
        books[0] = new Book("水浒传","按不出",13.14,"novel");
        books[1] = new Book("三国演义","按不出",13.14,"novel");
        books[2] = new Book("红楼梦","按不出",13.14,"novel");
        currentSize += 3;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    //返回对应下标的图书
    public Book get(int pos) {
        return books[pos];
    }
}
