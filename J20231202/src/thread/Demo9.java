package thread;

// 线程的打断 -- 使用API
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println("线程执行中!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 1. 抛出异常, 结束循环
                    // throw new RuntimeException(e);
                    // 2. 继续行动
                    // 3. 做一些收尾工作
                    break;
                }
            }
            System.out.println("线程结束!");
        });

        thread.start();

        Thread.sleep(5000);

        // 将标志位设为true
        thread.interrupt();
    }
}
