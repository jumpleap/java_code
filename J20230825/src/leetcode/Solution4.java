package leetcode;

/**
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 */
class Solution4 {
    /**
     * 思路分析：从后往前计数，每三位就添加一个点，若是刚好是3位数或是3的倍数位数，在添加点的时候判断一下是否刚好为最后一位
     * 是最后一位，则不需要添加点，不是则需要把点添加上，最后翻转字符串后返回
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n 给定数字
     * @return 返回分割数字后的字符串
     */
    public String thousandSeparator(int n) {
        StringBuilder s = new StringBuilder();

        //n不是3位数以上的情况
        if (n < 1000) {
            s.append(n);
            return s.toString();
        }

        int count = 0;
        while (n > 0) {
            //获取最后一位数字
            int x = n % 10;
            //计数
            count++;
            //添加到StringBuilder中
            s.append(x);
            if (count == 3 && n / 10 != 0) {
                //判断刚好是3或是3的倍数的位数
                s.append(".");
                //重置计数器
                count = 0;
            }
            //迭代
            n /= 10;
        }
        //翻转字符串并返回字符串
        return s.reverse().toString();
    }
}