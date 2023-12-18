package thread;

// 线程休眠
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 线程进行休眠1s
        Thread.sleep(1000);
        long end = System.currentTimeMillis();

        // 查看差距是否为1s

        System.out.println((end - start) + "ms");
    }
}
