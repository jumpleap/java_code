package ee.basic.thread;

// 创建线程 -- 匿名内部类【重写Thread类的run方法】
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        // 初始化线程对象
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("thread 启动！");
            }
        };

        // 在系统中创建出线程
        thread.start();
        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}
