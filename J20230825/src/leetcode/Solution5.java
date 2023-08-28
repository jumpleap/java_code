package leetcode;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
class Solution5 {
    /**
     * 思路分析：从后往前计算，不足长度的字符串补0参与运算。使用一个变量确定当前的计算值是否大于2，大于2则进位
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param a 给定的字符串
     * @param b 给定的字符串
     * @return 返回相加后的字符串
     */
    public String addBinary(String a, String b) {
        //定义字符串
        StringBuilder s = new StringBuilder();

        //获取a,b字符串的长度
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        //进位
        int num = 0;

        //当两个字符串的长度均<0退出
        while (lenA >= 0 || lenB >= 0) {
            //获取当前的进位值
            int sum = num;
            //相加a,b字符串的值
            sum += lenA >= 0 ? a.charAt(lenA) - '0' : 0;
            sum += lenB >= 0 ? b.charAt(lenB) - '0' : 0;

            //添加到字符串中
            s.append(sum % 2);
            //获取进位值
            num = sum / 2;

            lenA--;
            lenB--;
        }
        //判断进位值是否为1
        if (num == 1) s.append(num);
        //翻转字符串并返回
        return s.reverse().toString();
    }
}