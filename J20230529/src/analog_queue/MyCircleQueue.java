package analog_queue;

/**
 * 留一个空间的循环队列
 */
public class MyCircleQueue {
    private int[] elem;

    private int front;//队头
    private int rear;//队尾

    public MyCircleQueue(int k) {
        this.elem = new int[k + 1];
    }

    /**
     * 操作方法
     */

    /**
     * 入队
     */
    public boolean enQueue(int value) {
        //判满
        if (isFull()) {
            return false;
        }
        this.elem[rear] = value;
        //队尾往后走
        rear = (rear + 1) % this.elem.length;
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
        //队头往前走
        front = (front + 1) % this.elem.length;
        return true;
    }

    /**
     * 队头元素
     */
    public int Front() {
        //判空
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    /**
     * 队尾元素
     */
    public int Rear() {
        //判空
        if (isEmpty()) {
            return -1;
        }
        //判断rear是不是首下标元素
        int index = (rear == 0) ? this.elem.length - 1 : rear - 1;
        return this.elem[index];
    }

    /**
     * 空队
     */
    private boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     */
    private boolean isFull() {
        return (rear + 1) % this.elem.length == front;
    }
}