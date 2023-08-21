package leetcode;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
class Solution5 {
    /**
     * 思路分析：双指针 —— 左右指针。左指针指向数组首位置，右指针指向左指针的右边一位。
     * 当左右指针的值相同时，右指针右移；不相等时，把右指针的值赋给左指针的值，让左指针自增
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定数组
     * @return 返回新数组的长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}