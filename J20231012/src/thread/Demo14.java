package thread;

//synchronized的使用方法: 修饰代码块, 修饰实例方法, 修饰静态方法
public class Demo14 {
    private static int count = 0;

    synchronized public void fun() {

    }

    //上面的代码等价于这个代码
    public void fun1() {
        synchronized (this) {

        }
    }

    synchronized public static void fun2() {

    }

    //等价于
    public static void fun3() {
        synchronized (Demo14.class) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
