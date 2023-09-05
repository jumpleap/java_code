package practice;

/**
 * Thread类的构造方法
 */
public class Demo7 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello,thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "这是一个新线程");

        //调用start之后，系统中会创建出一个新进程，然后新线程自动调用run()方法
        thread.start();
    }
}