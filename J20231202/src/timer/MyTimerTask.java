package timer;

// 任务类
public class MyTimerTask implements Comparable<MyTimerTask> {
    // 任务
    private Runnable runnable;
    // 时间, 时间一到, 就需要执行任务
    private long time;

    // 构造器构造出任务和时间
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = delay + System.currentTimeMillis();
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
