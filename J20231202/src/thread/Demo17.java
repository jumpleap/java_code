package thread;

import java.util.Scanner;

// demo
public class Demo17 {
    private volatile static int isQuit = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (isQuit == 0) {
                // 什么都不做, 一直循环
            }
            System.out.println("t1退出!");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入isQuit的值: ");
            isQuit = scanner.nextInt();
        });

        t1.start();
        t2.start();
    }
}
