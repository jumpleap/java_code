package demo;

public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("线程结束");
        });

        //不会在系统内核中创建新线程, 就是单独的执行一个方法
        t.run();

        //在系统内核中创建新线程, 并调用run方法
        t.start();
    }
}
