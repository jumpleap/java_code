package thread;

public class Demo4 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t = new Thread(() -> {
            synchronized (locker) {
                synchronized (locker) {
                    synchronized (locker) {
                        synchronized (locker) {

                        }
                    }
                }
            }
        });
    }
}
