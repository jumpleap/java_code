package thread;

/**
 * Thread的方法 -- sleep的使用
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        //休眠1s
        //调用sleep方法的时候会有额外的开销
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println((end - begin) + " ms");
    }
}
