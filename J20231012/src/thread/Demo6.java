package thread;

/**
 * Thread类的属性 -- 后台线程的设置(setDaemon)
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //在创建线程之前把要创建的线程设为后台线程
        //t.setDaemon(true);
        t.start();
        //t.setDaemon(true);
    }
}