package leetcode;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
class Solution15 {
    /**
     * 时间复杂度:O(n)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            //计数器
            int count = 0;
            //进窗口
            while (right < nums.length && nums[right] == 1 && nums[left] == nums[right]) {
                count++;
                right++;
            }
            //判断
            if (ans < count) ans = count;
            //出窗口
            right++;
            left = right;
        }
        //返回连续1的最大个数
        return ans;
    }
}