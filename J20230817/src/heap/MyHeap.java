package heap;

import java.util.Arrays;

/**
 * 堆模拟实现 --> 优先级队列
 */
public class MyHeap {
    private int[] elem;
    private int usedSize;//记录有效值的下标

    public MyHeap() {
        this.elem = new int[10];
    }


    /**
     * 给数组进行初始化
     * @param array 给定数组
     */
    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            usedSize++;
        }
    }

    /**
     * 创建堆
     * 时间复杂度：O(n)
     */
    public void createHeap() {
        //parent从最后一颗子树的根节点开始调整
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            //进行向下调整
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 向下调整
     * @param parent 给定的父节点
     * @param usedSize 给定的子节点
     */
    private void shiftDown(int parent, int usedSize) {
        //左孩子下标
        int child = (parent * 2) + 1;
        while (child < usedSize) {
            //比较左右孩子的大小
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                child++;
            }

            //判断孩子节点的值是否比父节点的值大
            if (elem[parent] < elem[child]) {
                //孩子节点的值大则交换
                swap(child, parent);
                //继续向下调整，防止树后面的节点中还有比根节点大的值
                parent = child;
                child = (parent * 2) + 1;
            } else {
                //父亲节点的值大，则说明当前的树已经调整好了
                break;
            }
        }
    }

    /**
     * 值的交换
     */
    private void swap(int child, int parent) {
        int tmp = elem[child];
        elem[child] = elem[parent];
        elem[parent] = tmp;
    }


    /**
     * 入堆 --> 入优先级队列
     * @param val 待入的值
     */
    public void offer(int val) {
        //判满
        if (isFull()) {
            this.elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        this.elem[usedSize] = val;
        //向上调整
        shiftUp(usedSize);
        usedSize++;
    }

    /**
     * 向上调整
     * @param child 孩子节点
     */
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;

        //child向上调整到0下标则说明调整结束
        while (child > 0) {
            //若parent的值比child的值小，则需要调整
            if (elem[parent] < elem[child]) {
                //交换两个值
                swap(parent, child);
                //继续向上调整
                child = parent;
                parent = (child - 1) / 2;
            } else {
                //说明已经调整好了
                break;
            }
        }
    }

    /**
     * 判断数组是否已满
     */
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 出堆 --> 出优先级队列的队头元素
     * @return 弹出队头元素
     */
    public int poll() {
        //判空
        if (usedSize == 0) {
            return -1;
        }
        //获取首元素
        int tmp = elem[0];
        //交换首尾元素的值
        swap(0, usedSize - 1);
        //删掉了首元素
        usedSize--;
        //从根节点开始向下调整
        shiftDown(0, usedSize);
        return tmp;
    }

    /**
     * 获取堆的首元素 --> 获取优先级队列的队头元素
     */
    public int peek() {
        //判空
        if (usedSize == 0) {
            return -1;
        }
        return elem[0];
    }

    /**
     * 堆排序 --> 优先级队列排序
     */
    public void heapSort() {
        //获取最后一个下标
        int end = usedSize - 1;
        while (end > 0) {
            //交换首尾元素
            swap(0, end);
            //向下调整进行排序
            shiftDown(0, end);
            end--;
        }
    }
}