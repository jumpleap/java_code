package leetcode.simply.binary;

// 2的幂
public class IsPowerOfTwo {
    /*
        给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
        如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
        https://leetcode.cn/problems/power-of-two/description/
     */

    /**
     * 法一：位运算， num & (num - 1) 去掉最低位的1
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    /**
     * 法二：循环%2，如果为0，进入循环，循环中 /2；不为0，判断结果是不是1，是1返回true
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        // 不存在小于0的情况
        if (n <= 0) return false;

        // 若是2的倍数，则一直%2为0，最后剩个1
        // 若不是2的倍数，%2可能不为0
        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}
