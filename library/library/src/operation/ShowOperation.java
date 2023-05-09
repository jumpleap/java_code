package operation;

import book.BookList;

/**
 * 显示所有的图书信息
 */
public class ShowOperation implements IOperation{
    @Override
    public void operation(BookList bookList) {
        System.out.println("所有图书信息如下：");
        int size = bookList.getCurrentSize();
        for (int i = 0; i < size; i++) {
            System.out.println(bookList.get(i));
        }
    }
}
