package thread;

// 线程的打断 -- 简单方法
public class Demo8 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        // boolean isQuit = false;
        Thread thread = new Thread(() -> {
            while (!isQuit) {
                System.out.println("线程执行中!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("线程结束!");
        });

        thread.start();

        Thread.sleep(5000);
        isQuit = true;
    }
}
