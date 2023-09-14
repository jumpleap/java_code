package thread;

/**
 * 计时器的实现
 */

import java.util.PriorityQueue;
import java.util.TimerTask;

/**
 * 要做的任务
 */
class MyTimerTask implements Comparable<MyTimerTask> {
    //任务
    private Runnable runnable;
    //时间
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        //绝对时间
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }
}

/**
 * 计时器
 */
class MyTimer {
    //优先级队列
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    //添加锁对象
    private Object locker = new Object();

    //需要一个扫描线程
    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        //若是队列为空的时候还想取元素,进入阻塞等待, 等着schedule方法唤醒
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        //获取当前的系统时间
                        long curTime = System.currentTimeMillis();
                        //比较时间
                        if (curTime >= task.getTime()) {
                            //执行任务
                            task.getRunnable().run();
                            //删掉这个任务
                            queue.poll();
                        } else {
                            //阻塞等待
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

    //需要一个schedule方法
    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            //唤醒扫描线程中的wait并更新最近等待时间
            locker.notify();
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);
    }
}