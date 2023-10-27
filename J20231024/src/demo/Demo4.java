package demo;

public class Demo4 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker2) {

                }
            }
            System.out.println("t1结束!");
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker1) {

                }
            }
            System.out.println("t2结束!");
        });

        t1.start();
        t2.start();
    }
}
