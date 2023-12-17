package thread;

// 线程的创建方式 -- 继承Thread重写run方法
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        // run方法描述了线程的入口(要执行什么任务)
        // start方法则是调用系统API, 在系统中创建出线程, 让线程调用run方法
        thread.start();
        while (true) {
            System.out.println("main!");
            Thread.sleep(1000);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // 这个方法是线程的入口方法
        while (true) {
            System.out.println("thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}