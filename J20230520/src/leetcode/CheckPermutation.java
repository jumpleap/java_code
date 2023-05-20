package leetcode;

public class CheckPermutation {
    /**
     * 思路分析：哈希数组计数，判断两个哈希数组中的值是否相等，相等则返回true
     * 时间复杂度：O(n)； 空间复杂度：O(C)
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 返回是否重构
     */
    public boolean checkPermutation(String s1, String s2) {
        //长度不相等，直接返回false
        if (s1.length() != s2.length()) {
            return false;
        }

        //两个计数数组
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        //统计两个字符串中字符的出现次数
        for (int i = 0; i < s1.length(); i++) {
            hash1[s1.charAt(i) - 'a']++;
            hash2[s2.charAt(i) - 'a']++;
        }

        //判断计数数组的每个值是否相等
        for (int i = 0; i < 26; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
}