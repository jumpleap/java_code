package practice;

public class Demo1 {
    public static void main(String[] args) {
        //创建线程类
        Thread thread = new MyThread();

        thread.run();
    }
}
