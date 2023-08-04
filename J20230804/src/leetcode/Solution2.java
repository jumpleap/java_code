package leetcode;
/*
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */

class Solution2 {
    /**
     * 思路分析：模拟 -> 获取两个字符串的长度，申请一个StringBuilder，每次获取两个字符串的末尾字符，
     * 进行相加，若值大于10，则进位，然后把%10的值添加到StringBuilder中，字符串字符都获取完之后再判断是否有进位
     * 有进位则需要把这个进位添加到StringBuilder中去，然后翻转StringBuilder，在转化成字符串返回
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 返回相加后的字符串
     */
    public String addStrings(String num1, String num2) {
        //获取两个字符串的长度
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        //申请一个StringBuilder
        StringBuilder s = new StringBuilder();
        //获取是否进10，进10则为1，不进10则为0
        int digit = 0;

        //len1 == -1 && len2 == -1时跳出循环
        while (len1 >= 0 || len2 >= 0) {
            //获取num1和num2字符串的最后一位
            int ch1 = (len1 == -1 ? 0 : num1.charAt(len1) - '0');
            int ch2 = (len2 == -1 ? 0 : num2.charAt(len2) - '0');

            //计算ch1 + ch2 + 是否进位的和
            int sum = ch1 + ch2 + digit;
            //判断是否进位
            digit = sum / 10;
            //大于10则截断10的部分
            sum %= 10;
            //把数字添加到StringBuilder中
            s.append(sum);

            //判断两个字符串的长度是否为-1
            if (len1 != -1) {
                len1--;
            }
            if (len2 != -1) {
                len2--;
            }

        }

        //判断是否还有进位值
        if (digit == 1) {
            //把进位值添加到StringBuilder中
            s.append(digit);
        }
        //翻转StringBuilder且返回字符串
        return s.reverse().toString();
    }
}