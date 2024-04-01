package thread.simple;

// 创建线程 -- lambda表达式
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        // lambda表达式创建线程
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        thread.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
