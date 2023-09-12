package thread;

/**
 * 有三个线程，线程名称分别为：a，b，c。
 * 每个线程打印自己的名称。
 * 需要让他们同时启动，并按 c，b，a的顺序打印
 */
public class Demo3 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "c");

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }, "b");

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }, "a");

        t1.start();
        t2.start();
        t3.start();
    }
}
