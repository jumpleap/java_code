package time;

import java.util.PriorityQueue;

// 通过这个类, 描述了一个任务
class MyTimerTask implements Comparable<MyTimerTask> {
    // 要执行的任务
    private Runnable runnable;
    // 执行任务的时间
    private long time;

    // 此处的delay就是schedule中传入的相对时间
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = delay + System.currentTimeMillis();
    }

    @Override
    public int compareTo(MyTimerTask o) {
        // 这样的写法, 就是让队首元素是最小时间的值
        return (int) (this.time - o.time);
        // 这样的写法, 就是让队首元素是最大时间的值
        // return (int) o.time - this.time;
    }

    public long getTime() {
        return time;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}

// 自己做的定时器
public class MyTimer {
    // 使用一个数据结构, 保存所有要执行的任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 使用这个对象作为锁对象
    private final Object locker = new Object();

    // 用于把任务添加到优先级队列中
    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();
        }
    }

    public MyTimer() {
        // 搞个扫描线程
        scanTask();
    }

    // 实现扫描线程
    private void scanTask() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        // 不要使用if作为wait的判定条件, 应该使用while
                        // 使用while的目的是为了在wait被唤醒的时候, 再次确定一下条件
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        // 比较一下看当前的队首元素是否可以执行了
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            // 当前时间已经到达了任务时间, 就可以执行任务了
                            task.getRunnable().run();
                            // 任务执行完了, 就可以从队列中剔除了
                            queue.poll();
                        } else {
                            locker.wait(task.getTime() - curTime);
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