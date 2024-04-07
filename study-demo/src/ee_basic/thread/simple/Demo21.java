package ee_basic.thread.simple;

import java.util.Scanner;

// volatile关键字 -- 解决内存可见性问题
public class Demo21 {
    // 未使用volatile, 存在内存可见性问题
    // private static int isQuit = 0;
    // 使用volatile修饰
    private static volatile int isQuit = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (isQuit == 0) {

            }
            System.out.println("退出线程thread");
        });
        thread.start();

        Thread thread1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            // 当我们输入不为0的数的时候, 上处的循环就会终止
            // 但是在没有volatile关键字 的情况下, 上述循环仍旧在继续执行
            // 在Java编译器中, 为了提高效率, 编译器就可能会对代码做出优化, 把一些本来要读内存的操作,
            // 优化成读取寄存器, 减少都内存的次数, 就可以提高整体程序的效率了
            isQuit = scanner.nextInt();
        });
        thread1.start();
    }
}
