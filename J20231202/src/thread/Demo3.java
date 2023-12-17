package thread;

// 线程的创建方式 -- 匿名内部类
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
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
        };

        // 必须启动线程
        thread.start();

        while (true) {
            System.out.println("main!");
            Thread.sleep(1000);
        }
    }
}