package thread.simple;

// synchronized的特性: 可重入
// 可重入锁: 一个线程连续针对一把锁, 加锁两次, 不会出现死锁, 满足这种要求的, 就是可重入锁.
public class Demo17 {
    // 锁对象
    private final static Object locker = new Object();

    public static void main(String[] args) {
        func1();
    }

    private static void func1() {
        synchronized (locker) {
            func2();
        }
    }

    private static void func2() {
        func3();
    }

    private static void func3() {
        synchronized (locker) {
            func4();
        }
    }

    private static void func4() {
        System.out.println("func函数演示可重入锁synchronized");
    }
}
