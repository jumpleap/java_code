package demo;

public class Demo2 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t = new Thread(() -> {
            synchronized (locker1) {
                synchronized (locker2) {
                    System.out.println("加锁成功");
                }
            }
        });
        t.start();
    }
}
