package leetcode;


public class IsUnique {

    /**
     * 思路分析：哈希映射
     * @param astr 字符串
     * @return 返回布尔值
     */
    public boolean isUnique(String astr) {
        int[] hash = new int[26];
        int len = astr.length();

        for (int i = 0; i < len; i++) {
            int ch = astr.charAt(i) - 'a';
            hash[ch]++;

            //如果有重复的值，则直接返回false
            if (hash[ch] > 1) {
                return false;
            }
        }
        return true;
    }
}
