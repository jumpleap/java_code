package thread.simple;

// notifyAll(): 唤醒所有对象线程, 让这些线程重新去竞争锁
public class Demo26 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t1上锁");
                try {
                    //释放当前的锁, 进入阻塞状态
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1释放锁");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t2上锁");
                try {
                    //释放当前的锁, 进入阻塞状态
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t2释放锁");
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t3上锁");
                try {
                    //释放当前的锁, 进入阻塞状态
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t3释放锁");
            }
        });

        Thread t4 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t4上锁");
                try {
                    //释放当前的锁, 进入阻塞状态
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t4释放锁");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(2000);
        synchronized (locker) {
            //唤醒所有的locker的阻塞线程
            locker.notifyAll();
        }
    }
}
