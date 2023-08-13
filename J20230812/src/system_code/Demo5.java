package system_code;

/**
 * 创建线程的方式 - 推荐的写法【lambda表达式】
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("thread~");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println("main~");
        }
    }
}