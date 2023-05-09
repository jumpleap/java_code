package leetcode;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "foo";
        String t = "abc";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        //转化为字符数组
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        //申请两个hash数组用于比较
        int[] hashOne = new int[128];
        int[] hashTwo = new int[128];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            //如果对应的下标是相等的，说明无法进行重构
            if (hashOne[ch1[i]] != hashTwo[ch2[i]]) {
                return false;
            }
            //不相等的话则把i+1的值赋值到hash数组中
            hashOne[ch1[i]] = i + 1;
            hashTwo[ch2[i]] = i + 1;
        }
        //遍历完了则说明了返回true
        return true;
    }
}