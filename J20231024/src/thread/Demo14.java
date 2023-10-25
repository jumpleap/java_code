package thread;

public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t = new Thread(() -> {
            synchronized (locker) {
                System.out.println("上锁");
                try {
                    //让t线程进入阻塞状态,3s后未被唤醒,则结束阻塞等待
                    locker.wait(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("释放锁");
            }
        });

        t.start();
    }
}
