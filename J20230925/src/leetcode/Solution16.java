package leetcode;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度
 */
class Solution16 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        int[] hash = new int[128];

        while (right < n) {
            //进窗口
            hash[s.charAt(right)]++;
            //判断
            while (hash[s.charAt(right)] > 1) {
                //出窗口
                hash[s.charAt(left++)]--;
            }
            //更新值56让他从v反对 
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}