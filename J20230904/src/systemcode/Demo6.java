package systemcode;

/**
 * 线程的基本属性
 */
public class Demo6 {
    public static void main(String[] args) {
        //创建线程并命名，可以使用jconsole进行查看进程名
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello,thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "这是一个新进程");

        //把t线程设置为后台线程
        t.setDaemon(true);
        t.start();
    }
}
