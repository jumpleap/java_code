package leetcode;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
class Solution14 {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums 给定数组
     * @param k    k
     * @return 返回连续长度
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zero = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            //进窗口
            if (nums[right] == 0) zero++;
            //判断
            while (zero > k) {
                if (nums[left++] == 0) {
                    //出窗口
                    zero--;
                }
            }
            //更新结果
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}