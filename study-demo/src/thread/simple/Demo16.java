package thread.simple;

// synchronized的使用
public class Demo16 {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.increase();
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.increase();
            }
        });

        // 创建线程并执行任务
        thread.start();
        thread1.start();

        // 添加join方法, 让main线程进行阻塞等待
        thread.join();
        thread1.join();

        // 结果正确
        System.out.println(count.getCount());
    }
}

class Count {
    private int count = 0;

    // synchronized修饰实例方法
    public synchronized void increase() {
        count++;
    }

    // 与上述代码等价
    public void increase2() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    private static int count2 = 0;

    // synchronized修饰静态方法
    public synchronized static void increase3() {
        count2++;
    }

    public static void increase4() {
        synchronized (Count.class) {
            count2++;
        }
    }

}