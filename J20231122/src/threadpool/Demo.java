package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池的基本使用
public class Demo {
    public static void main(String[] args) {
        // 线程的数目能够动态适应
        ExecutorService service = Executors.newCachedThreadPool();
        // 线程的数目是固定的
        ExecutorService service1 = Executors.newFixedThreadPool(4);
        // 只创建一个线程
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        // 定时器, 有多个线程进行扫描
        ExecutorService service3 = Executors.newScheduledThreadPool(4);

        // 使用submit方法进行添加任务
        while (true) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务");
                }
            });
        }
    }
}
