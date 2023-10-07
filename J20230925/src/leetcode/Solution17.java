package leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
class Solution17 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            //进窗口
            sum += nums[right];
            //判断
            while (sum >= target) {
                //更新结果
                len = Math.min(len, right - left + 1);
                //出窗口
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}