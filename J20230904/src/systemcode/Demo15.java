package systemcode;

/**
 * 锁的实例对象和静态对象
 */
class Counter {
    public int count = 0;
    private Object locker = new Object();

    public void increase() {
        //对this进行加锁
        synchronized (this) {
            count++;
            func1();
        }
    }

    public void func1() {
        func2();
    }

    public void func2() {
        func3();
    }

    //对func3函数进行加锁
    public synchronized void func3() {

    }

    public void increase2() {
        count++;
    }

    //synchronized对静态方法进行加锁，相当于对类对象进行加锁
    //这个地方对类对象进行了两次加锁，synchronized是可重入锁
    public synchronized static void func() {
        //对类对象进行加锁
        synchronized (Counter.class) {

        }
    }
}

public class Demo15 {
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

        System.out.println("count : " + counter.count);
    }
}