package leetcode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
 * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
class Solution19 {
    /**
     * 思路分析: 双指针.
     * 1) 判断左指针的值, 若是左指针的值不是数字和字母字符, 那么则让左指针右移
     * 2) 判断右指针的值, 若是右指针的值不是数字和字母字符, 那么让右指针左移
     * 3) 判断左右指针的值是否相等, 不相等则返回false
     * 4) 相等的字符则让左右指针右移
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param s 给定字符串
     * @return 发挥真/假
     */
    public boolean isPalindrome(String s) {
        //把字符串中的大写字母全部转化为小写字母
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            //非数字和字母字符则让left右移
            while (left < right && !isChar(s.charAt(left))) {
                left++;
            }
            //非数字和字母字符则让right左移
            while (left < right && !isChar(s.charAt(right))) {
                right--;
            }

            //不相等就不是回文串
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            //相等的话让左右指针均移动
            left++;
            right--;
        }
        //是回文串则返回true
        return true;
    }

    //判断是不是合理的字符
    private boolean isChar(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
            return true;
        }
        return false;
    }
}