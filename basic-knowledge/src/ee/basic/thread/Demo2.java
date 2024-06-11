package ee.basic.thread;

// 创建线程 -- 实现Runnable接口，重写run方法
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        // 初始化线程对象
        Thread thread = new Thread(new MyRunnable());

        // 在系统中创建出线程
        thread.start();
        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("thread 启动！");
    }
}