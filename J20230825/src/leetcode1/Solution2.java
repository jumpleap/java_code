package leetcode1;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
class Solution2 {
    /**
     * 法一：特定知识
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s 待处理的字符串
     * @return 返回处理后的字符串
     */
    public String reverseWords1(String s) {
        s = s.trim();//去掉字符串前后的空格
        String[] str = s.split("");//解决单词之间多空格的问题
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            //少添加一个空格
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 双指针：从后往前遍历，若left指针遇到空格，则把当前单词添加到新的字符串中，然后再继续找非空格字符，
     * 并使right指针指向新单词的最后一个字符，依次按照这种套路进行
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s 待处理的字符串
     * @return 返回处理后的字符串
     */
    public String reverseWords(String s) {
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        StringBuilder sb = new StringBuilder();

        while (left >= 0) {
            //找到空格
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            //获取单词，这个地方需要注意前闭后开
            String tmp = s.substring(left + 1, right + 1);
            //拼接单词
            sb.append(tmp + " ");

            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            //找到非空格值
            right = left;//right跳到下一个单词处的最后
        }
        return sb.toString().trim();//注意再次去掉空格
    }
}