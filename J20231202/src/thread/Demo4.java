package thread;

// 线程的创建方式 -- Runnable接口的匿名内部类
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thread!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();

        while (true) {
            System.out.println("main!");
            Thread.sleep(1000);
        }
    }
}
