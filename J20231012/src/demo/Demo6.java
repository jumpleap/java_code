package demo;

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(()-> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getState());
                synchronized (locker2) {

                }
            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (locker2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (locker1) {

                }
            }
        });

        t1.start();
        t2.start();

        System.out.println(t1.getState());
        System.out.println(t2.getState());
        t1.join();
        t2.join();
    }
}
