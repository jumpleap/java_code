package systemcode;

/**
 * 创建线程的五种方式 - 继承Thread类，重写run
 */

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello~ thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        while (true) {
            System.out.println("hello, main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}