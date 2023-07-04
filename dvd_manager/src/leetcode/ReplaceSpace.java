package leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {
    /**
     * 法一：StringBuilder中的append进行拼接
     * 时间、空间复杂度：O(n)
     * @param s 字符串
     * @return 返回字符串
     */
    public String replaceSpace1(String s) {
        //使用StringBuilder对象
        StringBuilder sb = new StringBuilder();
        int len = s.length();//长度
        for (int i = 0; i < len; i++) {
            //判断字符串是否为空或不为空
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 法二：字符串的replace方法或replaceAll方法
     * @param s 字符串
     * @return 返回字符串
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
