package ee_basic.thread.difficult;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 模拟实现线程池
public class MyThreadPool {
    // 初始化任务队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    // 通过submit方法, 把任务提交到队列中
    public void submit(Runnable runnable) throws InterruptedException {
        // 此处的拒绝策略: 阻塞等待
        queue.put(runnable);
    }

    public MyThreadPool(int n) {
        // 这里创建出n个线程, 负责执行队列中的任务
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // 获取到队列中要执行的任务
                    Runnable runnable = queue.take();
                    // 执行任务
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}

class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        // 初始化线程池
        MyThreadPool pool = new MyThreadPool(4);

        // 创建任务, 并提交任务
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread!");
            }
        });
    }
}