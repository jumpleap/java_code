package data_structure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 队列的使用 FIFO
public class Demo {
    public static void main(String[] args) {
        // 链队
        Queue<Integer> queue = new LinkedList<>();
        // 双端队列
        Queue<Integer> queue1 = new ArrayDeque<>();

        // 入队
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);

        // 出队
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // 队列的有效元素个数
        System.out.println(queue.size());
        // 队列的队头元素
        System.out.println(queue.peek());

        // 判断队列是否为空
        System.out.println(queue1.isEmpty());
    }
}
