package system_code;

/**
 * 线程的基本操作 -- sleep函数是有误差的
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("时间差 + " + (end - begin));
    }
}
