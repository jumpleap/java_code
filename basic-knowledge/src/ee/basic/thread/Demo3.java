package ee.basic.thread;

// 创建线程 -- 匿名内部类【实现接口】
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 启动！");
            }
        });

        // 在系统中创建出线程
        thread.start();
        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}