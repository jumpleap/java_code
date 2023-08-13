package system_code;

/**
 * 线程的基本方法
 */
public class Demo6 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello,world~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"这是新线程");
        //把thread设置为后台进程
        thread.setDaemon(true);
        thread.start();
    }
}