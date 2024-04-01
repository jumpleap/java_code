package thread.simple;

// 创建线程 -- 实现Runnable接口
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        // 实现runnable接口
        Thread thread = new Thread(new MyRunnable());
        // 这个方法在系统内部创建线程, 启动线程, 执行线程要执行的方法, 会调用run
        thread.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}

class MyRunnable implements Runnable {
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
}