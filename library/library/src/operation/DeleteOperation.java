package operation;

import book.BookList;
import tool.Tool;

import java.util.Scanner;

/**
 * 删除图书信息
 */
public class DeleteOperation implements IOperation{

    @Override
    public void operation(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的书名：");
        String bookName = scanner.nextLine();
        int index = Tool.searchBook(bookList,bookName);
        int size = bookList.getCurrentSize();

        for(int i=0; i<size; i++) {
            if(bookList.getBooks()[i].getBookName().equals(bookName)) {
                for (int j = i; j < size - 1; j++) {
                    bookList.getBooks()[i] = bookList.getBooks()[i+1];
                }
            }
        }
        bookList.getBooks()[size - 1] = null;
        bookList.setCurrentSize(bookList.getCurrentSize() - 1);
        System.out.println("删除成功！");
        //显示删除后的信息
        new ShowOperation().operation(bookList);
    }
}
