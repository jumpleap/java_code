package thread.simple;

// synchronized对不同的对象进行加锁
// synchronized可以对不同的对象进行加锁, 只要加锁的这些对象没有被其他线程加锁过;
// 若是这些对象已经被其他线程加锁, 那么就会出现死锁
public class Demo18 {
    private final static Object locker = new Object();
    private final static Object locker1 = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (locker) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker1) {
                    System.out.println("thread加锁成功!");
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            // locker这把锁被thread线程拿到了, 需要等待thread线程释放后才能拿到
            synchronized (locker) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker1) {
                    System.out.println("thread1加锁成功!");
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
