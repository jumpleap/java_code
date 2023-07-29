package leetcode;

/*
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student.
"，则输出"student. a am I"。
 */
public class ReverseWords {
    /**
     * 思路一：库函数解决：使用split方法进行单词的拆分，最后往后面遍历拼接
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        s = s.trim();//
        String[] str = s.split("\\s+");//解决单词之间多空格的问题
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
     * 思路二：双指针，从字符串的后面遍历，每次往前面找空格，遇到空格后就把当前单词拼接到新字符串中，遇到连续空格需要跳过
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
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
            //获取单词
            String tmp = s.substring(left + 1, right + 1);
            //拼接单词
            sb.append(tmp + " ");

            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;//right跳到下一个单词处的最后
        }
        return sb.toString().trim();//注意再次去掉空格
    }
}