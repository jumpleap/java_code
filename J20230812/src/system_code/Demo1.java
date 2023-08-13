package system_code;

/**
 * 多线程的基本了解
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        //调用start()方法后，会在系统底层调用api来创建线程，然后线程调用run方法
        thread.start();
        while (true) {
            //sleep方法需要抛出异常
            Thread.sleep(1000);
            System.out.println("main~");
        }
    }
}

class MyThread extends Thread {
    //run方法是线程的入口方法，表示线程需要做什么任务
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello,thread~!");
        }
    }
}