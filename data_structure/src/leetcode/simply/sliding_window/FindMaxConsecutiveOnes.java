package leetcode.simply.sliding_window;

// 最大连续1的个数
public class FindMaxConsecutiveOnes {
    /*
        给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
        https://leetcode.cn/problems/max-consecutive-ones/description/
     */

    /**
     * 模拟
     * 思路：遍历数组，遇到1则计数，遇到0更新最大1的个数且重置计数器，返回最大1的个数
     * 时间复杂度：O(N)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            // 获取连续1的个数
            while (i < nums.length && nums[i] == 1) {
                count++;
                i++;
            }
            // 获取最大连续1的个数
            max = Math.max(max, count);
            // 重置count
            count = 0;
        }
        return max;
    }


    /*
        给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
        https://leetcode.cn/problems/max-consecutive-ones-iii/description/
     */

    /**
     * 滑动窗口
     * 思路：
     *      1.定义left = 0, right = 0，max = 0, zero = 0;
     *      2.进窗口：如果right对应的值为0，则进窗口，zero++;
     *      3.判断zero>k, 大于则出窗口，出窗口到zero <= k的下标处
     *          出窗口：出left的下标到zero小于等于k处
     *      4.更新结果，获取最大连续1的个数
     *      5.返回结果
     * 时间复杂度：O(N)
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        // 定义双指针
        int left = 0;
        int right = 0;
        // 获取最大1的个数
        int max = 0;
        // 计算0的个数
        int zero = 0;

        while (right < nums.length) {
            // 进窗口，是0则进窗口
            if (nums[right] == 0) zero++;

            // 判断
            while (zero > k) {
                // 出窗口，出0
                if (nums[left] == 0) zero--;
                left++;
            }
            // 更新结果
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
