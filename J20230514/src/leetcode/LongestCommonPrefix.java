package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    /**
     * 思路分析：用第一个字符串和其他字符串进行比较，用相同部分则把把相同部分的字符串获取到，最后返回这个相同部分的值；
     * 若是没有相同部分，则直接返回空串
     * 时间复杂度：O(mn)；空间复杂度：O(1)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        //数组是null或数组长度为0
        if (strs == null || strs.length == 0) {
            return "";
        }

        int len = strs.length;
        //使用第一个字符串和其他字符串进行比较
        String ret = strs[0];
        for (int i = 1; i < len; i++) {
            //当前字符串数组中的字符串
            String s = strs[i];
            int j = 0;
            //使用当前字符串和第一个字符串进行比较
            for (; j < s.length() && j < ret.length(); j++) {
                //一旦有字符不相等，直接跳出
                if (s.charAt(j) != ret.charAt(j)) {
                    break;
                }
            }
            //获取相等的部分
            ret = ret.substring(0, j);
            //如果是空串
            if (ret.equals("")) {
                return ret;
            }
        }
        return ret;
    }
}