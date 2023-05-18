package leetcode;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class RangeBitwiseAnd {
    /**
     * 法一：循环枚举按位与
     * 时间复杂度：O(n); 空间复杂度：O(1)
     * @param left  左边界
     * @param right 右边界
     * @return 返回公共前缀
     */
    public int rangeBitwiseAnd1(int left, int right) {
        //相等则返回其中一个即可
        if (left == right) {
            return left;
        }

        int ret = left;
        for (int i = left + 1; i <= right; i++) {
            ret = ret & i;
            //如果异或的结果是0，则直接返回0
            if (ret == 0) {
                return 0;
            }
            //如果i已经达到最好一个，那么直接跳出循环
            if (i == 2147483647) {
                break;
            }
        }
        return ret;
    }


    /**
     * 法二：使用 num = num & (num - 1)去掉最低位的1解决[得到公共前缀]
     * 时间复杂度：O(logN); 空间复杂度：O(1)
     * @param left  左边界
     * @param right 右边界
     * @return 返回公共前缀
     */
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}
