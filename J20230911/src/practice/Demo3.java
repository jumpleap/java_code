package practice;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序
 */
public class Demo3 {
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    /**
     * 快速排序
     */
    private static void quick(int[] array, int left, int right) {
        //left和right相遇或大于right: 只有一个节点或一个节点也没有
        if (left >= right) return;

        //优化为插入排序
        if (right - left + 1 <= 7) {
            //插入排序
            insertSortRange(array, left, right);
            return;
        }

        //三数取中
        int index = midOfThree(array, left, right);
        //交换基准值
        swap(array, index, left);

        //获取基准值
        int pivot = partition(array, left, right);

        //继续递归划分左右区间
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    /**
     * 插入排序
     */
    private static void insertSortRange(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= left; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 三数取中
     */
    private static int midOfThree(int[] array, int left, int right) {
        //中间值
        int mid = (left + right) / 2;
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[mid] < array[right]) {
                return right;
            } else if (array[mid] > array[left]) {
                return left;
            } else {
                return mid;
            }
        }
    }

    /**
     * Hoare法
     */
    private static int partition1(int[] array, int left, int right) {
        int key = array[left];
        int i = left;

        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            //找到了比key小的值
            while (left < right && array[left] <= key) {
                left++;
            }
            //找到了比key大的
            //交换
            swap(array, left, right);
        }
        //交换基准
        swap(array, i, left);
        //返回基准值
        return left;
    }

    /**
     * 挖空法
     */
    private static int partition(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            //找到了比key小的值

            //填空
            array[left] = array[right];

            while (left < right && array[left] <= key) {
                left++;
            }
            //找到比key大的值

            //填空
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }

    /**
     * 左右指针法
     */
    private static int partition2(int[] array, int left, int right) {
        int prev = left;
        int cur = left + 1;

        while (cur <= right) {
            //遇到比key小的值且prev自增后的值和cur相等,则交换值
            //遇到array[cur] > array[left]说明,cur++, prev停留
            if (array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array, cur, prev);
            }
            cur++;
        }
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    /**
     * 快速排序的非递归版本
     */
    public static void quickSortNor(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        //获取一次基准
        int pivot = partition(array, left, right);

        //若左边的值有两个以上
        if (pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot - 1);
        }

        //右边的值有两个以上
        if (pivot + 1 < right) {
            stack.push(pivot + 1);
            stack.push(right);
        }

        while (!stack.isEmpty()) {
            //弹出左右值,继续进行下一次的划分
            right = stack.pop();
            left = stack.pop();

            //若左边的值有两个以上
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }

            //右边的值有两个以上
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}