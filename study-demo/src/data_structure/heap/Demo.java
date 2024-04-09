package data_structure.heap;

import java.util.PriorityQueue;

// 优先级队列的常用方法
public class Demo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 添加元素
        queue.offer(1);
        queue.offer(3);
        queue.offer(0);
        queue.offer(2);
        System.out.println(queue);

        // 弹出队头元素
        System.out.println(queue.poll());

        // 队列的长度
        System.out.println(queue.size());

        // 获取队头元素
        System.out.println(queue.peek());

        // 判断队列是否为空
        System.out.println(queue.isEmpty());
    }
}
