package ds.sort;

import java.util.Random;

// 排序
public class SimpleSort {
    // 构造一个随机数组，用于排序
    public int[] getArray() {
        int[] arr = new int[10];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            // 1 - 100的随机值
            arr[i] = random.nextInt(100) + 1;
        }
        // 返回数组
        return arr;
    }


    /**
     * 插入排序
     * 思想：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 最坏时间复杂度：O(N^2)  最好时间复杂度：O(N)【数组完全有序的时候】
     * 空间复杂度：O(1)
     * 是否稳定：稳定
     * 注: 一个本身就是稳定的排序, 是可以实现为不稳定的排序的; 一个本身不稳定的排序, 是不可能实现稳定的排序的
     */
    public void insertSort(int[] arr) {
        // 判空
        if (arr == null) return;

        for (int i = 1; i < arr.length; i++) {
            // 当前要插入的元素
            int key = arr[i];
            // 获取j下标
            int j = i - 1;
            // 用key和i之前的下标进行比较，i之前的已经有序
            // 若已有序的值大于比较值，那么将有序值不大于比较值后面的值右移
            while (j >= 0 && arr[j] > key) {
                // 一直将数组后移到有序值中没有值大于比较值
                arr[j + 1] = arr[j];
                j--;
            }
            // 放到要插入的位置
            arr[j + 1] = key;
        }
    }


    /**
     * 希尔排序
     * 思想：将原始数据分组再进行排序，逐步减小间隔以达到整个序列基本有序，最后再进行一次直接插入排序完成排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(1)
     * 是否稳定：不稳定
     */
    public void shellSort(int[] arr) {
        // 判空
        if (arr == null) return;

        // 获取数组长度，根据数组长度进行分组
        int gap = arr.length;
        while (gap > 1) {
            // 进行分组
            gap /= 2;
            // 根据分组进行排序
            shell(arr, gap);
        }
    }

    private void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i += gap) {
            int key = arr[i];

            int j = i - gap;
            // 查找要插入的位置
            while (j >= 0 && arr[j] > key) {
                // 把元素后移
                arr[j + gap] = arr[j];
                j -= gap;
            }
            // 把要插入的值放入到正确的位置
            arr[j + gap] = key;
        }
    }


    /**
     * 冒泡排序
     * 思想：重复地遍历要排序的数列，一次比较两个元素，如果它们的大小顺序错误就把它们交换过来，直到没有再需要交换的元素为止
     * 最坏时间复杂度：O(N^2) 【数组完全逆序时】  最好时间复杂度：O(N) 【数组完全有序时】
     * 空间复杂度：O(1)
     * 是否稳定：稳定
     */
    public void bubbleSort(int[] arr) {
        // 判空
        if (arr == null) return;

        for (int i = 0; i < arr.length - 1; i++) {
            // 进行优化
            boolean flag = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 数据两两比较，大的数据往后移，小的数据往前移
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }

            // 判断这一次有没有交换，无交换说明有序
            if (!flag) break;
        }
    }

    // 交换
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 选择排序
     * 思想：在未排序的序列中找到最小（或最大）的元素，存放到排序序列的起始位置，
     *      然后再从剩余未排序的元素中继续寻找最小（或最大）元素，然后放到已排序序列的末尾。
     * 最坏时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 是否稳定：不稳定
     */
    public void selectInsert(int[] arr) {
        // 判空
        if (arr == null) return;

        for (int i = 0; i < arr.length - 1; i++) {
            // 假定当前的下标是最小值的下标
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                // 获取最小值的下标
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 将最小值和i对应的值进行交换
            // 防止原地交换
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }


    /**
     * 计数排序
     * 思想：使用一个额外的数组来计算每个值的出现次数，然后根据这些计数将所有元素放到正确的位置上
     * 最坏时间复杂度：O(N+K) N: 数组长度  K:数据输入范围
     * 空间复杂度：O(K) K: 大小为K的数组
     * 是否稳定：稳定
     */
    public void countSort(int[] arr) {
        // 判空
        if (arr == null) return;

        // 找到最大值和最小值，然后申请数组空间
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int[] tmpArr = new int[max - min + 1];

        // 统计每个元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            // 映射到下标
            tmpArr[arr[i] - min]++;
        }

        // 把计数数组中的值重新赋给arr数组
        int index = 0;
        for (int i = 0; i < tmpArr.length; i++) {
            // 防止当前元素有多个
            while (tmpArr[i] > 0) {
                arr[index++] = i + min;
                // 防止有多个数
                tmpArr[i]--;
            }
        }
    }


    /**
     * 堆排序
     * 思想：堆排序是一种基于比较的排序算法，它利用了完全二叉树的特性，特别是最大堆或最小堆的性质来排序数据。
     *      堆排序包括两个主要步骤：构建堆和调整堆。
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(1)
     * 是否稳定：不稳定
     */
    public void heapSort(int[] arr) {
        // 判空
        if (arr == null) return;

        // 建堆
        createHeap(arr);

        // 进行堆排序
        int length = arr.length - 1;
        while (length > 0) {
            // 把最大值放到最后面
            swap(arr, 0, length);
            // 向下调整，重新获取最大值
            siftDown(arr, 0, length);
            // 下一个元素
            length--;
        }
    }

    // 建堆
    private void createHeap(int[] arr) {
        for(int parent = (arr.length - 1 - 1) / 2; parent >= 0; parent--) {
            // 向下调整
            siftDown(arr,parent, arr.length);
        }
    }

    // 向下调整建立大根堆
    private void siftDown(int[] arr, int parent, int length) {
        // 获取左孩子
        int child = parent * 2 + 1;

        while (child < length) {
            // 判断是否存在右孩子，存在的话，判断那个大
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            // 这个地方已经获取到了值最大的孩子

            // 这个地方判断孩子节点是否比父节点大
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
                // 继续判断后面的孩子节点
                parent = child;
                child = parent * 2 + 1;
            } else {
                // 说明已经是大根堆了
                break;
            }
        }
    }

}
