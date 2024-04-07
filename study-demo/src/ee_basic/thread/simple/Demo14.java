package ee_basic.thread.simple;

// 线程安全问题 -- 计数不正确
public class Demo14 {
    // 计数变量
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        // 创建线程并执行任务
        thread.start();
        thread1.start();

        // 添加join方法, 让main线程进行阻塞等待
        thread.join();
        thread1.join();

        // 结果不正确, 不为100000
        System.out.println(count);
    }
}
