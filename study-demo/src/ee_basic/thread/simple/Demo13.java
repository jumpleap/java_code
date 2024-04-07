package ee_basic.thread.simple;

// 线程 -- 线程状态的体现
// 使用getState()方法获取当前线程的状态
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // NEW: Thread对象, 但start还未调用
        System.out.println(thread.getState());

        thread.start();

        // RUNNABLE: 线程已经在CPU上执行了或线程正在排队等待上CPU执行
        System.out.println(thread.getState());

        Thread.sleep(4000);
        // TERMINATED: Thread对象还存在，内核中的线程不存在了
        System.out.println(thread.getState());
    }
}
