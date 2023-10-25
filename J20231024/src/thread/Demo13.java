package thread;

public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t = new Thread(() -> {
            synchronized (locker) {
                System.out.println("上锁");
                try {
                    //让t线程进入阻塞状态
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("释放锁");
            }
        });

        t.start();

        Thread.sleep(10);
        synchronized (locker) {
            //进行通知, 唤醒t线程中的wait
            locker.notify();
        }
    }
}
