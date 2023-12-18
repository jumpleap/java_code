package thread;

// join在多个线程中的使用
public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1退出!");
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    t1.join();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t2退出!");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("main退出!");
    }
}
