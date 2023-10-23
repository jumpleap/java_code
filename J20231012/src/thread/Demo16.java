package thread;

//死锁问题, 两个线程两把锁
//解决办法: 小序号优先
public class Demo16 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {

                }
            }
            System.out.println("t1 加锁成功");
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {

                }
            }
            System.out.println("t2 加锁成功");
        });

        t1.start();
        t2.start();
    }
}
