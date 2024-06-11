package ee.basic.thread;

// 创建线程 -- 继承Thread，重写run方法
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // 初始化一个线程对象，注：此时还未创建出真正的线程
        Thread thread = new MyThread();

        // 这个方法会调用系统的API，在系统中创建出一个新的线程
        // 创建好线程后，会自动调用run方法
        thread.start();

        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}

// 继承Thread，重写run方法
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread 启动！");
    }
}