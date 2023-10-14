package leetcode;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
class Solution1 {
    /**
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s 给定字符串
     * @return 返回最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;

        //去掉后面的空格
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }

        //固定最后一个单词的最后一个字符
        int left = right;
        while (right >= 0) {
            //判断空格
            if (s.charAt(right) != ' ') {
                right--;
            } else {
                break;
            }
        }
        //返回最后一个单词的长度
        return left - right;
    }


    //法一：使用Java中的API解决
    public int lengthOfLastWord1(String s) {
        String str = s.trim();//去掉前后空格
        int len = str.length() - 1;//得到新字符串的新长度
        int endWordLen = str.lastIndexOf(' ');//计算最后一个空格的位置
        return len - endWordLen;
    }
}