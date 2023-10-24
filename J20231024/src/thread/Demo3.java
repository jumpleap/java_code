package thread;

public class Demo3 {
    private static Object locker = new Object();

    //修饰实例方法
    synchronized public void fun1() {
    }
    //与上面代码等价
    public void fun2() {
        synchronized (this) {

        }
    }

    //修饰静态方法
    synchronized public static void fun3() {

    }
    //与上面代码等价
    public static void fun4() {
        synchronized (Demo3.class) {

        }
    }

    public static void main(String[] args) {
        //修饰代码块
        synchronized (locker) {

        }
    }
}