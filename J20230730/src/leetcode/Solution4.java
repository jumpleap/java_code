package leetcode;

/*
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
class Solution4 {
    /**
     * 思路分析：左右指针 -> 让右指针遍历整个数组
     * 右值 > 左值：计算利润差并与最大利润进行比较；右值 < 左值：左指针指向右指针的位置
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param prices 给定的价格数组
     * @return 返回最大利润
     */
    public int maxProfit(int[] prices) {
        int maxBenefit = 0;//最大利润
        //左右指针
        int left = 0;
        for (int right = 1; right < prices.length; right++) {
            //左指针的值大于右指针
            if (prices[left] > prices[right]) {
                //左指针移到右指针的位置，右指针指向下一个位置
                left = right;
            } else {
                //获取两个的利润值
                int gap = prices[right] - prices[left];
                //判断当前的利润值是否大于最大利润的值
                if (maxBenefit < gap) {
                    //大于则把当前的利润值设为最大利润
                    maxBenefit = gap;
                }
            }
        }
        //返回最大利润
        return maxBenefit;
    }
}