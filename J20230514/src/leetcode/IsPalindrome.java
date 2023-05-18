package leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {
    //法一：转化为字符串解决
    public boolean isPalindrome1(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();

        StringBuilder sb1 = new StringBuilder();
        sb1.append(x);
        return sb.toString().equals(sb1.toString());
    }

    //法二：循环判断重新求x的值，若是原来的值相同，则返回true
    public boolean isPalindrome(int x) {
        //直接判断小于0的情况
        if (x < 0) {
            return false;
        }

        int ret = 0;
        int tmp = x;
        while (tmp != 0) {
            //每次都取各位
            int num = tmp % 10;
            //累加
            ret = ret * 10 + num;
            tmp /= 10;
        }

        //相等则为true
        if (ret == x) {
            return true;
        }
        return false;
    }
}