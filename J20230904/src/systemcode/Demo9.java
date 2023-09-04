package systemcode;

/**
 * 线程的终止/打断 - 设置标记位
 */
public class Demo9 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!isQuit) {
                System.out.println("hello,thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        Thread.sleep(5000);
        //把isQuit设置为true
        isQuit = true;
        System.out.println("isQuit设置为true！");
    }
}
