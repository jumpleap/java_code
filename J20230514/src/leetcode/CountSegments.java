package leetcode;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
public class CountSegments {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n); 空间复杂度：O(1)
     * @param s 统计字符串中的单词数
     * @return 返回字符串中的单词数
     */
    public static int countSegments(String s) {
        int len = s.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            //判断是不是空格
            if (s.charAt(i) == ' ') {
                continue;
            }

            //遇到空格则跳出循环，计数一次单词数
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            count++;
        }
        return count;
    }
}
