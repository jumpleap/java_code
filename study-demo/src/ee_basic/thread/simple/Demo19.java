package ee_basic.thread.simple;

// 死锁
// 死锁出现的原因
// 1) 一个线程针对一把锁, 连续加锁两次, 如果是不可重入锁, 就死锁了.(synchronized是可重入锁)
// 2) 两个线程, 对两把锁均进行加锁.
// 3) N个线程, M把锁
public class Demo19 {
    // 创建两把锁
    private final static Object locker1 = new Object();
    private final static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t1加锁成功!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker1) {
                    System.out.println("t2加锁成功!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
