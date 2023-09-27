package leetcode;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 */
class Solution4 {
    /**
     * 思路分析: 保留k位重复的数字, 模板
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @return 返回数组的新下标
     */
    public int removeDuplicates(int[] nums) {
        return removeProcess(nums, 2);
    }

    private int removeProcess(int[] nums, int k) {
        //记录数组新的下标
        int index = 0;

        for (int num : nums) {
            //保留k为相同的值, 剩下的值也需要保留k位
            if (index < k || nums[index - k] != num) {
                nums[index++] = num;
            }
        }
        //返回数组的新长度
        return index;
    }
}