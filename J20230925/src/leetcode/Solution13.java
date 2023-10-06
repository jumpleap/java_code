package leetcode;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
class Solution13 {
    /**
     * 思路分析: 前缀和; 两次循环, 第一次循环存储左边元素的乘积之和, 第二次循环存储右边的乘积之和.
     * 时间复杂度: O(N)
     * 空间复杂度:O(N)
     * @param nums 给定数组
     * @return 返回结果数组
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int k = 1;

        for (int i = 0; i < ans.length; i++) {
            //当前的数组存储的是当前元素左边的元素乘积
            ans[i] = k;
            k = k * nums[i];
        }

        k = 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            //当前的数组存储的是当前元素右边的元素乘积
            ans[i] *= k;
            k *= nums[i];
        }
        return ans;
    }
}