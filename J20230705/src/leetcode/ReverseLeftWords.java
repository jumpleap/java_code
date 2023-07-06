package leetcode;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class ReverseLeftWords {
    /**
     * 法一：取'0'前移
     * 时间复杂度：O(n * len) , 空间复杂度：O(n)
     * @param s 字符串
     * @param n 翻转值
     * @return 返回新的字符串
     */
    public String reverseLeftWords1(String s, int n) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < n; i++) {
            char ch = arr[0];//取第一个字符
            //数组前移
            for (int j = 1; j < len; j++) {
                arr[j - 1] = arr[j];
            }
            //把第一个字符放在最后
            arr[len - 1] = ch;
        }
        s = new String(arr);
        return s;
    }

    /**
     * 法二：三遍逆序
     * 时间、空间复杂度：O(n)
     * @param s 字符串
     * @param n 翻转值
     * @return 返回新的字符串
     */
    public String reverseLeftWords2(String s, int n) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        //逆序三次
        reverse(0, n - 1, arr);
        reverse(n, len - 1, arr);
        reverse(0, len - 1, arr);
        s = new String(arr);
        return s;
    }

    private void reverse(int start, int end, char[] ret) {
        //交换前后的字符
        while (start < end) {
            char tmp = ret[start];
            ret[start] = ret[end];
            ret[end] = tmp;

            start++;
            end--;
        }
    }

    /**
     * 法三：切片连接
     * 时间、空间复杂度：O(n)
     * @param s 字符串
     * @param n 翻转值
     * @return 返回新的字符串
     */
    public String reverseLeftWords3(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        //连接后面的
        for (int i = n; i < len; i++) {
            sb.append(s.charAt(i));
        }
        //连接前面的
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 法四：库函数求解
     * @param s 字符串
     * @param n 翻转值
     * @return 返回新的字符串
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}