package thread;

// wait和notify搭配使用
public class Demo20 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("wait之前");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 进行线程阻塞等待
            synchronized (locker) {
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("wait之后");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            synchronized (locker) {
                System.out.println("通知wait");
                locker.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
