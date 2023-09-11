package systemcode;

/**
 * 多线程 -- wait和notify的使用
 */
public class Demo7 {
    public static void main(String[] args) {
        Object object = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (object) {
                System.out.println("wait之前");
                try {
                    //释放锁之后进行阻塞,需要其他线程来唤醒
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("wait之后");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (object) {
                //在进行线程通知的时候,也需要加上锁,唤醒阻塞的进程
                System.out.println("进行通知");
                object.notify();
            }
        });
        t1.start();
        t2.start();
    }
}