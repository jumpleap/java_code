package test;

import java.util.PriorityQueue;

// 定时器
public class MyTimer {
    // 定义优先级队列, 该队列存放要执行的任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 定义锁对象
    private final Object locker = new Object();

    public MyTimer() {
        // 创建扫描队列, 用于执行任务
        scanTask();
    }

    // 实现schedule方法, 用于存放任务到队列值
    public void schedule(Runnable runnable, long delay) {
        // 防止传入的时间是负数
        if (delay < 0) {
            System.out.println("任务待执行的时间不能为负数!!!");
            return;
        }
        // 两个线程对同一个队列进行操作, 进行加锁
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            // 当扫描线程中没有任务可执行后, 进行阻塞, 这个地方加入任务后唤醒
            locker.notify();
        }
    }

    // 扫描队列执行任务
    private void scanTask() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        // 当队列为空, 进行阻塞等待
                        // 什么时候唤醒这个线程, 等到另一个线程添加任务的时候唤醒
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        // 队列不为空, 获取队首任务
                        MyTimerTask task = queue.peek();

                        // 判断当前时间是否大于队首任务时间. 超过了则需要执行任务
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            // 执行队首任务
                            task.getRunnable().run();
                            // 执行完后需要把队首任务出队
                            queue.poll();
                        } else {
                            // 执行任务时间没到,让队首任务进行阻塞等待
                            // 直到等待时间到了或有新任务进队列后才进行唤醒
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 创建并执行线程, 调用内核中的run方法
        t.start();
    }
}