package leetcode;

/*
编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 */
public class HamMingWeight {
    /**
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param n 要求的1的个数
     * @return 返回1的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);//消除最低位的1
            count++;
        }
        return count;
    }

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param n 要求的1的个数
     * @return 返回1的个数
     */
    public int hammingWeight1(int n) {
        int count = 0;
        //遍历32个位并进行判断这些位那些是1
        for(int i = 0; i < 32; i++) {
            if(((n >> i) & 1) == 1) {
                count++;//统计
            }
        }
        return count;
    }
}
