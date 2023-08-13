package system_code;

/**
 * 创建线程的方式
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        //使用Thread的Runnable构造方法
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        while (true) {
            Thread.sleep(1000);
            System.out.println("main~");
        }
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread~");
        }
    }
}
