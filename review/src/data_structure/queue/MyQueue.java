package data_structure.queue;

import java.util.Arrays;

/**
 * @Author 林沐雨
 * @Date 2025/4/30
 * @Description 链式实现队列
 */
public class MyQueue {
    static class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    // 入队
    public void offer(int val) {
        Node node = new Node(val);
        if (head == null) {
            size++;
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    // 出队
    public int poll() {
        if (tail == null) return -1;
        int oldVal = tail.val;
        // 只有一个节点的情况
        if (head == tail) {
            size--;
            head = tail = null;
            return oldVal;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
        return oldVal;
    }

    // 获取队顶元素
    public int peek() {
        if (head == null) return -1;
        return tail.val;
    }

    // 元素个数
    public int getSize() {
        return size;
    }

    // 打印
    public void display() {
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

    // 判空
    public boolean isEmpty() {
        return size == 0;
    }
}
