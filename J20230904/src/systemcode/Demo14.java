package systemcode;

/**
 * 线程安全2 - 加锁
 */
public class Demo14 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        //对两个线程进行加锁
        //只有等t1进程执行结束后，才能解锁执行t2进程
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized(locker) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized(locker) {
                    count++;
                }
            }
        });

        //两个线程同时进行
        t1.start();
        t2.start();

        //若没有这两个join，肯定不得行，主线程一下子就执行完了，可能count打印0
        t1.join();
        t2.join();

        System.out.println("count : " + count);
    }
}
