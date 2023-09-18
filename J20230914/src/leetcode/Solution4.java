package leetcode;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 */
class Solution4 {
    /**
     * 思路分析: 双指针.
     * 1) 定义可变字符串s, 遍历str
     * 2) 定义计数器, 判断当前值和下一个值是否相同, 相同则计数器自增,且遍历字符串的下标自增
     * 3) 把统计好当前的字符的个数和当前字符添加到s中
     * 4) 跳出循环, 判断s和str的长度, 那个短则返回那个字符串
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param str 给定字符串
     * @return 返回最短字符串
     */
    public String compressString(String str) {
        //定义一个可变字符串
        StringBuilder s = new StringBuilder();
        //字符串长度
        int len = str.length();

        //遍历字符串
        for (int i = 0; i < len; i++) {
            //定义计数器
            int count = 1;
            //判断是否有相同的值
            while (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
                //计数器自增, 且i指向下一个位置
                count++;
                i++;
            }
            //把count和当前i对应的值添加到s中
            s.append(str.charAt(i));
            s.append(count);
        }

        //比较s的长度和str的长度
        if (s.length() >= len) {
            //s的长度更长, 直接返回原字符串
            return str;
        }
        //否则返回s
        return s.toString();
    }
}