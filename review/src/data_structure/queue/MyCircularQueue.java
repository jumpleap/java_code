package data_structure.queue;

/**
 * @Author 林沐雨
 * @Date 2025/4/30
 * @Description 顺序结构实现队列
 */
public class MyCircularQueue {
    // https://leetcode.cn/problems/design-circular-queue/
    private int[] elem;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        elem = new int[k + 1];
    }

    // 想清楚谁是队头，谁是队尾，往后加则head是队头，往前加tail是队尾
    public boolean enQueue(int value) {
        if (isFull()) return false;
        elem[tail] = value;
        tail = (tail + 1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % elem.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return elem[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return elem[(tail - 1 + elem.length) % elem.length];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % elem.length == head;
    }
}

