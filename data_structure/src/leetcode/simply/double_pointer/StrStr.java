package leetcode.simply.double_pointer;

// 找出字符串中第一个匹配项的下标
public class StrStr {
    /*
        给你两个字符串 haystack 和 needle ，
        请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
        如果 needle 不是 haystack 的一部分，则返回  -1 。
        https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
     */

    /**
     * 双指针
     * 思路：定义i指向haystack的值，定义j指向needle首下标的值，对两者进行遍历，相等则i++,j++，
     *      最后判断j是否到达needle字符串的末尾，是返回i下标，不是使用i下标的下一个值继续比较
     * 时间复杂度：O(N * M)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // 获取字符串长度
        int n = haystack.length();
        int m = needle.length();

        // 遍历字符串
        for (int i = 0; i < n; i++) {
            // 获取haystack字符串下标
            int x = i;
            // 从0开始使用needle字符串和haystack字符进行比较
            int y = 0;

            // 1.下标不能越界
            // 2.x和y下标对应的值相等
            while (x < n && y < m && haystack.charAt(x) == needle.charAt(y)) {
                // x，y均指向下一个值
                x++;
                y++;
            }

            // 判断needle字符串是否已经遍历到末尾
            if (y == m) {
                // 是的话，则返回haystack字符串当前下标
                return i;
            }

        }

        // 没有对应的子串
        return -1;
    }
}
