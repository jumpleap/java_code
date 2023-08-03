package leetcode;
/*
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
class Solution {
    /**
     * 思路分析：从两个数组有效值的末尾开始比较，把大值放在nums1数组的后面，若某个数组为空后，则把另一个数组的值放在nums1的后面
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums1 数组1
     * @param m 数组1的有效长度
     * @param nums2 数组2
     * @param n 数组2的有效长度 & 实际长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;//nums1数组的长度
        m = m - 1;//nums1的有效长度
        n = n - 1;//nums2的数组长度
        int cur = 0;

        //若两个数组的长度都 == -1 后跳出循环
        while (m >= 0 || n >= 0) {
            if (m == -1) { //nums1中没有元素
                //获取nums2中的值
                cur = nums2[n--];
            } else if (n == -1) { //nums2中没有元素
                //获取nums2中的值
                cur = nums1[m--];
            } else if (nums1[m] < nums2[n]) { //nums1的值 < nums2的值
                cur = nums2[n--];
            } else { //nums1的值 < nums2的值
                cur = nums1[m--];
            }
            //从数组的最后开始添加元素
            nums1[len--] = cur;
        }
    }
}