package leetcode;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
class Solution7 {
    /**
     * 思路分析: 左右指针.
     * 1) 左指针指向最小的股票买入
     * 2) 右指针遍历数组, 若是遇到右指针-左指针的值大于0的时候, 那么把该值添加到总利润中去
     * 3) 让左指针指向右指针的位置, 因为之前的买过的不能在进行买入,右指针继续遍历数组
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param prices 价格数组
     * @return 返回总利润最大值
     */
    public int maxProfit(int[] prices) {
        int left = 0;
        int sum = 0;
        for (int right = 1; right < prices.length; right++) {
            int profit = prices[right] - prices[left];
            //利润大于0则添加到总利润中去
            if (profit > 0) {
                sum += profit;
            }
            //left不管是profit<0还是profit>0,均需要走到right的位置
            left = right;
        }
        return sum;
    }
}