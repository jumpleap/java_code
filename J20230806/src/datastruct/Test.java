package datastruct;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    /**
     * 双端队列的基本使用
     * @param args
     */
    public static void main(String[] args) {
        //双端队列的线性实现
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(1);
        stack.offer(12);
        stack.offer(11);
        System.out.println(stack);

        System.out.println(stack.poll());
        System.out.println(stack.offerFirst(13));
        stack.offerLast(15);
        System.out.println(stack);

        stack.pollFirst();
        stack.pollLast();
        System.out.println(stack);

        //双端队列的链式实现
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(12);
        deque.offer(21);
        deque.offer(123);
        System.out.println(deque);

        deque.offerLast(124);
        deque.offerFirst(156);
        System.out.println(deque);
        System.out.println(deque.peek());
    }

    public static void main2(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
    }

    /**
     * 普通队列的方法了解
     * @param args
     */
    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);

        queue.poll();
        queue.poll();
        System.out.println(queue);

        System.out.println(queue.peek());
    }
}