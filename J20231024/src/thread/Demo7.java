package thread;

public class Demo7 {
    public static void main(String[] args) {
        //创建两把锁
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    //休眠1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t1 加锁成功!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    //休眠1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {
                    System.out.println("t2 加锁成功!");
                }
            }
        });

        //创建并启动线程
        t1.start();
        t2.start();
    }
}
