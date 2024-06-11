package ee.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 创建线程 -- 线程池
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        // 初始化线程池
        ExecutorService service = Executors.newCachedThreadPool();

        // 创建线程
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 启动！");
            }
        });

        Thread.sleep(1000);
        System.out.println("main 启动！");
    }
}
