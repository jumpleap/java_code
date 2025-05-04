package data_structure.queue;

/**
 * @Author 林沐雨
 * @Date 2025/5/4
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.getSize());
    }
}
