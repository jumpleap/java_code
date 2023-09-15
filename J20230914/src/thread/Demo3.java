package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 线程池的基本实现
 */

class MyThreadPool {
    //任务队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    public MyThreadPool(int n) {
        //创建出n个线程
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                try {
                    //取出队头任务
                    Runnable runnable = queue.take();
                    //执行任务
                    runnable.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }

    //通过submit方法把任务提交到任务队列中去
    public void submit(Runnable runnable) throws InterruptedException {
        //忙等
        queue.put(runnable);
    }
}

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int num = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行的任务 :" + num);
                }
            });
        }
    }
}