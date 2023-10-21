package thread;

/**
 * 创建线程的方式 -- 继承Thread类, 重写run()方法
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}