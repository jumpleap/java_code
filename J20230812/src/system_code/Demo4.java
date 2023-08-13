package system_code;

/**
 * 创建线程的方式
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        //基于runnable接口的匿名内部类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("thread~");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        while (true) {
            Thread.sleep(1000);
            System.out.println("main~");
        }
    }
}
