package ee_basic.thread.simple;

// 创建线程 -- 继承Thread重写Runnable接口
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThead();
        // 直接调用run方法, 此时只有一个主线程, 执行按照顺序执行
        // ee_basic.thread.run();
        // start方法则是真正的调用了系统API, 在系统中创建出线程, 让线程在调用run方法
        thread.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}

class MyThead extends Thread {
    // run方法: 线程的入口方法, 表示线程要做什么任务
    @Override
    public void run() {
        while (true) {
            System.out.println("hello ee_basic.thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
