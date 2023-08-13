package system_code;

/**
 * 线程的基本操作 - join的了解
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread线程工作中~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        System.out.println("join 等待开始~");
        //那个线程调用join，那么那个线程被阻塞
        thread.join();
        System.out.println("join等待结束~");
    }
}