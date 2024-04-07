package ee_basic.thread.simple;

// 线程 -- 线程中断
// 法二: Thread 中自带的方法 currentThread().isInterrupted()
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 中断处
            // currentThread(): 获取当前线程的实例
            // isInterrupted(): Thread类的内部标记位，用于判断线程是否结束【默认返回值是false】
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 当内部标记位被设为true, 引发异常, 在这里进行处理
                    // 1. 直接抛出异常, 但是循环继续执行
                    e.printStackTrace();

                    // 2.添加break, 打印异常后跳出循环
                    // e.printStackTrace();
                    // break;

                    // 3.在跳出循环之前做一些任务
                }
            }
            System.out.println("线程工作完毕");
        });

        thread.start();
        Thread.sleep(5000);

        // 把Thread的内部标记位设置为true, 打断sleep的休眠, 引发异常
        // ee_basic.thread.interrupt()唤醒线程后，sleep()会抛出异常，同时会自动清除刚才设置的标记位, 既true->false
        thread.interrupt();
    }
}
