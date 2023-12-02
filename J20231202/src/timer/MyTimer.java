package timer;

import java.util.PriorityQueue;

// 实现定时器
public class MyTimer {
    // 创建任务队列
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 定义锁对象
    private final Object locker = new Object();

    // 实现schedule方法
    public void schedule(Runnable runnable, long delay) {
        // 把任务添加到任务队列中去
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();
        }
    }


    // 在Timer类中定义扫描线程, 用于扫描即将要执行的任务
    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        // 队列为空,进行阻塞等待
                        while (queue.isEmpty()) {
                            locker.wait();
                        }

                        // 队列不为空
                        MyTimerTask task = queue.peek();
                        long time = System.currentTimeMillis();
                        // 进行时间比较
                        if (time >= task.getTime()) {
                            // 执行任务
                            task.getRunnable().run();
                            // 把任务从队列踢掉
                            queue.poll();
                        } else {
                            // 最小的任务时间都还没有到, 进行阻塞等待
                            locker.wait(task.getTime() - time);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}