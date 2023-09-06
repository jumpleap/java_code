package practice;

/**
 * 线程等待
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程工作结束");
            }
        });

        thread.start();

        System.out.println("主线程开始等待");
        thread.join();
        System.out.println("主线程等待结束");
    }
}
