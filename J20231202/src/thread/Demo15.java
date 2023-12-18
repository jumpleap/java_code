package thread;

// 锁嵌套 -- synchronized是可重入锁
public class Demo15 {
    private Object locker = new Object();

    public void fun1() {
        synchronized (locker) {
            fun2();
        }
    }

    public void fun2() {
        fun3();
    }

    public void fun3() {
        fun4();
    }

    public void fun4() {
        synchronized (locker) {

        }
    }
}
