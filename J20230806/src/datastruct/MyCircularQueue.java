package datastruct;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，
 * 其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，
 * 一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 */
class MyCircularQueue {
    private int[] elements;
    private int front;//队头
    private int rear;//队尾

    public MyCircularQueue(int k) {
        //留一个空间来进行判断队列是否满了
        elements = new int[k + 1];
    }

    /**
     * 入队
     */
    public boolean enQueue(int value) {
        //判满
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        //rear往后移
        rear = (rear + 1) % elements.length;
        return true;
    }

    /**
     * 出队
     */
    public boolean deQueue() {
        //判空
        if (isEmpty()) {
            return false;
        }
        //front往后移
        front = (front + 1) % elements.length;
        return true;
    }

    /**
     * 获取队头元素
     */
    public int Front() {
        //判空
        if (isEmpty()) {
            return -1;
        }
        //返回队头元素
        return elements[front];
    }

    /**
     * 获取队尾元素
     * 注：需要判断rear为0的时候的特殊情况
     */
    public int Rear() {
        //判空
        if (isEmpty()) {
            return -1;
        }
        //防止了rear=0的特殊情况
        int index = (rear - 1 + elements.length) % elements.length;
        return elements[index];
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否满了
     */
    public boolean isFull() {
        return (rear + 1) % elements.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */