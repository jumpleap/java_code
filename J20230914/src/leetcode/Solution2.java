package leetcode;

/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
class Solution2 {
    /**
     * 思路分析: 模拟匹配.
     * 1) 当needle串中的值和haystack中的值相同的时候,让needle和haystack的下标自增,继续比较
     * 2) 若跳出比较循环后, index的值和needle字符串的长度相同, 那么返回当前haystack的下标
     * 3) 不相同, 回退haystack的下标, 然后在自增
     * 时间复杂度: O(n* m)
     * 空间复杂度:O(1)
     * @param haystack 字符串
     * @param needle 字符串
     * @return 返回匹配的下标, 没有返回-1
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            //定义回退和结果值
            int ret = i;
            //遍历needle字符串的指针
            int index = 0;
            //判断needle的值是否和haystack中的值相同
            while (index < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(index)) {
                //相同让两个下标均自增
                index++;
                i++;
            }
            //判断index是否到neddle字符串的尾部
            if (index == needle.length()) {
                return ret;
            }
            //回退, 防止遇到重复的相同字符串
            i = ret;
        }
        //在haystack中没有和needle相同的子串
        return -1;
    }
}