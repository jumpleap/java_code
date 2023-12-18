package thread;

// 两把锁对两个线程
public class Demo16 {
    // 创建两把锁
    private static final Object locker1 = new Object();
    private static final Object locker2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (locker2) {
                    System.out.println("t1加锁成功");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (locker2) {
                    System.out.println("t2加锁成功");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}