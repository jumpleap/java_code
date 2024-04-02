package thread.difficult;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 阻塞队列的使用
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        queue.put(5);

        System.out.println(queue);

        System.out.println(queue.take());
        System.out.println(queue.take());

        System.out.println(queue.size());

        System.out.println(queue.peek());

        System.out.println(queue.contains(3));
    }
}
