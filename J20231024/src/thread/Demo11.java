package thread;

import java.util.Scanner;

public class Demo11 {
    private static int isQuit = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (Demo11.class) {
                while (isQuit == 0) {

                }
            }
            System.out.println("t1 线程结束!");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入isQuit的值: ");
            isQuit = scanner.nextInt();
        });

        t1.start();
        t2.start();
    }
}
