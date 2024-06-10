package leetcode.simply.sliding_window;

import java.util.HashSet;
import java.util.Set;

// 无重复字符的最长子串
public class LengthOfLongestSubstring {
    /*
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
        https://leetcode.cn/problems/wtcaE1/description/
     */

    /**
     * 滑动窗口
     * 思路：定义left = 0， right = 0，max = 0【用于计算子串的最长长度】，申请哈希数组
     *      进窗口，把right对应的值映射到哈希数组中，并自增；
     *      判断，判断在哈希数组中right下标对应的值是否大于1，大于则需要出窗口
     *          出窗口：出最left对应的值，一直出到重复元素的后一个值为止
     *      更新结果：判断当前的子串是否为最长的子串
     *      遍历，right++
     *      返回结果
     * 时间复杂度：O(N)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 申请哈希数组
        int[] hash = new int[128];
        // 定义双指针
        int left = 0;
        int right = 0;
        // 用于获取最大值
        int max = 0;

        while (right < s.length()) {
            // 进窗口
            hash[s.charAt(right)]++;

            // 判断
            while (hash[s.charAt(right)] > 1) {
                // 出窗口，一直出到重复字母的后面一个
                hash[s.charAt(left)]--;
                left++;
            }

            // 更新结果
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }


    /**
     * 滑动窗口 + 哈希表
     * 思路：定义left = 0， right = 0，max = 0【用于计算子串的最长长度】，申请哈希表
     *      判断，判断在哈希表中right下标对应的值是否存在，存在则需要出窗口
     *          出窗口：出最left对应的值，一直出到重复元素的后一个值为止
     *      进窗口，把right对应的值映射到哈希表中
     *      更新结果：判断当前的子串是否为最长的子串
     *      遍历，right++
     *      返回结果
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        // 定义哈希表
        Set<Character> set = new HashSet<>();
        // 数组长度
        int n = s.length();
        // 定义双指针
        int left = 0;
        int right = 0;
        // 获取最大值
        int max = 0;

        while (right < n) {
            // 获取当前字符
            char ch = s.charAt(right);
            // 判断
            while (set.contains(ch)) {
                // 出窗口，一直出到重复的字母后面一个
                set.remove(s.charAt(left));
                left++;
            }

            // 进窗口
            set.add(ch);
            // 更新结果
            max = Math.max(max, right - left + 1);
            right++;
        }
        // 返回结果
        return max;
    }
}
