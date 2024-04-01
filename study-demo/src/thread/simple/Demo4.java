package thread.simple;

// 创建线程 -- 实现Runnable接口
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        // 实现Runnable接口创建线程
        Thread thread = new Thread(new Runnable() {
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
        });

        // 启动线程
        thread.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
