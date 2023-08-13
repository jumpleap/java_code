package system_code;

public class Demo10 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker2) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });

        t1.start();
        t2.start();

        //让主线程进行阻塞状态，先把两个线程执行完
        t1.join();
        t2.join();

        System.out.println("count = " + count);
    }
}
