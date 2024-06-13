package leetcode.simply.sliding_window;

// 将x减到0的最小操作数
public class MinOperations {
    /*
        给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
        然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
        如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
        https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
     */

    /**
     * 滑动窗口：把问题反转为求长度最长的子数组，然后数组长度减长度最长的子数组长度，为最小操作数
     * 思路：将问题转变为求长度最长的子数组问题，求target = sum - x；
     *      判断数组nums中最长相加子串的值为target，然后数组长度-最长子串长度，即为最小操作数
     *      若不存在长度最长的子数组，返回-1
     * 时间复杂度：O(N)
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        // 定义双指针
        int left = 0, right = 0;
        // 获取最大长度
        int max = -1;
        // 获取累计和
        int sum = 0;

        // 累加和
        for (int num : nums) sum += num;
        // 获取target
        int target = sum - x;

        // 若是target小于0，则说明找不到【都是正数】
        if (target < 0) return -1;
        // 重置sum
        sum = 0;

        while (right < nums.length) {
            // 进窗口：把right对应的值累加到sum中
            sum += nums[right];

            // 判断
            while (sum > target) {
                // 出窗口：一直出到sum <= target为止
                sum -= nums[left];
                left++;
            }

            // 更新结果
            if (sum == target) {
                // 获取最长子串
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        // 返回结果
        // 1.没有找到最长子串
        // 2.找到了最长子串，得到x-0的最小操作数
        return max == -1 ? max : nums.length - max;
    }
}
