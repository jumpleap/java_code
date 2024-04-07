package ee_basic.thread.simple;

// 线程 -- isAlive(判断线程是否存在)
public class Demo7 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束");
        });

        // 判断线程是否存活, 此时新线程还没有开始创建
        System.out.println(thread.isAlive());
        // 调用start方法, 在系统中创建出新线程, 该线程自动调用run方法
        thread.start();

        // 此时, 线程已经调度了
        System.out.println(thread.isAlive());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 此时, 线程已经运行结束, 销毁了
        System.out.println(thread.isAlive());

        // 注：Thread对象的生命周期比系统内核中的线程更长一些；会存在Thread对象还在，
        // 内核中的线程已经销毁了的这种情况。【线程的创建在系统也是有一定开销的】
    }
}
