package thread;

/**
 * Thread的方法 -- 线程的打断
 */
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            //注: currentThread()获取当前类的引用, isInterrupted()是标记位
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //注意: 引发异常后, 标志位被清除了,在这个地方可以进行额外的工作
                    //1.直接退出
                    //break;
                    //e.printStackTrace();

                    //2.继续执行当前任务, 不使用break

                    //3.执行一些收尾工作, 然后break
                    break;
                }
            }
            System.out.println("线程工作结束");
        });

        t.start();

        Thread.sleep(5000);
        t.interrupt();//设置标记位为true
    }
}
