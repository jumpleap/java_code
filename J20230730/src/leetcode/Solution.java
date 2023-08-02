package leetcode;

class Solution {
    /**
     * 思路分析：二分查找 -> 条件：mid * mid <= x；
     * 若条件成立，往右区间找并记录当前的mid值:left = mid +1;
     * 条件不成立，往左边找：right = mid -1;
     * 时间复杂度：O(logn)
     * @param x 给定的值
     * @return 返回x的算术平方根
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