package operation;

import book.BookList;
import tool.Tool;

import java.util.Scanner;

/**
 * 归还图书
 */
public class ReturnOperation implements IOperation{

    @Override
    public void operation(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要归还图书的书名：");
        String bookName = scanner.nextLine();
        int index = Tool.searchBook(bookList,bookName);
        if(index == -1 || !bookList.getBooks()[index].isBorrowed()) {
            System.out.println("你没有借这本书");
            return;
        }
        bookList.getBooks()[index].setBorrowed(false);
        System.out.println("归还成功~");
    }
}
