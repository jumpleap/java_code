package leetcode;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class NumWays {
    /**
     * 思路分析：斐波那契数的变种，使用递归会溢出
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int numWays(int n) {
        int x = 0;
        int y = 1;

        //若是处在0阶或1阶的话，那么结果就是1阶
        int sum = 1;
        //台阶数需要大于0
        while (n > 0) {
            //结果需要取模
            sum = (x + y) % 1000000007;
            //迭代
            x = y;
            y = sum;
            n--;
        }
        //返回可以跳的方法数
        return sum;
    }
}