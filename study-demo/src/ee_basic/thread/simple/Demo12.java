package ee_basic.thread.simple;

// 线程 -- 线程状态
public class Demo12 {
    public static void main(String[] args) {
        // 获取所有的线程状态
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }

        /*
            线程状态解释:
                NEW: Thread对象已存在，start()还没有调用
                RUNNABLE: 线程已经在CPU上执行了或线程正在排队等待上CPU执行
                TERMINATED: Thread对象还存在，内核中的线程不存在了
                BLOCKED(阻塞): 由锁竞争导致的阻塞
                WAITING(阻塞): 由wait这种不固定时间的方式产生的阻塞
                TIMED_WAITING(阻塞): 由sleep这种固定时间方式产生的阻塞
         */
    }
}
