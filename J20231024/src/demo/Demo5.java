package demo;

public class Demo5 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                try {
                    locker.wait(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("A");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                try {
                    locker.wait(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("B");
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (locker) {
                try {
                    locker.wait(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("C");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
