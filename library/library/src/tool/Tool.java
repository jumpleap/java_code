package tool;

import book.BookList;

public class Tool {
    /**
     * 查找书名在书架中的位置
     * @param bookList 书架
     * @param bookName 书名
     * @return 返回值
     */
    public static int searchBook(BookList bookList, String bookName) {
        int size = bookList.getCurrentSize();
        for (int i = 0; i < size; i++) {
            if(bookList.get(i).getBookName().equals(bookName)) {
                return i;
            }
        }
        return -1;
    }
}
