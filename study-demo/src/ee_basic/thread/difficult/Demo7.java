package ee_basic.thread.difficult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池的使用
public class Demo7 {
    public static void main(String[] args) {
        // 创建线程是动态适应的
        ExecutorService service = Executors.newCachedThreadPool();
        // 创建的线程是固定的
        ExecutorService service1 = Executors.newFixedThreadPool(5);
        // 创建只含一个线程的线程池
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        // submit方法用于提交任务
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });
    }
}
