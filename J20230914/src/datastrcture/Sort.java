package datastrcture;

/**
 * 归并排序 -- 分而治之
 */
public class Sort {
    /**
     * 递归版本
     */
    public static void mergeSortFunc(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        //左边只有一个节点或一个节点都没有
        if (left >= right) return;
        //取中间值
        int mid = (left + right) / 2;

        //递归分而治之
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        //合并数据
        merge(array, left, right, mid);
    }

    private static void merge(int[] array, int left, int right, int mid) {
        //第一个区间的开始位置
        int s1 = left;
        //第二个区间的开始位置
        int s2 = mid + 1;
        //临时数组, 保存有序值
        int[] tmpArr = new int[right - left + 1];
        //下标
        int index = 0;

        //合并并排序两个区间
        while (s1 <= mid && s2 <= right) {
            //小值放在前面
            if (array[s1] < array[s2]) {
                tmpArr[index++] = array[s1++];
            } else {
                tmpArr[index++] = array[s2++];
            }
        }

        //把没有添加完元素的区间放在tmpArr中
        while (s1 <= mid) {
            tmpArr[index++] = array[s1++];
        }
        while (s2 <= right) {
            tmpArr[index++] = array[s2++];
        }

        //把tmpArr中的元素重写到array中
        for (int i = 0; i < tmpArr.length; i++) {
            array[i + left] = tmpArr[i];
        }
    }

    /**
     * 归并排序的非递归版本
     */
    public static void mergeSortNor(int[] array) {
        //排序组数
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                //划分区间
                int left = i;
                int mid = left + gap - 1;
                int right = mid + gap;

                //防止溢出
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                if (right >= array.length) {
                    right = array.length - 1;
                }
                //进行合并,然后排序
                merge(array, left, right, mid);
            }
            //分组排序
            gap *= 2;
        }
    }
}