package practice;

/**
 * MyThread方法继承Thread方法
 */
class MyThread extends Thread {
    //重写run方法：线程的入口方法
    @Override
    public void run() {
        while (true) {
            //新线程执行打印hello,thread
            System.out.println("hello,thread");
            try {
                //休眠一秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        //创建线程类
        Thread thread = new MyThread();

        //start方法会调用系统的底层API，在系统中会创建一个线程，然后调用run方法
        thread.start();

        //主线程执行该打印hello,main
        while (true) {
            System.out.println("hello,main");
            Thread.sleep(1000);
        }
    }
}