package ds.sort;

import java.util.Stack;

// 快速排序
public class QuickSort {

    /**
     * 快速排序
     * 思想：快速排序是一种高效的排序算法，采用分治法的策略。
     *      其基本思想是选择一个基准元素，通过一趟排序将待排序的记录分割成独立的两部分，
     *      其中一部分的所有数据都比另外一部分的所有数据要小，然后再按此方法对这两部分数据分别进行快速排序，
     *      整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * 最和时间复杂度：O(NlogN)  最坏时间复杂度：O(N^2)
     * 空间复杂度：O(logN)
     * 稳定性：不稳定
     */
    public void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private void quick(int[] arr, int left, int right) {
        // 当左节点的下标大于右节点的下标
        if (left >= right) return;

        // 若节点数过少，使用插入排序解决
        if (right - left + 1 <= 7) {
            insertSort(arr);
            return;
        }

        // 三数取中
        int index = midOfThree(arr, left, right);

        // 此时交换下标后，left的下标对应的值是中间大的数字
        swap(arr, left, index);

        // 获取基准
        int pivot = partitionOfHoare(arr, left, right);

        // 根据基准对数组进行划分
        // 左半部分
        quick(arr, left, pivot - 1);
        // 右半部分
        quick(arr, pivot + 1, right);
    }

    // 插入排序
    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] >= key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // 三数取中
    private int midOfThree(int[] arr, int left, int right) {
        // 中值下标
        int mid = (left + right) / 2;

        if (arr[left] < arr[right]) {
            if (arr[mid] < arr[left]) return left;
            if (arr[mid] > arr[right]) return right;
            return mid;
        } else {
            if (arr[mid] < arr[right]) return right;
            if (arr[mid] > arr[left]) return left;
            return mid;
        }
    }

    /**
     * 获取基准值 -- 挖坑法
     * 思想：固定最左边或者最右边的值作为基准值；
     *      从数组的右边开始查找比基准值小的值，把right找到的值填到left坑中；
     *      从数组的左边开始查找比基准值大的值，把left找到的值填到right的坑中；
     *      最后，把固定的基准值放到left的坑中，返回新的基准下标
     */
    public int partition(int[] arr, int left, int right) {
        int key = arr[left];

        while (left < right) {
            // 从右边开始找比基准小的值
            while (left < right && arr[right] >= key) {
                right--;
            }
            // 此时，right指向的值是比key小的值

            // 把比基准小的值填到left的坑中
            arr[left] = arr[right];

            // 从左边开始找比基准大的值
            while (left < right && arr[left] <= key) {
                left++;
            }
            // 此时，left指向的值是比key大的值

            // 把比基准大的值填到right的坑中
            arr[right] = arr[left];
        }

        // 此时，left的左边的值都比left小，left右边的值都比left大
        // 把最后一个坑填了， 最后返回新的基准下标
        arr[left] = key;
        return left;
    }

    /**
     * 获取基准值 -- Hoare法
     * 思想：选择最左边的值或最右边的值作为基准，记录当前基准的下标；
     *      从数组的右边开始查找比基准小的值，从数组的左边开始查找比基准大的值， 然后交换这两个值；
     *      当left和right相遇后，此时的left就作为新的基准【left左边的值都比left小，left右边的值都比left大】
     */
    private int partitionOfHoare(int[] arr, int left, int right) {
        // 选择最左边的值作为基准值
        int key = arr[left];
        // 保存当前基准的下标，后续需要交换
        int tmp = left;

        // 根据基准进行分区，把大的分在一边，小的分在一边
        while (left < right) {
            // 从右边找比基准值小的值
            while (left < right && arr[right] >= key) {
                right--;
            }
            // 此时right指向的值比key小

            // 从左边开始找比key大的值
            while (left < right && arr[left] <= key) {
                left++;
            }
            // 此时left指向的值是比key大的值

            // 交换left和right所指向的值
            swap(arr, left, right);
        }

        // 此时，left所处的位置：右边的值比left所指的值大，左边的值比left所指的值小
        // 此时，left作为新的基准
        swap(arr, tmp, left);
        // 返回基准下标
        return left;
    }

    // 交换
    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


    // 快排的非递归实现
    public void quickSortNor(int[] arr) {
        // 初始化栈
        Stack<Integer> stack = new Stack<>();

        int left = 0;
        int right = arr.length - 1;
        // 获取基准
        int pivot = partition(arr, left, right);

        // 入左半部分
        if (pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot - 1);
        }

        // 入右半部分
        if (pivot + 1 < right) {
            stack.push(pivot + 1);
            stack.push(right);
        }

        while (!stack.isEmpty()) {
            // 获取一部分的区间
            right = stack.pop();
            left = stack.pop();
            // 获取基准
            pivot = partition(arr, left, right);

            // 对这个部分继续进行两部分的划分
            // 左半部分
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }

            // 右半部分
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }
}
