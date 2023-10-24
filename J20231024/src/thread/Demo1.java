package thread;

public class Demo1 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        //创建线程并执行任务
        t1.start();
        t2.start();

        //让main线程阻塞等待
        t1.join();
        t2.join();
        //结果不正确, 正确结果为100000
        System.out.println(count);
    }
}