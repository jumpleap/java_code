package ds.priority_queue;

import java.util.PriorityQueue;

// 优先级队列的使用
public class Demo {
    public static void main(String[] args) {
        // 创建小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });

        // 创建大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });


        // 入堆
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);

        // 出堆
        System.out.println(queue.poll());
    }
}
