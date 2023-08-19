package sort;

/**
 * 排序总结
 */
public class Sort {
    /**
     * 插入排序：使用当前的数字和前面的数字进行比较，找到相对应的位置插入进行
     * 时间复杂度：
     * 最好情况：数组完全有序 -> O(n)
     * 最坏情况：数组完全逆序 -> O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void insertSort(int[] array) {
        int length = array.length;

        if (length <= 1) {
            return;
        }

        for (int i = 1; i < length; i++) {
            int val = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //j下标对应的值和i下标进行比较，大于则把j下标的值后移一位
                if (array[j] > val) {
                    array[j + 1] = array[j];
                } else {
                    //若小于，则跳出循环
                    break;
                }
            }
            //把i的值插入到小于j的位置
            array[j + 1] = val;
        }
    }


    /**
     * 希尔排序：使用gap进行分组排序，当gap=1的时候，数组已经基本有序
     * 时间复杂度：O(n^1.3 ~ n^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        //分组(gap)进行排序
        while (gap > 1) {
            gap /= 2;
            shell(array, gap);
        }
    }

    private static void shell(int[] array, int gap) {
        int length = array.length;
        if (array.length <= 1) {
            return;
        }

        for (int i = gap; i < array.length; i++) {
            int val = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > val) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = val;
        }
    }


    /**
     * 选择排序：从第一个元素开始进行排序，遍历数组，查找数组中元素值最小的下标，和第一个元素进行比较，然后交换值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                //查找最小值的下标
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            //进行交换
            swap(array, minIndex, i);

        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 堆排序：交换首尾元素的值，使用向下调整
     * 时间复杂度：O(n*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void heapSort(int[] array) {
        createBigHeap(array);

        //获取最后一个元素的下标
        int end = array.length - 1;
        //当end到达第一个元素的位置，说明排序成功
        while (end > 0) {
            //交换首尾元素的值
            swap(array, 0, end);
            //向下调整
            siftDown(array, 0, end);
            end--;
        }
    }

    /**
     * 创建堆
     */
    private static void createBigHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            //向下调整
            siftDown(array, parent, array.length);
        }
    }

    /**
     * 向下调整堆
     */
    private static void siftDown(int[] array, int parent, int length) {
        int child = 2 * parent + 1;
        while (child < length) {
            //找到左右孩子最大的值
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            //当父节点的值小于孩子节点
            if (array[parent] < array[child]) {
                //交换父子节点的值
                swap(array, parent, child);
                //继续父节点的这棵树
                parent = child;
                child = 2 * parent + 1;
            } else {
                //说明父节点的这棵树已经是大根堆
                break;
            }
        }
    }


    /**
     * 冒泡排序：使用两两比较的方式进行排序，大的数字往后移，小的数字往前移动
     * 时间复杂度：
     * 最好情况：数组完全有序的情况 -> O(n)
     * 最坏情况：数组完全逆序的情况 -> O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //定义数组是否有序
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    swap(array, j, j + 1);
                }
            }
            //数组有序则跳出数组
            if (flag) {
                break;
            }
        }
    }
}