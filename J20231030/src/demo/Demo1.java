package demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1 {
    public static void main(String[] args) {
        //BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        //t1线程作为生产者, 每0.5s生产一次
        Thread t1 = new Thread(() -> {
            int count = 1;//生产数字
            while (true) {
                try {
                    System.out.println("生产者生产了: " + count);
                    blockingQueue.put(count);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
            }
        });

        //t2线程作为消费者, 每1s消费一次
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费者消费了:" + blockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //启动线程
        t1.start();
        t2.start();
    }
}
