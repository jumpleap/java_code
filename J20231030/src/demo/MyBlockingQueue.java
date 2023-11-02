package demo;

public class MyBlockingQueue<T> {
    private volatile int head; //头
    private volatile int tail; //尾
    private volatile int usedSize; //元素个数
    private static final int DEFAULT_CAPACITY = 10; //数组默认长度

    private Object[] elem;

    public MyBlockingQueue() {
        this.elem = new Object[DEFAULT_CAPACITY];
    }

    public MyBlockingQueue(int size) {
        this.elem = new Object[size];
    }

    public void put(T val) throws InterruptedException {
        synchronized (this) {
            //判断数组是否满了
            while (usedSize == elem.length) {
                this.wait();
            }

            //把val赋给tail处的位置, 并使tail后移
            this.elem[tail++] = val;
            //循环队列, 若是已经到了数组最后一个位置, 进行重置
            if (tail == elem.length) {
                tail = 0;
            }
            usedSize++;
            //这个notify用于唤醒take中wait
            this.notify();
        }
    }

    public T take() throws InterruptedException {
        synchronized (this) {
            //判空
            while (usedSize == 0) {
                this.wait();
            }

            //把要删除的元素赋给old并让head后移
            T old = (T) this.elem[head++];
            //循环队列, 若是已经到了数组最后一个位置, 进行重置
            if (head == elem.length) {
                head = 0;
            }
            usedSize--;
            //这个notify用于唤醒put中的wait
            this.notify();
            return old;
        }
    }
}