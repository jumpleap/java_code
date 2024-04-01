package thread.simple;

// 线程 -- setDaemon(设置后台线程)
public class Demo6 {
    public static void main(String[] args) {
        // 创建线程, 并重命名
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "新线程");
        // 这个地方是对线程起了新的名字, 否则是系统创建的名称

        // 设置thread为后台线程, 在start之前设置
        // 前台线程: 一个Java进程中, 如果前台线程没有执行结束, 那么整个进程是一定不会结束的
        // 后台线程: 一个Java进程中, 后台线程结不结束, 对整个进程的结束不影响
        thread.setDaemon(true);

        // 调用start方法, 在系统中创建出新线程, 该线程自动调用run方法
        thread.start();
    }
}
