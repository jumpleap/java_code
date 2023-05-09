package user;

import book.BookList;
import operation.IOperation;

/**
 * 用户类
 */
public abstract class User {
    protected String name;
    //对应各种操作
    IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int menu();

    /**
     * 相应的操作
     * @param bookList 书架
     * @param index 下标
     */
    public void doOperation(BookList bookList, int index) {
        //操作进行动态绑定，动态绑定到operation所对应的方法
        iOperations[index].operation(bookList);
    }
}
