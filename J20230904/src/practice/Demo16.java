package practice;

public class Demo16 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //创建两个线程类，创建出两个线程
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        //让两个线程进行启动
        thread1.start();
        thread2.start();

        //让主线程进行等待
        thread1.join();
        thread2.join();

        //得到count的结果,结果不是我们预期的值
        System.out.println("count:" + count);
    }
}
