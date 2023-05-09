package operation;

import book.BookList;
import tool.Tool;

import java.util.Scanner;

/**
 * 查找图书信息
 */
public class FindOperation implements IOperation{

    @Override
    public void operation(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的书名：");
        String bookName = scanner.nextLine();
        int index = Tool.searchBook(bookList,bookName);
        if(index == -1) {
            System.out.println("没有这本书~");
            return;
        }
        System.out.println("该本书的信息为：");
        System.out.println(bookList.get(index));
        System.out.println("查找成功~");
    }
}
