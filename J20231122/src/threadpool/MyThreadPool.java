package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 线程池的模拟实现
public class MyThreadPool {
    // 定义任务队列
    BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    // 实现submit方法, 把任务提交到队列中
    public void submit(Runnable runnable) throws InterruptedException {
        // 当队列满了后, 进行阻塞等待
        queue.put(runnable);
    }

    // 构造器中的线程用于消费任务
    public MyThreadPool(int n) {
        // n表示线程数目
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                try {
                    // 从队列中消费任务, 并执行任务
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // 相当于固定创建线程数目
        MyThreadPool pool = new MyThreadPool(4);
        for (int i = 0; i < 100; i++) {
            int id = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("id: " + id);
                }
            });

            Thread.sleep(1000);
        }
    }
}