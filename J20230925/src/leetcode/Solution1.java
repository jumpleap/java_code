package leetcode;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 */
class Solution1 {
    /**
     * 思路分析: 模拟.
     * 得到nums1的数组长度, 然后比较nums1和nums2中的元素大小, 那个大则放在nums1数组的最后面,
     * 最后在判断那个数组的元素还没有放完, 则把该数组的值全部放在nums1数组中
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums1 数组1
     * @param m     数组1的元素个数
     * @param nums2 数组2
     * @param n     数组2的元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1数组的长度
        int len = m + n - 1;
        //nums1元素长度
        m--;
        //nums2的数组长度
        n--;

        //若其中一个已经遍历结束, 那么结束循环
        while (m >= 0 && n >= 0) {
            //判断数字的大小, 谁大谁放在nums1数组的最后面
            if (nums1[m] > nums2[n]) {
                nums1[len--] = nums1[m--];
            } else {
                nums1[len--] = nums2[n--];
            }
        }

        //nums1元素没有遍历完
        while (m >= 0) {
            nums1[len--] = nums1[m--];
        }

        //nums2元素没有遍历完
        while (n >= 0) {
            nums1[len--] = nums2[n--];
        }
    }
}