package ds.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 双端队列的使用
public class DequeDemo {
    public static void main(String[] args) {
        // 双端队列的链式实现
        Deque<Integer> deque = new LinkedList<>();
        // 双端队列的线性实现
        Deque<Integer> deque1 = new ArrayDeque<>();

        deque.offer(1);
        deque.offer(3);
        deque.offer(2);
        System.out.println(deque);

        deque.offerFirst(0);
        System.out.println(deque);
        deque.offerLast(4);
        System.out.println(deque);

        // 默认效果是pollFirst
        deque.poll();
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);

        deque.pollLast();
        System.out.println(deque);

        System.out.println(deque.contains(3));

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        System.out.println(deque.peek());
    }
}
