package leetcode;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */
class Solution7 {
    /**
     * 思路分析: 双指针.
     * 1) 定义左右指针, 左指针指向数组首元素位置, 右指针指向数组最后一个元素的位置
     * 2) 从左到右, 一直找到元音字母为止; 从右到左, 一直找到元音字母为止
     * 3) 交换找到的两个元音字母
     * 4) 返回新字符串
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param s 给定字符串
     * @return 返回翻转后的字符串
     */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            //left找元音字母
            while (left < right && !judge(arr[left])) {
                left++;
            }
            //right找元音字母
            while (left < right && !judge(arr[right])) {
                right--;
            }

            //交换
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            //交换字符后left和right需要移动
            left++;
            right--;
        }

        //返回新字符串
        return new String(arr);
    }

    //判断当前字符是不是元音字符
    private boolean judge(char ch) {
        String compare = "aeiouAEIOU";
        return compare.indexOf(ch) >= 0;
    }
}