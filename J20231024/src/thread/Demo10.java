package thread;

public class Demo10 {
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

        t1.start();
        t2.start();

        //让主线程阻塞
        t1.join();
        t2.join();

        //结果还不是准确的10w
        System.out.println(count);
    }
}
