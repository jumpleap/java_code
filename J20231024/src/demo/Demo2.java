package demo;

public class Demo2 {
    private static  int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (Demo2.class) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Demo2.class) {
                    count++;
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(2000);
        System.out.println(count);
    }
}
