package leetcode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
class Solution1 {
    /**
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     * @param x 目标值的平方根
     * @return 返回算术平方根
     */
    public int mySqrt(int x) {
        //定义要查找数的范围
        int left = 1;
        int right = x;
        //结果值
        int ret = 0;

        //当left > right时跳出循环
        while (left <= right) {
            //取中间值
            int mid = left + (right - left) / 2;
            //思考：到这个地方，应该怎么想队左右区间的划分及值的判断？
            //若是mid * mid <= x -> 记录mid值并往右区间查找，反之，左区间
            //注意：这里使用mid * mid 会超过int的范围，改为 mid <= x / mid
            if (mid <= x / mid) {
                //保存mid值在ret中，且继续往在右区间内查找
                left = mid + 1;
                //记录当前的mid，该mid可能为算术平方根
                ret = mid;
            } else {
                //在左边区间内查找
                right = mid - 1;
            }
        }
        //返回最后的结果
        return ret;
    }
}