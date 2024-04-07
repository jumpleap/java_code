package ee_basic.thread.simple;

// volatile不保证原子性
// 这个代码还是存在线程安全问题
public class Demo22 {
    private volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(count);
    }
}