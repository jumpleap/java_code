package test;


// 这个类描述任务
public class MyTimerTask implements Comparable<MyTimerTask> {
    // 要执行的任务
    private Runnable runnable;
    // 任务被执行的时间
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        // 当前时间 + 待执行的时间 = 执行的时间
        this.time = System.currentTimeMillis() + delay;
    }

    // 这个方法用于比较时间, 为了后续拿到先执行任务的时间
    @Override
    public int compareTo(MyTimerTask o) {
        // 时间短的任务在前面
        return (int) (this.time - o.time);
        // 时间长的任务在前面
        // return (int) (o.time - this.time);
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }
}