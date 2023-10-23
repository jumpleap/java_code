package thread;

/**
 * 线程的状态
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //Runnable: 运行状态, 线程在CPU上执行或在排队上CPU上执行
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //NEW: Thread类已经创建, 但是还没有调用start方法, 即还没有创建线程
        System.out.println(t.getState());

        t.start();
        for (int i = 0; i < 5; i++) {
            //TIMED_WAITING: 由sleep这个固定方式的时间引起的阻塞
            System.out.println(t.getState());
            Thread.sleep(1000);
        }

        //TERMINATED: 线程已经销毁了,但是Thread类还在
        Thread.sleep(3000);
        System.out.println(t.getState());
    }
}
