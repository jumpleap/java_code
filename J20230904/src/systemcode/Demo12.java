package systemcode;

/**
 * sleep的使用 - sleep的调用是有消耗的
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("thread调用的时间：" + (end - begin) + "ms");
    }
}
