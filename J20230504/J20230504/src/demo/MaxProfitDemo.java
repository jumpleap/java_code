package demo;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class MaxProfitDemo {
    public static void main(String[] args) {

    }

    /**
     * 法一：暴力比较
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //循环比较
                int tmp = prices[j] - prices[i];
                if (max < tmp) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    /**
     * 快慢指针：当快指针的值-慢指针的值小于等于0时，让left移到right的位置，right右移一个
     * 用一个变量获取正值，如果比max大，则赋值给max，让right指向下一个位置
     */
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int max = 0;
        int left = 0;//慢指针
        int right = 1;//快指针

        //限制条件
        while (right < len) {
            //判断左右指针的值是否大于0
            if (prices[right] - prices[left] <= 0) {
                left = right;
                right++;
                continue;
            }
            //获取左右指针之差
            int tmp = prices[right] - prices[left];
            //判断大小
            if (tmp > max) {
                max = tmp;
            }
            //让右指针右移
            right++;
        }
        return max;
    }
}