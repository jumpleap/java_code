package practice;

/**
 * 实现Runnable接口
 */
class MyRunnable implements Runnable {
    //重写run()方法
    @Override
    public void run() {
        while (true) {
            System.out.println("hello,thread");
            try {
                //线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());

        //调用start()方法，系统创建线程，线程自动调用run()方法
        thread.start();

        while (true) {
            System.out.println("hello,main");
            Thread.sleep(1000);
        }
    }
}