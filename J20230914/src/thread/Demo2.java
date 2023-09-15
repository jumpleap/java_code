package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的基本使用
 */
public class Demo2 {
    public static void main(String[] args) {
        //创建一个线程池: 该线程池的线程数目是动态适应的
        ExecutorService service = Executors.newCachedThreadPool();
        //该线程池只能添加固定的线程数量
        ExecutorService service1 = Executors.newFixedThreadPool(4);
        //单个线程的线程池
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        //相当于定时器的线程池: 但是线程池中有多个线程执行即将到来的任务, 定时器中只有一个扫描线程
        ExecutorService service3 = Executors.newScheduledThreadPool(4);

        //往线程池中添加任务
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }
}
