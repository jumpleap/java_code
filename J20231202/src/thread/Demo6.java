package thread;

// 线程名字设置, 设置后台线程
public class Demo6 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "这是一个新线程");
        // 线程名字使用jconsole查看

        // 设置线程为后台线程, 在线程启动前设置
        thread.setDaemon(true);

        thread.start();
    }
}