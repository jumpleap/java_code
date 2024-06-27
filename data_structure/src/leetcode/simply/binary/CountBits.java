package leetcode.simply.binary;

// 比特位计数
public class CountBits {
    /*
        给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
        返回一个长度为 n + 1 的数组 ans 作为答案。
        https://leetcode.cn/problems/counting-bits/description/
     */

    /**
     * 思路：模拟，获取遍历当前数组，然后计算当前下标对应数中比特1的总数，赋给bitSum数组
     * 时间复杂度：O(NlogN), logN: 计算比特1的个数
     * 空间复杂度：O(N)
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        // 获取所有数的比特1的总和
        int[] bitSum = new int[n + 1];

        // 遍历数组
        for (int i = 0; i <= n; i++) {
            // 计算当前i对应比特1的个数
            int bitCount = getCurrentBitCount(i);
            // 把当前比特1的个数赋给bitSum数组对应的下标
            bitSum[i] = bitCount;
        }
        return bitSum;
    }

    // 获取num中比特1的个数
    private int getCurrentBitCount(int num) {
        int count = 0;

        while (num != 0) {
            count++;
            // 去掉最低位的1
            num = num & (num - 1);
        }
        return count;
    }
}
