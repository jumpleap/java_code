package thread;

import java.util.PriorityQueue;

/**
 * 任务
 */
class MyTimerTask implements Comparable<MyTimerTask> {
    //有一个要执行的任务
    private Runnable runnable;
    //执行任务的时间
    private long time;

    //此处的delay就散schedule中传入的"相对时间"
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }

    public long getTime() {
        return time;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}

/**
 * 定时器
 */
class MyTimer {
    //使用优先级队列,保存所有要安排的任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    //使用一个锁对象
    private Object locker = new Object();

    public MyTimer() {
        //创建扫描线程
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        //使用while的目的是为了在wait被唤醒的时候再确定一次,条件是否成立
                        while (queue.isEmpty()) {
                            //这里的wait由其他线程唤醒
                            locker.wait();
                        }
                        MyTimerTask task = queue.peek();
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            //当前时间已经到达了任务时间, 就可以执行任务了
                            task.getRunnable().run();
                            //任务执行完了, 就把这个任务从队列中删除
                            queue.poll();
                        } else {
                            //当前时间还没有到任务时间,暂时不结束任务
                            //等待到执行时间
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    /**
     * 要执行的任务
     */
    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();
        }
    }
}

public class Demo5 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);
    }
}
