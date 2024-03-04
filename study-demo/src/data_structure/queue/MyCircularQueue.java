package data_structure.queue;

// 循环队列实现
public class MyCircularQueue {
    // 底层数组
    private int[] elem;
    // 队头下标
    private int front;
    // 队尾下标
    private int rear;

    // 初始化
    public MyCircularQueue(int length) {
        // 留一个空间来进行判断队列是否满了
        this.elem = new int[length + 1];
    }

    /**
     * 入队
     */
    public boolean offer(int value) {
        // 判满
        if (isFull()) {
            return false;
        }
        // 把元素放在队尾处
        this.elem[rear] = value;
        // 让rear后移一位
        rear = (rear + 1) % this.elem.length;
        return true;
    }

    /**
     * 判断队列是否满了
     */
    private boolean isFull() {
        return ((rear + 1) % elem.length == front);
    }

    /**
     * 出队
     */
    public boolean poll() {
        // 判空
        if (isEmpty()) {
            return false;
        }
        // 队头后移一位
        front = (front + 1) % this.elem.length;
        return true;
    }

    /**
     * 判空
     */
    private boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 获取队头元素
     */
    public int front() {
        // 判空
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    /**
     * 获取队尾元素
     */
    public int rear() {
        // 判空
        if (isEmpty()) return -1;

        // rear在0的时候需要考虑特殊情况
        if (rear == 0) {
            return this.elem[elem.length - 1];
        }
        return this.elem[rear - 1];
        // 另一种方法: 防止了rear在0的时候值的获取
        // int index = (rear - 1 + elements.length) % elements.length;
    }

    /**
     * 获取数组长度
     */
    public int size() {
        return (rear + elem.length - front) % elem.length;
    }
}
