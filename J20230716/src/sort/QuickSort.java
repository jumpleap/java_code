package sort;

import java.util.Stack;

public class QuickSort {
    /**
     * 快速排序：递归法 - 框架
     *
     * @param array 待排序数组
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    /**
     * 未优化的版本
     */
    private static void quick1(int[] array, int left, int right) {
        //左边只有一个结点或没有结点的情况下
        if (left >= right) {
            return;
        }
        //基准值
        int div = partition(array, left, right);

        //分别对基准值的左右进行递归
        quick1(array, left, div);
        quick1(array, div + 1, right);
    }

    /**
     * 优化版本
     * 1）结点数低于限定值使用插入排序
     * 2）三数取中：获取中间大的元素下标给数组首下标的位置
     */
    private static void quick(int[] array, int left, int right) {
        //左边只有一个结点或没有结点的情况下
        if (left >= right) {
            return;
        }

        //当节点数在这个范围内的时候进行插入排序优化
        if (right - left + 1 <= 7) {
            //插入排序
            insertSortRange(array, left, right);
            return;
        }
        //三数取中
        int index = midOfThree(array, left, right);
        //保证了left下标的值一定是中间大的数字
        swap(array, left, index);
        //基准值
        int div = partition(array, left, right);

        //分别对基准值的左右进行递归
        quick(array, left, div);
        quick(array, div + 1, right);
    }

    /**
     * 三数取中
     */
    private static int midOfThree(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[mid] > array[left]) {
                return left;
            } else if (array[mid] < array[right]) {
                return right;
            } else {
                return mid;
            }
        }
    }

    /**
     * 插入排序[范围]
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
     * 法一：Hoare法
     */
    private static int partition1(int[] array, int left, int right) {
        int key = array[left];
        int tmp = left;

        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            //找到了比key小的值
            while (left < right && array[left] <= key) {
                left++;
            }
            //找到了比key大的值
            swap(array, left, right);
        }
        //最后交换一次基准值
        swap(array, tmp, left);
        return left;//基准下标返回
    }

    //交换
    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }


    /**
     * 法二：挖空法
     */
    private static int partition(int[] array, int left, int right) {
        int key = array[left];

        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            //找到了比key小的值
            array[left] = array[right];//填前面的小空

            while (left < right && array[left] <= key) {
                left++;
            }
            //找到了比key大的值
            array[right] = array[left];//填后面的大空
        }
        array[left] = key;//基准值
        return left;//返回基准下标
    }

    /**
     * 法三：左右指针法
     */
    private static int partition2(int[] array, int start, int end) {
        //左右指针
        int left = start;
        int right = end + 1;

        while(right <= end) {
            //找比基准大的值且左右指针的值不相同
            if(array[right] < array[start] && array[++left] != array[right]) {
                swap(array,left,right);
            }
            right++;
        }
        //交换基准值
        swap(array,start,left);
        return left;
    }

    /**
     * 快速排序的非递归版本
     */
    public static void quickSortNor(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        int div = partition(array,left,right);//基准

        //说明左边最起码有两个结点
        if(div - 1 > left) {
            stack.push(left);
            stack.push(div-1);
        }
        //说明右边最起码有两个结点
        if(div + 1 < right) {
            stack.push(div+1);
            stack.push(right);
        }

        while(!stack.isEmpty()) {
            //分区间排序
            right = stack.pop();
            left = stack.pop();

            //找新的基准
            div = partition(array,left,right);

            //再判断左右两边是否有两个及以上的结点
            if(div - 1 > left) {
                stack.push(left);
                stack.push(div-1);
            }
            if(div + 1 < right) {
                stack.push(div+1);
                stack.push(right);
            }
        }
    }
}