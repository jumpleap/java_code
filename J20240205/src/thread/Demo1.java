package thread;

// 创建多线程
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread启动!");
            }
        });
        // 启动线程
        thread.start();

        while (true) {
            Thread.sleep(2000);
            System.out.println("main启动!");
        }
    }
}
