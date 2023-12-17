package thread;

// 线程等待 -- join
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        // 让main线程进行等待thread线程先执行完
        // 那个线程调用join方法, 则那个线程进行阻塞等待
        System.out.println("join等待开始");
        thread.join();
        System.out.println("join等待结束");

        System.out.println("main");
    }
}
