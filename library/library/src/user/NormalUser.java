package user;

import operation.*;

import java.util.Scanner;

/**
 * 普通用户
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        //继承父类的iOperations
        this.iOperations = new IOperation[]{new ExitOperation(),new FindOperation(),new BorrowOperation(),
                new ReturnOperation()};
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        System.out.println("**********************************");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("**********************************");
        while(true) {
            System.out.println("请输入你的选择：");
            opt = scanner.nextInt();
            if(opt < 0 || opt > 3) {
                System.out.println("您输入的数字有误，请重新输入~");
            } else {
                return opt;
            }
        }
    }
}
