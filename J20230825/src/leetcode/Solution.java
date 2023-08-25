package leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
class Solution {
    /**
     * 思路分析：左右指针。左指针从前往后，右指针从后往前，交换左右指针的值，直到左右指针相遇后退出
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s 给定的字符数组
     */
    public void reverseString(char[] s) {
        //定义左右指针
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            //左右指针的值交换
            swap(s, left, right);

            //左指针右移，右指针左移
            left++;
            right--;
        }
    }

    private void swap(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }
}