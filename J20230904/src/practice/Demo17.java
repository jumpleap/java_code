package practice;

public class Demo17 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            //加锁
            synchronized (locker) {
                for (int i = 0; i < 50000; i++) {
                    count++;
                }
            }
            //出锁
        });

        Thread t2 = new Thread(() -> {
            //加锁
            synchronized (locker) {
                for (int i = 0; i < 50000; i++) {
                    count++;
                }
            }
            //出锁
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count：" + count);
    }
}
