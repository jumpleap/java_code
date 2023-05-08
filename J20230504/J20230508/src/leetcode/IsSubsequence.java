package leetcode;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence {
    public static void main(String[] args) {

    }

    /**
     * 判断s是不是t的子串
     * @param s 字符串1
     * @param t 字符串2
     * @return 返回值判断是不是字串
     */
    public boolean isSubsequence(String s, String t) {
        //把字符串转化为字符数组
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int p = 0;
        int q = 0;

        while (p < ch1.length && q < ch2.length) {
            //判断s字符串的字符和t的字符是否相等
            if (ch1[p] != ch2[q]) {
                //不相等让q指向下一个
            } else {
                //相等让p和q均指向下一个
                p++;
            }
            q++;
        }
        //判断p是否到达字符串最后
        return p == ch1.length;
    }
}
