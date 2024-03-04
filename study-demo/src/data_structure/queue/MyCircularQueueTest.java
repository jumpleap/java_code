package data_structure.queue;

// 测试循环队列代码
public class MyCircularQueueTest {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        System.out.println(queue.size());

        queue.poll();
        queue.poll();
        queue.offer(10);
        queue.offer(11);
        queue.offer(12);
        System.out.println(queue.size());

        System.out.println(queue.front());
        System.out.println(queue.rear());

    }
}
