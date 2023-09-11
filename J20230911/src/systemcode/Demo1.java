package systemcode;

/**
 * synchronized修饰实例对象和静态对象的区别
 */

class Counter {
    public int count;
    //synchronized修饰实例对象
    public synchronized void increase() {
        count++;
    }
    public void increase2() {
        synchronized (this) {

        }
    }

    //synchronized修饰静态对象
    public synchronized static void increase3() {

    }

    public static void increase4() {
        synchronized (Counter.class) {

        }
    }
}
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count :" + counter.count);
    }
}