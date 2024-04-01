package thread.simple;

// 创建线程 -- 匿名内部类
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        // 匿名内部类创建线程
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello thread");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // 启动线程
        thread.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
