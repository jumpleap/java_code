package systemcode;

/**
 * 多线程 -- join的使用
 */
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("t1执行中");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1执行结束");
        });

        Thread t2 = new Thread(() -> {
            try {
                //那个线程调用join,那个线程进行等待
                t1.join();
                System.out.println("t2执行中");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2执行结束");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}
