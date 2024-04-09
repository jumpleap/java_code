package data_structure.heap;


import java.util.Arrays;

// 用堆模拟实现优先级队列
public class MyPriorityQueue {
    // 底层数组
    private int[] elem;
    // 数组有效元素个数
    private int usedSize;
    // 底层数组默认大小
    private final static int DEFAULT_CAPACITY = 10;

    // 构造器
    public MyPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public MyPriorityQueue(int capacity) {
        this.elem = new int[capacity];
    }

    // 初始化堆
    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 把array数组中的值赋给elem数组
            elem[i] = array[i];
            usedSize++;
        }
    }

    // 创建堆
    public void createHeap() {
        // 注: usedSize - 1 - 1: 第一个-1是得到有效元素个数, 因为usedSize添加元素后, 已经往后增1
        // 注: usedSize - 1 - 1: 第二个-1是获取父节点, 获取父节点的操作: (child - 1) / 2
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            // 对堆中的节点进行向下调整
            shiftDown(parent, usedSize);
        }
    }

    // 堆的向下调整, 让堆变为大根堆/小根堆
    private void shiftDown(int parent, int usedSize) {
        // 获取左孩子下标
        int child = 2 * parent + 1;

        // 判断左孩子下标是否超过数组有效长度, 超过则无法进入循环
        while (child < usedSize) {
            // 判断右孩子是否存在, 且右孩子的值大于左孩子
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                // 让child从左孩子的下标自增到右孩子的下标
                child++;
            }
            // 到这个地方, child是左右孩子中最大值的下标

            // 判断孩子的值是否大于父节点的值
            // 建立大根堆, 孩子节点的值大于父节点的值即交换
            if (elem[child] > elem[parent]) {
                // 交换父节点的值和孩子的值
                swap(child, parent);
                // 继续判断孩子下面的节点
                parent = child;
                child = 2 * parent + 1;
            } else {
                // 已经是大根堆了
                break;
            }
        }
    }

    // 交换
    private void swap(int child, int parent) {
        int tmp = elem[child];
        elem[child] = elem[parent];
        elem[parent] = tmp;
    }

    // 入元素
    public void offer(int val) {
        // 判满
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        // 添加到最后一个元素
        this.elem[usedSize] = val;
        // 向上调整
        shiftUp(usedSize);
        usedSize++;

    }

    // 判断数组是否满了
    private boolean isFull() {
        return this.usedSize == elem.length;
    }

    // 向上调整
    private void shiftUp(int child) {
        // 获取父节点的下标
        int parent = (child - 1) / 2;

        // 一直调整到最后一个父节点为止
        while (child > 0) {
            // 孩子节点的值大于父节点的值, 进行交换
            if(elem[child] > elem[parent]) {
                swap(child, parent);
                // 继续进行下一个父节点的判断
                child = parent;
                parent = (child - 1) / 2;
            } else {
                // 说明堆中的数据已符合大/小根堆的规则
                break;
            }
        }
    }

    // 出元素
    public int poll() {
        // 获取队头元素
        int tmp = elem[0];
        // 把0和最后一个值进行交换
        swap(0, usedSize-1);
        // 有效长度自减
        usedSize--;
        // 又从队头元素开始进行向下调整
        shiftDown(0, usedSize);
        return tmp;
    }

    // 堆排序
    public void headSort() {
        // 获取最后一个下标的位置
        int end = usedSize - 1;
        // 对每个数进行排序
        // 每次的end减一次, 那么就会把最大的一个数放在最后的位置
        while (end > 0) {
            // 交换首尾下标的值
            swap(0, end);
            // 进行向下调整
            shiftDown(0, end);
            // 进行下一个数的排序
            end--;
        }
    }

    // 打印代码
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}
