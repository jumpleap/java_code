package ds.queue;

public class MyCircularQueueTest {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue.Rear());

        System.out.println(queue.isFull());

        System.out.println(queue.deQueue());

        queue.enQueue(4);

        System.out.println(queue.Rear());
    }
}
