package systemcode;

/**
 * 线程等待 - join
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hello,thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        System.out.println("join开始等待");
        //那个线程调用join方法，那么那个线程进行阻塞状态，让被调用的线程进行执行，执行完后才能回到被阻塞的线程
        t.join();
        System.out.println("join等待结束");
    }
}
