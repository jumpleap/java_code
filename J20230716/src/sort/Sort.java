package sort;

public class Sort {
    /**
     * 直接插入排序：用当前下标的元素值和前面下标的元素值进行比较，若大于/小于，则进行后移
     * 时间复杂度：
     * 最坏情况：数组完全有序的情况 -> O(n)
     * 最好情况：数组完全逆序的情况 -> O(n^2)
     * 空间复杂度：O(1) -> 无额外的空间使用
     * 稳定性：稳定
     *
     * @param array 待排序数组
     */
    public static void insertSort(int array[]) {
        int len = array.length;
        //从1下标开始和前面的数进行比较
        for (int i = 1; i < len; i++) {
            int tmp = array[i];//保存当前下标的值
            int j = i - 1;
            for (; j >= 0; j--) {
                //比tmp值大的数则右移
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    //跳出
                    break;
                }
            }
            //跳出循环的时候，j+1的位置即为插入tmp的位置
            array[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序：把待排的数据分为多组，然后每组间进行快快速排序
     * 时间复杂度：O(n^1.3 ~ n^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array 待排序数组
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            shell(array, gap);
        }
    }

    private static void shell(int[] array, int gap) {
        //这个地方相当于是插入排序:把小于tmp的值进行后移，这个地方是分组间的轮流转化
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    //元素后移
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;//插入的位置
        }
    }


    /**
     * 选择排序 - 法一
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array 待排序数组
     */
    public static void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                //找到值最小的下标
                if (array[j] < array[minIndex]) {
                    minIndex = j;//更新最小值下标
                }
            }
            //交换
            swap(array, minIndex, i);
        }
    }


    /**
     * 选择排序 - 法二
     */
    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            //找到最大值和最小值的下标
            for (int i = left + 1; i <= right; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            //交换最小值到前面去【注：第一个数可能为最大值】
            swap(array, left, minIndex);
            //特殊情况：最大值刚好在最小值的位置上，已经交换到了minIndex
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            //交换最大值到最后
            swap(array, right, maxIndex);

            left++;
            right--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 堆排序
     * 时间复杂度：O(n*log(n))
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array 待排序数组
     */
    public static void heapSort(int[] array) {
        createBigHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            //进行调整
            siftDown(array, 0, end);
            end--;
        }
    }

    //创建大根堆
    private static void createBigHeap(int[] array) {
        int len = array.length;
        for (int parent = (len - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(array, parent, len);
        }
    }

    //向下调整
    private static void siftDown(int[] array, int parent, int end) {
        int child = parent * 2 + 1;
        while (child < end) {
            if (child + 1 < end && array[child] < array[child + 1]) {
                child++;
            }
            //已经得到的大值的下标
            if (array[parent] < array[child]) {
                swap(array, parent, child);
                //孩子结点下面还有结点
                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }

    }


    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    swap(array, j + 1, j);
                }
            }
            //若是已经有序，直接跳出循环
            if (flag) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：
     * 最好情况：O(nlogn)
     * 最坏情况：O(n^2)
     * 空间复杂度：
     * 最好情况：O(logn)
     * 最坏情况：O(n)
     * 稳定性：不稳定
     *
     * @param array 待排序数组
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int start, int end) {
        //没有子节点或只有一个子节点的情况
        if (start >= end) {
            return;
        }
        //求中间值
        int pivot = partition(array, start, end);
        //递归左半部分
        quick(array, start, pivot - 1);
        //递归右半部分
        quick(array, pivot + 1, end);
    }

    private static int partition(int[] array, int left, int right) {
        int key = array[left];
        int i = left;//保存数组首元素的值
        while (left < right) {
            //找右边比key小的值
            while (left < right && array[right] >= key) {
                right--;
            }
            //找左边比key大的值
            while (left < right && array[left] <= key) {
                left++;
            }
            //交换
            swap(array, left, right);
        }
        //需要数组首元素和数组中间元素交换
        swap(array, left, i);
        return left;//返回中值
    }


    /**
     * 归并排序
     * 时间复杂度：O(nlonN)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     */
    public static void mergeSort(int[] array) {
        mergeSortFunc(array, 0, array.length - 1);
    }

    private static void mergeSortFunc(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        //分治排序
        mergeSortFunc(array, left, mid);
        mergeSortFunc(array, mid + 1, right);
        merge(array, left, right, mid);//合并排序
    }

    private static void merge(int[] array, int left, int right, int mid) {
        int s1 = left;
        int s2 = mid + 1;
        int[] tmpArr = new int[right - left + 1];
        int k = 0;

        //合并数组,保持有序
        while (s1 <= mid && s2 <= right) {
            if (array[s2] <= array[s1]) {
                tmpArr[k++] = array[s2++];
            } else {
                tmpArr[k++] = array[s1++];
            }
        }

        while (s1 <= mid) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= right) {
            tmpArr[k++] = array[s2++];
        }

        //复制到tmpArr数组中
        for (int i = 0; i < tmpArr.length; i++) {
            array[i + left] = tmpArr[i];
        }
    }


    /**
     * 归并排序的非递归
     */
    public static void mergeSortNor(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            //从1 、 2 、 4、 8...开始合并，一直到最后完全合并
            for (int i = 0; i < array.length; i += 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                int right = mid + gap;

                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, right, mid);
            }
            gap *= 2;
        }
    }


    /**
     * 计数排序
     * 时间复杂度：
     * 空间复杂度：
     */
    public static void countSort(int[] array) {
        int minVal = array[0];
        int maxVal = array[0];

        //求当前数组的最大值和最小值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
            if (array[i] < minVal) {
                minVal = array[i];
            }
        }

        //根据最大值和最小值得到数组的大小
        int[] count = new int[maxVal - minVal + 1];

        //遍历原来的数组，开始计数
        for (int i = 0; i < array.length; i++) {
            count[array[i] - minVal]++;
        }

        //遍历计数count把当前元素写回array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            //多个数的情况
            while (count[i] > 0) {
                array[index++] = i + minVal;
                count[i]--;
            }
        }
    }

}