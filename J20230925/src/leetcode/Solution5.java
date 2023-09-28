package leetcode;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
class Solution5 {
    /**
     * 思路分析: 翻转.
     * 1) 先对数组进行整体翻转[翻转之前让k模上数组长度]
     * 2) 对前k个数字进行翻转
     * 3) 对nums.length - k个数字进行翻转
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @param k    翻转的个数
     */
    public void rotate(int[] nums, int k) {
        //先对k取余,因为轮转了几遍数组和一遍数组是一样的意思
        k %= nums.length;
        //先进行整体翻转
        reverse(nums, 0, nums.length - 1);
        //对前k个数字进行翻转
        reverse(nums, 0, k - 1);
        //对nums.length - k 个数字进行翻转
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }
    }
}