package demo;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class MaxProfitII {
    public static void main(String[] args) {
        //Object
    }

    /**
     * 把所有的正收益都记录下来
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 1; i < len; i++) {
            //把所有收益大于0的股票买入后抛出
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
