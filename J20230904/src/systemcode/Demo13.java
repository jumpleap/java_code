package systemcode;

/**
 * 线程安全1
 */
public class Demo13 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        //两个线程同时进行
        t1.start();
        t2.start();

        //若没有这两个join，肯定不得行，主线程一下子就执行完了，可能count打印0
        t1.join();
        t2.join();

        System.out.println("count : " + count);
    }
}
