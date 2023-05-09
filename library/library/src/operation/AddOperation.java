package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * 添加图书信息
 */
public class AddOperation implements IOperation{

    @Override
    public void operation(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：");
        String bookName = scanner.nextLine();
        System.out.println("请输入作者名：");
        String author = scanner.nextLine();
        System.out.println("请输入书价格：");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("请输入书的类型：");
        String type = scanner.nextLine();

        Book book = new Book(bookName, author, price, type);
        bookList.getBooks()[bookList.getCurrentSize()] = book;
        bookList.setCurrentSize(bookList.getCurrentSize()+1);
        System.out.println("添加成功~");
    }
}
