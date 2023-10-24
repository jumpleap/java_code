package thread;

public class Demo5 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread t = new Thread(() -> {
            synchronized (locker1) {
                synchronized (locker2) {
                    synchronized (locker3) {
                        System.out.println("加锁~");
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("加锁成功");
        });

        t.start();
    }
}
