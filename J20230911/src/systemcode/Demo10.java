package systemcode;

import java.util.Scanner;

public class Demo10 {
    //使用volatile保证isQuit的原子性并降低了运行效率
    private volatile static int isQuit = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1执行中");
            //编译器会进行优化
            while (isQuit == 0) {

            }
            System.out.println("t1执行结束");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入isQuit的值:");
            isQuit = scanner.nextInt();
        });

        t1.start();
        t2.start();
    }
}
