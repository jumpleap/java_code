package systemcode;

/**
 * 创建线程的五种方式 - lambda表达式【推荐使用】
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello,thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        while (true) {
            System.out.println("hello,main");
            Thread.sleep(1000);
        }
    }
}
