package system_code;

/**
 * 创建线程的方式
 */
public class Demo3 {
    public static void main(String[] args) {
        //使用匿名内部类
        Thread thread = new Thread() {
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
        };
        thread.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main~");
        }
    }
}
