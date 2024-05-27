package ds.queue;

import java.util.LinkedList;
import java.util.Queue;

// 队列的使用
public class Demo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue.isEmpty());

        System.out.println(queue.size());
    }
}
