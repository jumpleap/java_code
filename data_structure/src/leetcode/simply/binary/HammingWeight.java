package leetcode.simply.binary;

// 求数字中比特1的个数
public class HammingWeight {
    /*
        编写一个函数，输入是一个无符号整数（以二进制串的形式），
        返回其二进制表达式中 设置位的个数（也被称为汉明重量）。
        链接：https://leetcode.cn/problems/number-of-1-bits/description/?envType=study-plan-v2&envId=top-interview-150
     */

    /**
     * 法一：模拟比较
     * 思路：将数字的32个比特位全部按位与1，若是1则计数一次，最后返回结果
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public int hammingWeight1(int n) {
        // 计数
        int count = 0;

        for (int i = 0; i < 32; i++) {
            // 判断1的个数
            if ((n >> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 法二：技巧： num = num & (num - 1) -> 每次消掉最低位的1，直至变为0
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            // 消掉最低位的1
            n = (n - 1) & n;
        }
        return count;
    }
}
