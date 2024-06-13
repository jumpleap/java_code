package leetcode.simply.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 找到字符串中所有字母异位词
public class FindAnagrams {
    /*
        给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。
        不考虑答案输出的顺序。变位词 指字母相同，但排列不同的字符串。
        https://leetcode.cn/problems/VabMRr/description/
     */

    /**
     * 滑动窗口
     * 思路：
     *      1.定义哈希数组，hash1,hash2
     *      2.把p字符串中的所有字母入到hash1中，记录字符数量，把s字符串中p字符串长度的字符入到hash2中
     *      3.判断两个数组是否相等，相等则把0下标入到顺序表中
     *      4.出窗口，出hash2中i-p.length()下标的元素，让数量自减
     *      5.进窗口，让hash2入当前元素
     *      6.判断，比较两个字符串是否相等，相等则更新结果
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 申请两个数组，分别用于统计s和p中的字符个数
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        List<Integer> list = new ArrayList<Integer>();

        // 当p长度比s长度，直接返回空的顺序表
        if (p.length() > s.length()) {
            return list;
        }

        // 在p长度内，把s和p的字符统计到两个哈希数组中
        for (int i = 0; i < p.length(); i++) {
            hash1[p.charAt(i) - 'a']++;
            hash2[s.charAt(i) - 'a']++;
        }

        // 判断p数组长度的字符个数是否相等，相等添加0下标
        if (Arrays.equals(hash1, hash2)) {
            list.add(0);
        }

        // 从p长度开始继续进行判断
        for (int i = p.length(); i < s.length(); i++) {
            // 出窗口，出掉hash2数组中0下标的字符，让其-1
            hash2[s.charAt(i - p.length()) - 'a']--;
            // 进窗口，让当前的字符进行哈希表
            hash2[s.charAt(i) - 'a']++;

            // 判断当前hash1和hash2数组是否相等
            if (Arrays.equals(hash1, hash2)) {
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }
}
