package ds.priority_queue;

import java.util.Arrays;
import java.util.Random;

// 优先级队列的模拟实现
public class MyPriorityQueue {
    // 底层数组
    private int[] elem;
    // 数组有效元素个数
    private int usedSize;
    // 数组默认大小
    private final static int DEFAULT_CAPACITY = 5;

    // 构造器
    public MyPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public MyPriorityQueue(int capacity) {
        this.elem = new int[capacity];
    }

    // 初始化底层数组
    public void init() {
        Random random = new Random();
        for (int i = 0; i < elem.length; i++) {
            elem[i] = random.nextInt(100);
            usedSize++;
        }
    }

    // 创建堆
    public void createHeap() {
        // usedSize - 1：指向最后一个节点
        // usedSize - 1 - 1： 为了获取父节点， 获取父节点的操作：(child - 1) / 2
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            // 对堆中的节点进行向下调整
            siftDown(parent, usedSize);
        }
    }

    // 堆的向下调整
    private void siftDown(int parent, int usedSize) {
        // 获取左孩子下标
        int child = parent * 2 + 1;

        // 判断左孩子的下标是否比数组的有效长度还长
        while (child < usedSize) {
            // 判断右孩子是否存在，且右孩子的值是否大于左孩子
            if (child + 1 < usedSize && elem[child] < elem[child + 1]) {
                child++;
            }

            // 到此，child此时的下标对应的值最大（即左右孩子中最大的那个）

            // 判断孩子节点的值是否大于父节点的值， 大于则交换两者的值
            if (elem[child] > elem[parent]) {
                // 交换父子节点的值
                swap(child, parent);
                // 继续判断孩子下面是否还有节点
                parent = child;
                child = parent * 2 + 1;
            } else {
                // 调整好了，此时已经是大根堆了
                break;
            }
        }
    }

    // 交换值
    private void swap(int child, int parent) {
        int tmp = elem[child];
        elem[child] = elem[parent];
        elem[parent] = tmp;
    }

    // 入堆
    public void offer(int val) {
        // 判满
        if (usedSize == elem.length) {
            this.elem = Arrays.copyOf(elem, elem.length * 2);
        }

        // 把值添加到最后一个节点
        elem[usedSize] = val;
        // 进行向上调整
        siftUp(usedSize);
        usedSize++;
    }

    // 向上调整
    private void siftUp(int child) {
        // 获取父节点的下标
        int parent = (child - 1) / 2;

        // 进行调整，调整到最后一个父节点为止
        while (child > 0) {
            // 孩子节点的值大于父节点的值，交换
            if (elem[child] > elem[parent]) {
                swap(child, parent);
                // 进行下一个父节点的判断
                child = parent;
                parent = (child - 1) / 2;
            } else {
                // 说明已经调整完了
                break;
            }
        }
    }

    // 出堆
    public int poll() {
        // 获取堆顶元素
        int val = elem[0];
        // 把0下标的值和最后一个下标的值进行交换
        swap(0, usedSize - 1);
        // 有效长度自减
        usedSize--;
        // 从0下标处开始进行向下调整
        siftDown(0, usedSize);
        return val;
    }

    // 堆排序
    public void heapSort() {
        // 获取最后一个下标的位置
        int end = usedSize - 1;

        // 对每个数进行排序
        // 每次的end自减一次，那么就会把未排序的最大值放到最后的节点处
        while(end > 0) {
            // 把最大值放到最后的节点处
            swap(0, end);
            // 然后进行向下调整
            siftDown(0, end);
            end--;
        }
    }


    // 打印
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}
