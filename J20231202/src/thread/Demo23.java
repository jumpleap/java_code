package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 阻塞队列的API使用
public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        // 数组形式
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // 链表形式
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        blockingQueue.put(123);
        blockingQueue.put(2);
        blockingQueue.put(4);
        blockingQueue.put(6);

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 当阻塞队列中没有元素后, 会进入阻塞状态, 直到有新元素进来
        System.out.println(blockingQueue.take());
    }
}