package thread;

/**
 * Thread的方法 -- join的使用
 */
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        //join必须要搭配start使用, 若是无start方法, 那么join无意义
        //那个线程调用join, 那么那个线程进入阻塞
        t.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程工作中");
            Thread.sleep(500);
        }
    }
}
