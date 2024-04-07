package ee_basic.thread.simple;

// 线程 -- 线程中断
// 法一: 设计共享标记位, 作为run方法结束的判断标志
public class Demo8 {
    // 共享标记位
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 中断处
            while (!isQuit) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程工作完毕");
        });

        thread.start();
        Thread.sleep(5000);

        // 标记位更新
        isQuit = true;
        System.out.println("isQuit设置为true");
    }
}
