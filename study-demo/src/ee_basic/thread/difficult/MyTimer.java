package ee_basic.thread.difficult;

import java.util.PriorityQueue;

// 定时器的模拟实现
public class MyTimer {
    // 保存所有要执行的任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 创建锁对象
    private Object locker = new Object();

    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            // 往队列中添加任务
            queue.offer(new MyTimerTask(runnable, delay));
            // 唤醒队列为空的情况, 队列为空进行阻塞等待
            locker.notify();
        }
    }

    public MyTimer() {
        // 创建一个扫描线程
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        // 当队列为空时, 进行阻塞等待
                        while (queue.isEmpty()) {
                            locker.wait();
                        }

                        // 获取最早执行的任务
                        MyTimerTask task = queue.peek();
                        // 获取当前时间
                        long curTime = System.currentTimeMillis();
                        // 比较时间
                        if (curTime >= task.getTime()) {
                            // 时间到了, 则说明执行当前任务, 并把当前任务踢出队列
                            task.getTask().run();
                            queue.poll();
                        } else {
                            // 时间未到, 进行阻塞等待
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

class MyTimerTask implements Comparable<MyTimerTask>{
    // 要执行的任务
    private Runnable task;
    // 执行任务的时间
    private long time;

    // 传入要执行的任务和时间
    public MyTimerTask(Runnable runnable, long delay) {
        this.task = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        // 比较方式
        return (int)(this.time - o.time);
    }

    public Runnable getTask() {
        return task;
    }

    public long getTime() {
        return time;
    }
}

class Demo6 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(2000);
            }
        }, 2000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(1000);
            }
        }, 1000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(3000);
            }
        }, 3000);
    }
}