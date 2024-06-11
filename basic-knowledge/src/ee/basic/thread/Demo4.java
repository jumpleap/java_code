package ee.basic.thread;

// 创建线程 -- lambda表达式
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread 启动！");
        });

        // 在系统中创建出线程
        thread.start();
        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}