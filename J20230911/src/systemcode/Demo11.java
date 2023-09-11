package systemcode;

/**
 * 多线程 -- 一个线程不能对不同对象进行加锁
 */
public class Demo11 {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread t1 = new Thread(() -> {
            //对object1 加锁
            synchronized (object1) {
                //执行速度太快导致均能成功,bug
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //对object2 加锁
                synchronized (object2) {
                    System.out.println("加锁成功");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (object2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1) {
                    System.out.println("加锁成功");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
