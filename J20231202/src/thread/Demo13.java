package thread;

// 线程安全问题
public class Demo13 {
    private static int count;

    // 创建锁对象
    private static final Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 使用两个线程分别对count进行自增50000次
        Thread t1 = new Thread(() -> {
            // 进行加锁
            synchronized (locker) {
                for (int i = 0; i < 50000; i++) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                for (int i = 0; i < 50000; i++) {
                    count++;
                }
            }
        });

        // 启动线程
        t1.start();
        t2.start();

        // 防止线程一下子就执行结束了
        t1.join();
        t2.join();

        // 查看结果
        System.out.println(count);
    }
}
