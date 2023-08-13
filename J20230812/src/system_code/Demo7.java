package system_code;

/**
 * 线程的基本方法
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束~");
        });
        System.out.println(thread.isAlive());
        thread.start();
        System.out.println(thread.isAlive());


        Thread.sleep(3000);
        System.out.println(thread.isAlive());
    }
}
