package leetcode.simply.math;

// 丑数
public class IsUgly {
    /*
        丑数 就是只包含质因数 2、3 和 5 的正整数。
        给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
        https://leetcode.cn/problems/ugly-number/description/
     */

    /**
     * 思路：数学，对2，3，5在循环中模运算判断，然后循环进行整除2，3，5，判断最后剩的是不是1，是1即为丑数
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        // 0 和 负整数不是丑数
        if (n <= 0) return false;

        // 对2，3，5进行模运算，判断是否为0，为0则进入循环使用当前数 / 2，3，5
        // 跳出2，3，5模运算和除运算后，最后判断结果是否为1，为1则是丑数
        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        // 返回结果
        return n == 1;
    }
}
