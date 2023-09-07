package systemcode;

import java.util.Scanner;

/**
 * 内存可见性 —— 使用sleep方法降低代码执行速度
 */
public class Demo16 {
    private static int isQuit = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (isQuit == 0) {
                try {
                    //当使用sleep方法进行线程休眠后，线程的执行速度就降低下来了，此时就没有内存可见性的问题
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1线程结束");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入isQuit的值：");
            isQuit = scanner.nextInt();
        });

        t1.start();
        t2.start();
    }
}