package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池的创建方式
public class Demo2 {
    public static void main(String[] args) {
        // 创建线程数目动态增长的线程池
        ExecutorService poolOne = Executors.newCachedThreadPool();
        // 创建线程数目固定的线程池
        ExecutorService poolTwo = Executors.newFixedThreadPool(10);
        // 创建只含有一个线程的线程池
        ExecutorService poolThree = Executors.newSingleThreadExecutor();
        // 创建多个线程任执行务的定时器
        ExecutorService poolFour = Executors.newScheduledThreadPool(4);
    }
}
