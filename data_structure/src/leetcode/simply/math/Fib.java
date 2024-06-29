package leetcode.simply.math;

// 斐波那契数
public class Fib {
    /*
        斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
        该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给定 n ，请计算 F(n) 。
        https://leetcode.cn/problems/fibonacci-number/description/
     */

    // 递归解决 -- 时间复杂度过大，但能通过

    /**
     * 利用递归公式：Fib(n) = Fib(n-1) + Fib(n-2);
     * 时间复杂度：O(2^N)
     * 空间复杂度：O(N)
     * @param n
     * @return
     */
    public int fib1(int n) {
        // 先决条件
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 进行递归计算值
        return fib(n - 1) + fib(n - 2);
    }

    // 迭代解决

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int fib(int n) {
        // 0的情况判断一下
        if (n == 0) return 0;

        // 当n=1时，直接返回1
        int sum = 1;
        // 迭代
        int x = 0;
        int y = 1;

        // 大于1的情况
        while (n > 1) {
            // 累加
            sum = x + y;

            // 进行迭代
            x = y;
            y = sum;
            // n进行迭代
            n--;
        }
        // 返回结果
        return sum;
    }
}