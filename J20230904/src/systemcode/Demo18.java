package systemcode;

/**
 * 一个线程中不能对不同的对象进行两次不同加锁，导致死锁
 */
public class Demo18 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            //对locker1进行加锁和locker2进行加锁
            synchronized (locker1) {
                //这里的sleep的防止线程执行速度过快
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t1加载成功");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker1) {
                    System.out.println("t2加载成功");
                }
            }
        });

        t1.start();
        t2.start();
    }
}