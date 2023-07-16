package priority_queue;

import java.util.Arrays;

/**
 * 模拟实现优先级队列 —— 大根堆
 */
public class PriorityQueueMock {
    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_CAPACITY = 10;

    //构造器
    public PriorityQueueMock() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    public PriorityQueueMock(int initCapacity) {
        this.elem = new int[initCapacity];
    }


    /**
     * 向下调整为优先级队列 - 大根堆
     * @param parent   父母结点
     * @param usedSize 数组长度
     */
    private void shiftDown(int parent, int usedSize) {
        int child = parent * 2 + 1;//左孩子下标
        while (child < usedSize) {
            //判断最大值的下标是左孩子还是右孩子
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                child++;
            }
            //得到了最大值的下标
            if (elem[child] > elem[parent]) {
                swap(child, parent);//交换父母孩子的值
                //判断孩子结点的下面是否还有其他结点
                parent = child;
                child = parent * 2 + 1;
            } else {
                //已经是大根堆了
                break;
            }
        }
    }

    /**
     * 交换孩子父母结点的值
     * @param child  孩子结点
     * @param parent 父母结点
     */
    private void swap(int child, int parent) {
        int tmp = elem[child];
        elem[child] = elem[parent];
        elem[parent] = tmp;
    }

    /**
     * 入队
     * @param val 待入值
     */
    public void offer(int val) {
        //判断是否空间满了
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[usedSize] = val;
        shiftUp(usedSize);
        usedSize++;
    }

    /**
     * 判断数组是否满了
     * @return 返回布尔值
     */
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 向上调整
     * @param child 孩子结点
     */
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                swap(child, parent);//交换值
                //向上调整大根堆
                child = parent;
                parent = (child - 1) / 2;
            } else {
                //已经是大根堆了
                break;
            }
        }
    }

    /**
     * 出队
     * @return 返回删掉的元素
     */
    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int tmp = this.elem[0];//队头
        swap(0, usedSize - 1);//交换首尾值
        usedSize--;//删掉了队头
        shiftDown(0, usedSize);//重新进行向下调整
        return tmp;//返回删掉的值
    }

    /**
     * 获取队头元素不删除
     * @return 返回队头元素
     */
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }

    /**
     * 判断对是不是空
     * @return 返回布尔值
     */
    public boolean isEmpty() {
        return usedSize == 0;
    }
}