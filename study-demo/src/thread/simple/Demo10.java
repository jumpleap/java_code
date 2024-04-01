package thread.simple;

// 线程 -- join(线程等待)
// 线程等待: 让一个线程，等到另外一个线程执行结束，再继续执行【控制线程的结束顺序】
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        System.out.println("main 等待开始");
        // join必须搭配start使用, 若是无start方法, 那么join无意义
        // 那个线程调用join, 那个线程进入阻塞; 直到thread线程执行结束, join才会结束阻塞
        thread.join();
        System.out.println("main 等待结束");
    }
}
