package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池的使用方式
public class Demo1 {
    public static void main(String[] args) {
        // 创建含有5个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程启动!");
            }
        });
    }
}
