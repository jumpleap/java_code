package operation;

import book.BookList;
import tool.Tool;

import java.util.Scanner;

/**
 * 借阅图书
 */
public class BorrowOperation implements IOperation{

    @Override
    public void operation(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要借的书名：");
        String bookName = scanner.nextLine();

        int index = Tool.searchBook(bookList,bookName);
        if(index == -1 || bookList.getBooks()[index].isBorrowed()) {
            System.out.println("没有这本书~");
            return;
        }
        System.out.println("这本书的信息如下：");
        System.out.println(bookList.getBooks()[index]);
        bookList.getBooks()[index].setBorrowed(true);
        System.out.println("借阅成功~");
    }


}
