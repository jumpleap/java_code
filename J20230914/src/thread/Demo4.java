package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyThreadPool1 {
    // 任务队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    // 通过这个方法, 把任务添加到队列中
    public void submit(Runnable runnable) throws InterruptedException {
        // 此处咱们的拒绝策略, 相当于是第五种策略了. 阻塞等待~~ (这是下策)
        queue.put(runnable);
    }

    public MyThreadPool1(int n) {
        // 创建出 n 个线程, 负责执行上述队列中的任务.
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                // 让这个线程, 从队列中消费任务, 并进行执行.
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool1 myThreadPool = new MyThreadPool1(4);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务: " + id);
                }
            });
        }
    }
}
