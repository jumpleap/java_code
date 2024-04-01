package thread.simple;

// 线程 -- sleep(线程休眠)
// 线程休眠: 该时间不一定准确, 因为调用sleep方法也需要额外的开销
// 注: 在线程中断中, 使用interrupted()方法可以打断线程的休眠

public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        long curTime = System.currentTimeMillis();
        // 休眠1s
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间: " + (endTime - curTime));
    }
}
