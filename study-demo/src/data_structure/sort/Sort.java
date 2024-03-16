package data_structure.sort;

import java.util.Random;

// 常见排序实现
public class Sort {

    /**
     * 创建一个数组
     */
    public int[] createArray() {
        // 为了设置随机数
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            // 给数组中值进行赋值
            array[i] = random.nextInt(100);
        }
        // 返回
        return array;
    }

    /**
     * 插入排序
     * 思想: 使用当前数据, 和之前已经排序好的数据进行比较, 从后往前进行比较, 找到插入的位置进行插入
     * 时间复杂度:
     * 最后情况: 数据完全有序的时候 -> O(N)
     * 最坏情况: 数据完全无序的时候 -> O(N^2)
     * 注: 当所给数据越有序排序越快
     * 空间复杂度: O(1)
     * 稳定性: 稳定
     * 注: 一个本身就是稳定的排序, 是可以实现为不稳定的排序的; 一个本身不稳定的排序, 是不可能实现稳定的排序的
     *
     * @param array
     */
    public void insertSort(int[] array) {
        // 从1开始, 因为只有一个数据不需要排序
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            // 获取当前索引的前一个索引
            int j = i - 1;
            // 使用当前数据和前面已排序的数据进行比较
            for (; j >= 0; j--) {
                // 若j索引的值大于待排序的值, 则把该索引的值后移, 一直到tmp的值大于j索引的值为止
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    // 当tmp的值比array[j]的值大, 则说明当前位置就是tmp插入位置
                    break;
                }
            }
            // 在退出循环后, j的值为待插入位置-1, 需要把tmp赋值给该索引
            array[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序
     * 思想: 将待排序数据进行分组, 每组进行直接插入排序, 每组都有序后, 再进行整体数据进行插入排序
     * 时间复杂度: O(N^1.3 ~ N^1.5)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     *
     * @param array
     */
    public void shellSort(int[] array) {
        // 获取数组长度, 用于分组
        int gap = array.length;
        while (gap > 1) {
            // 进行分组排序
            gap /= 2;
            // 进行排序
            shell(array, gap);
        }
    }

    private void shell(int[] array, int gap) {
        // 从 gap 开始排序
        for (int i = gap; i < array.length; i++) {
            // 获取待排序的值
            int tmp = array[i];
            // 获取已排序的下标
            int j = i - gap;

            // 用待排序的值和已排序的值进行比较
            for (; j >= 0; j -= gap) {
                // 待排序值 小于 已排序值, 当前已排序值后移
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    // 跳出循环, 则说明待排序值大于当前已排序值
                    break;
                }
            }
            // 把待排序值插入到当前已排序值的后一个, 因为当前待排序值大于已排序值
            // 可能当前待排序值是最大的一个, 跳出循环后, 插入在已排序序列的最后一个位置
            // 可能当前待排序值是最小的一个, 跳出循环后, 插入在已排序序列的第一个位置
            array[j + gap] = tmp;
        }
    }

    /**
     * 选择排序
     * 思想: 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     *
     * @param array
     */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 用于记录最小值的下标
            int minIndex = i;
            // 从 i 的后一个下标开始进行遍历, 寻找比 array[i]小的值, 记录下标
            for (int j = i + 1; j < array.length; j++) {
                // 找到最小值的下标, 赋给minIndex
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换数据
            swap(array, minIndex, i);
        }
    }

    /**
     * 交换数据
     */
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 冒泡排序
     * 思想: 通过对待排序序列从前向后依次对相邻两个元素进行两两比较, 若发现逆序则交换, 大的值往后面移.
     * 时间复杂度: O(N^2) 加了优化最后O(N)
     * 空间复杂度: O(1)
     * 稳定性: 稳定
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 优化标志
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 进行两两比较
                if (array[j] > array[j + 1]) {
                    // 交换数据
                    swap(array, j, j + 1);
                    // 进行交换则说明这一趟不是有序的
                    flag = true;
                }
            }
            // 有序了, 跳出循环
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public void heapSort(int[] array) {
        // 创建大根堆
        createBigHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            siftDown(array, 0, end);
            end--;
        }
    }

    // 创建大根堆
    private void createBigHeap(int[] array) {
        int len = array.length;

        for (int parent = (len - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(array, parent, len);
        }
    }

    // 向下调整
    private void siftDown(int[] array, int parent, int end) {
        int child = parent * 2 + 1;
        while (child < end) {
            if (child + 1 < end && array[child] < array[child + 1]) {
                child++;
            }

            if (array[parent] < array[child]) {
                swap(array, parent, child);
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }
}
