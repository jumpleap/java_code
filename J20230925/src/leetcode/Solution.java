package leetcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 */
class Solution {
    /**
     * 思路分析: 模拟.
     * 遍历数组, 遇到和val相同的值则跳过, 遇到和val不相同的值则入到数组中去
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @param val  给定的值
     * @return 返回新数组
     */
    public int removeElement(int[] nums, int val) {
        //记录数组下标
        int index = 0;
        for (int num : nums) {
            //不相等的值直接重放在数组中
            if (num != val) {
                nums[index++] = num;
            }
        }
        //返回数组新长度
        return index;
    }
}