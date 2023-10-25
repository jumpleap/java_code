package thread;

public class Demo15 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("上锁");
                try {
                    //释放当前的锁, 进入阻塞状态
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("释放锁");
            }
        });

        Thread t2 = new Thread(() -> {
            //notify也需要使用synchronized修饰
            synchronized (locker) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //进行唤醒阻塞的对象线程, 唤醒的线程得等待notify的synchronized的代码块执行结束
                locker.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
