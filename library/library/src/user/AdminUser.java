package user;

import operation.*;

import java.util.Scanner;

/**
 * 管理员
 */
public class AdminUser extends User {

    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{new ExitOperation(),new FindOperation(), new AddOperation(),
                new DeleteOperation(), new ShowOperation()
        };

    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        System.out.println("**********************************");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("**********************************");
        while (true) {
            System.out.println("请输入你的选择：");
            opt = scanner.nextInt();
            if (opt < 0 || opt > 4) {
                System.out.println("您输入的数字有误，请重新输入~");
            } else {
                return opt;
            }
        }
    }
}
