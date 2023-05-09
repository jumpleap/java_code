package operation;

import book.BookList;

/**
 * 退出图书系统
 */
public class ExitOperation implements IOperation {

    @Override
    public void operation(BookList bookList) {
        System.out.println("退出成功~");
        System.exit(0);
    }
}
