package thread;

import static thread.Demo14.fun2;
import static thread.Demo14.fun3;

// synchronized 的可重入特性
public class Demo15 {
    public void fun() {
        synchronized (this) {
            fun1();
        }
    }

    private void fun1() {
        fun2();
    }

    private void fun2() {
        fun3();
    }

    private void fun3() {
        synchronized (this) {

        }
    }

    public static void main(String[] args) {

    }
}