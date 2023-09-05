package practice;

/**
 * 后台线程
 */
public class Demo9 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello,thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //设置thread为后台线程,需要在调用start之前设置
        thread.setDaemon(true);

        //调用start之后，系统中会创建出一个新进程，然后新线程自动调用run()方法
        thread.start();
    }
}
