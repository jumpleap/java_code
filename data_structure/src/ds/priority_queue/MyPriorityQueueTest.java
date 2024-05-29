package ds.priority_queue;

public class MyPriorityQueueTest {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        // 初始化
        queue.init();
        // 创建堆
        queue.createHeap();
        queue.display();

        // 入堆
        queue.offer(12);
        queue.offer(123);
        queue.display();

        // 出堆
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.display();

        // 排序
        queue.heapSort();
        queue.display();
    }
}
