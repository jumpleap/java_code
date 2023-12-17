package thread;

// 线程的创建方式 -- lambda表达式
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("thread!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
