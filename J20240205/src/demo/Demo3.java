package demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 线程池的模拟实现
class MyThreadPool {
    // 任务队列, 容量1000
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    // 通过这个方法, 把任务添加到任务队列中
    public void submit(Runnable runnable) throws InterruptedException {
        // 此处的拒绝策略是: 阻塞等待(下策)
        queue.put(runnable);
    }

    public MyThreadPool(int n) {
        // 创建n个线程, 负责执行上述队列中的任务
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            // 防止变量捕获的问题
            int id = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务: " + id);
                }
            });
        }
    }
}