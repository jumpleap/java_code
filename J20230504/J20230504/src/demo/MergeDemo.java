package demo;

import java.util.Arrays;
@SuppressWarnings({"all"})

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 */
public class MergeDemo {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3}, 6, new int[]{3, 4, 5}, 3);
        merge1(new int[]{1, 2, 3}, 6, new int[]{3, 4, 5}, 3);
    }

    /**
     * 法一
     * 思路：两个数组都是有序的，两个数组从有效长度的最大下标进行比较，那个大即那个在nums1数组最后的下标开始
     * 一直到nums1数组被填充完为止
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;//数组总长度
        int p = m - 1;//nums1的有效长度
        int q = n - 1;//nums2的有效长度
        int cur = 0;

        //把两个有效长度对应的元素都已经加载到nums1中去
        while (p >= 0 || q >= 0) {
            if (p == -1) {
                //nums1已经没有元素了
                cur = nums2[q--];
            } else if (q == -1) {
                //nums2已经没有元素了
                cur = nums1[p--];
            } else if (nums1[p] > nums2[q]) {
                cur = nums1[p--];
            } else {
                cur = nums2[q--];
            }
            //添加到nums1的最后面
            nums1[len--] = cur;
        }
    }

    /**
     * 法二：排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        //把nums2的内容填充到nums1的后面
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        //排序
        Arrays.sort(nums1);
    }
}
