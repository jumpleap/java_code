package data_structure.queue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.display();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.display();

        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
