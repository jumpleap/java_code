package thread.simple;

// 线程安全问题 -- 计数的解决
// 加上锁 -- synchronized
public class Demo15 {
    // 计数变量
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // 锁对象
        Object locker = new Object();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // 当前线程加锁,另一个线程想要相同的锁, 需要阻塞等待, 直到前一个线程释放锁
                synchronized (locker) {
                    count++;
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // 当前线程加锁,另一个线程想要相同的锁, 需要阻塞等待, 直到前一个线程释放锁
                synchronized (locker) {
                    count++;
                }
            }
        });

        // 创建线程并执行任务
        thread.start();
        thread1.start();

        // 添加join方法, 让main线程进行阻塞等待
        thread.join();
        thread1.join();

        // 结果正确
        System.out.println(count);
    }
}
