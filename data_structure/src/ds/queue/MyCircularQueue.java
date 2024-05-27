package ds.queue;

public class MyCircularQueue {
    private int[] elem;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        elem = new int[k + 1];
    }
    
    public boolean enQueue(int value) {
        // 满了
        if (isFull()) return false;

        // 把元素插入
        elem[tail] = value;
        tail = (tail + 1) % elem.length;
        return true;

    }
    
    public boolean deQueue() {
        // 判空
        if(isEmpty()) return false;

        head = (head + 1) % elem.length;
        return true;

    }
    
    public int Front() {
        // 判空
        if (isEmpty()) return -1;

        return elem[head];
    }
    
    public int Rear() {
        // 判空
        if (isEmpty()) return -1;

        // 这个地方表示index重置到0的情况
        int index = (tail - 1 + elem.length) % elem.length;
        return elem[index];
    }
    
    public boolean isEmpty() {
        // head 和tail处于同一位置，表示队列为空
        return head == tail;
    }
    
    public boolean isFull() {
        // tail + 1 == head -> 队列满了
        return (tail + 1) % elem.length == head;
    }
}