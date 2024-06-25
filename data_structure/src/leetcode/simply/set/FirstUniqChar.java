package leetcode.simply.set;


// 字符串中的第一个唯一字符
public class FirstUniqChar {
    /*
        给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
        https://leetcode.cn/problems/first-unique-character-in-a-string/description/
     */
    // 思路: 哈希映射
    public int firstUniqChar(String s) {
        // 定义哈希数组
        int[] ans = new int[26];

        // 建立哈希映射, 把字符串中的值映射到哈希数组中
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
        }

        // 重新遍历字符串中的字符，判断当前字符是否在哈希数组中值等于1的
        // 等于1的即是第一个不重复的元素
        for (int i = 0; i < s.length(); i++) {
            if (ans[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
