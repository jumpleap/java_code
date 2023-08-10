package leetcode;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
class Solution3 {
    /**
     * 思路分析：遍历数组，若是有相同的元素，直接跳到下一个，不相同把这个值记录到新的下标中去
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 给定数组
     * @return 返回长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        //返回的长度+1
        return index + 1;
    }
}