package thread;

// 判断线程是否存活
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程结束");
        });
        // 线程开始前判断
        System.out.println(thread.isAlive());

        thread.start();

        // 线程执行中判断
        System.out.println(thread.isAlive());

        Thread.sleep(6000);
        // 线程结束后判断
        System.out.println(thread.isAlive());
    }
}
