package leetcode;

public class Solution {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * @param nums 给定的数组
     * @param val  val
     * @return 返回数组新长度
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;//数组长度
        int index = 0;//计数器

        for (int num : nums) {
            //数组中不和val相等的值重新计数
            if (num != val) {
                nums[index++] = num;
            }
        }
        //返回新长度
        return index;
    }

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，
     * 使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     * @param nums 升序数组
     * @return 返回值
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 1;

        while (right < len) {
            //两个值不相等的话：说明已经right已经把重复元素遍历完了
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            } else {
                //相等的话让right指向下一个
                right++;
            }
        }
        return left + 1;
    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
     * 分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * @param nums1 升序数组1
     * @param m     数组长度
     * @param nums2 升序数组2
     * @param n     数组长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int p = m - 1;
        int q = n - 1;
        int cur = 0;

        while (p >= 0 || q >= 0) {
            if (p == -1) {
                //若nums1已经添加完元素
                cur = nums2[q--];
            } else if (q == -1) {
                //若nums2已经添加完元素
                cur = nums1[p--];
            } else if (nums1[p] > nums2[q]) {
                cur = nums1[p--];
            } else {
                cur = nums2[q--];
            }
            nums1[len--] = cur;
        }
    }
}