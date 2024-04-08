package test.practice;

public class Demo11 {
    /*
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。
        链接: https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
     */

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(s)
     * 空间复杂度: O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        // 判断数组长度为0的情况
        if (strs.length == 0) return "";

        // 取第一个字符串用作比较
        String ans = strs[0];
        // 从1开始
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 用ans和剩下的字符串比较, 判断是否有公共前缀
            for (; j < ans.length() && j < strs[i].length(); j++) {
                // 当字符不相同, 则说明比较完了 或 不存在公共前缀
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }

            // 获取比较后的前缀, 可能为空串
            ans = ans.substring(0, j);
            // 空串直接返回
            if (ans.equals("")) return ans;
        }
        // 返回公共前缀
        return ans;
    }


    /*
        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
        （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
        链接: https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
     */

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        // 记录s的字符和t字符相同的个数
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            // s的字符和t的字符相同
            if (count < s.length() && s.charAt(count) == t.charAt(i)) {
                count++;
            }
        }
        // 若count和s的长度相等,则说明s为t的子串
        return count == s.length();
    }

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(N)
     * 空间复杂度: O(s)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        // 转为字符数组
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // 记录arr1字符和arr2字符相同的个数
        int p = 0;
        int q = 0;
        // 当有一个超过数组长度, 跳出
        while (p < arr1.length && q < arr2.length) {
            // 相同, 则自增
            if (arr1[p] == arr2[q]) {
                p++;
                q++;
            } else {
                q++;
            }
        }
        // 若q的长度和arr1数组长度相同, 则说明s为t的子串
        return p == arr1.length;
    }

    /*
        给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        例如，121 是回文，而 123 不是。
        链接: https://leetcode.cn/problems/palindrome-number/description/
     */

    /**
     * 思路分析: 把数字转为字符串, 然后把字符串逆置后和原来的字符串进行比较, 判断是否相同
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        // 把数字转为字符串
        String s = String.valueOf(x);
        // 初始化字符串
        StringBuilder str = new StringBuilder();
        // 把数字添加到字符串中
        str.append(x);
        // 逆置
        str.reverse();

        // 把str转为字符串再和s进行比较
        return str.toString().equals(s);
    }

    /**
     * 思路分析: 模拟; 把x重新进行一次模拟, 判断模拟后的数是否和原来的数相同
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // 负数全部为false
        if (x < 0) return false;
        // 小于10大于等于0的数全部为true
        if (x < 10) return true;

        // 其他数进行判断
        int ans = 0;
        // 保存原来的值
        int oldVal = x;
        while (x != 0) {
            // 获取原来的位数
            ans = ans * 10 + x % 10;
            // 获取下一位数
            x /= 10;
        }
        // 比较是否相等
        return oldVal == ans;
    }
}
