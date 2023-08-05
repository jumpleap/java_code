package leetcodeplus;

/*
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，
请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
class Solution1 {
    /**
     * 思路分析：模拟 -> 需要考虑四种情况
     * 1.首部空格 -> 删除即可，遍历字符串删除
     * 2.符号位 -> sign = 1 若是‘-’则需要把sign置为-1，然后越过当前符号为
     * 3.非数字字符 -> 遇见非数字字符直接返回当前的数字大小
     * 4.数字字符越界问题
     *      1) 若数字大小大于 边界值(Integer.MAX_VALUE / 10)
     *      2) 若数字大小等于总和且当前字符大于7
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param str 给定的字符串
     * @return 返回对应的数字大小
     */
    public int strToInt(String str) {
        //计算str中数字
        int sum = 0;
        //用于边界处理
        int boundary = Integer.MAX_VALUE / 10;
        int i = 0;
        //定义符号位
        int sign = 1;
        int length = str.length();

        //字符串长度为0
        if (length == 0) {
            return 0;
        }
        //删掉前面的空格
        while (str.charAt(i) == ' ') {
            i++;
            //判断是否到达字符串的最后
            if (i == length) {
                return 0;
            }
        }

        //判断符号位
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        //判断完符号位后让i自增
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }

        //遍历字符串
        for (; i < length; i++) {
            char ch = str.charAt(i);
            //非法字符
            if (ch < '0' || ch > '9') {
                break;
            }
            //边界判断：若sum已经大于boundary或sum 等于boundary 且当前字符大于7
            //说明，接下来会越界
            if (sum > boundary || sum == boundary && ch > '7') {
                //越界的时候判断符号位，若是‘-’,返回最小值
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //获取字符串当前的数字
            sum = sum * 10 + (ch - '0');
        }
        //到这个地方有两个情况
        //1，非法字符在后面，返回非法字符前的数字大小
        //2.正常返回数字大小
        return sum * sign;
    }
}