package test;

import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();//向上转型

        while (true) {
            int choice = user.menu();//动态绑定到对应的方法
            user.doOperation(bookList,choice);//静态绑定的体现
        }


    }

    /**
     * 多态的向上转型：返回值
     * @return 返回对象
     */
    private static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();

        System.out.println("Hello  " + name + "  欢迎来到图书管理小系统~");
        while (true) {
            System.out.println("1->管理员   0->读者");
            System.out.println("请输入你的选择：");
            int opt = scanner.nextInt();

            //判断是管理员还是普通用户
            if(opt == 1) {
                //返回管理管理员对象
                return new AdminUser(name);
            } else if(opt == 0) {
                //返回学生对象
                return new NormalUser(name);
            } else {
                System.out.println("你输入错误，请重新输入正确的值~");
            }
        }
    }
}
