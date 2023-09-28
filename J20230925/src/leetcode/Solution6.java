package leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
class Solution6 {
    /**
     * 思路分析: 贪心
     * 1) 找到买入股票的最小值, 在最小值进行买入
     * 2) 用数组的其他数字和最小值进行比较, 找到最大的股票利润
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param prices 价格数组
     * @return 返回最大利润
     */
    public int maxProfit(int[] prices) {
        //记录股票的最小值
        int minPrice = prices[0];
        //最大利润
        int profit = 0;

        for (int price : prices) {
            //找到买入股票的最小值
            minPrice = Math.min(minPrice, price);
            //查找获取最大利润值
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }
}