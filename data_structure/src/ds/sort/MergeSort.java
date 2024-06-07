package ds.sort;

// 归并排序
public class MergeSort {

    /**
     * 归并排序
     * 思想：归并排序是一种采用分治策略的排序算法。
     *      其基本思想是将待排序序列分成两半，递归地对左右两半分别进行排序，
     *      然后将两个已排序的子序列合并成一个最终的有序序列。
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * 稳定性：稳定
     * @param arr
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        // 左边只有一个节点或一个节点也没有的情况
        if (left >= right) return;

        // 取中值
        int mid = left + (right - left) / 2;

        // 分而治之
        // 对左半部分进行归并排序
        mergeSort(arr, left, mid);
        // 对右半部分进行归并排序
        mergeSort(arr, mid + 1, right);
        // 合并两个已排序的子数组
        merge(arr, left, right, mid);
    }

    // 合并两个有序数组的操作
    private void merge(int[] arr, int left, int right, int mid) {
        // 创建临时数组
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int index = 0;

        // 进行合并
        while (i <= mid && j <= right) {
            // 谁小谁放在前面
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        // 判断左半部分是否放完
        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        // 判断右半部分是否放完
        while (j <= right) {
            temp[index++] = arr[j++];
        }

        // 将临时数组中的值赋给arr数组
        System.arraycopy(temp, 0, arr, left + 0, temp.length);

    }
}
