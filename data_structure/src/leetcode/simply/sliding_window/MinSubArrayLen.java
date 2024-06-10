package leetcode.simply.sliding_window;

// 长度最小的子数组
public class MinSubArrayLen {
    /*
        给定一个含有 n 个正整数的数组和一个正整数 target 。
        出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
        并返回其长度。如果不存在符合条件的子数组，返回 0 。
        https://leetcode.cn/problems/2VG8Kg/description/
     */

    /**
     * 滑动创建【同向双指针】
     * 思路：定义双指针left = 0,right = 0，定义sum用于累计和，每次循环累加right对应的值，
     *      然后判断sum是否大于target，大于则出窗口，更新结果
     * 时间复杂度：O(N)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 获取最小距离
        int min = Integer.MAX_VALUE;
        // 计算left到right的累计和
        int sum = 0;
        // 定义双指针
        int left = 0;
        int right = 0;

        // 当right到达数组末尾跳出循环
        while (right < nums.length) {
            // 进窗口
            sum += nums[right];

            // 判断
            while (sum >= target) {
                // 更新结果
                min = Math.min(right - left + 1, min);
                // 出窗口
                sum -= nums[left];
                left++;
            }
            right++;
        }
        // 判断结果
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
