package thread;

// 线程的状态
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 在start之前获取的状态, 就是NEW状态
        System.out.println(thread.getState());

        thread.start();

        // 在线程执行过程中执行的状态, 是RUNNABLE状态
        System.out.println(thread.getState());

        thread.join();
        // 线程结束的状态, 就是TERMINATED状态
        System.out.println(thread.getState());
    }
}