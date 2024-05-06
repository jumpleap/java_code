package sliding_window;

// 滑动窗口
public class Demo1 {
    /*
        给定一个含有 n 个正整数的数组和一个正整数 target 。
        找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
        [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
        链接: https://leetcode.cn/problems/minimum-size-subarray-sum/description/
     */

    /**
     * 思路分析: 滑动窗口(同向双指针)
     *      left用于在sum >= target后进行判断最小值(出窗口), right用于进窗口, 累加sum的值
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 定义同向双指针
        // left用于出窗口找最小值
        int left = 0;
        // right用于进窗口
        int right = 0;
        // 累计和
        int sum = 0;
        // 获取当前最大值
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            // 进窗口
            sum += nums[right];
            // 判断
            while (sum >= target) {
                // 更新结果
                min = Math.min(min, right - left + 1);
                // 出窗口
                sum -= nums[left++];
            }
            right++;
        }
        // 返回结果
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
