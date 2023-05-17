package leetcode;

public class ReverseWords {
    public static void main(String[] args) {

    }

    public static String reverseWords1(String s) {
        //去掉前后空格
        s = s.trim();
        int len = s.length();
        //使用StringBuilder去掉字符串中多余的空格
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            //是空格直接跳过
            if (s.charAt(i) == ' ') {
                continue;
            }
            //不是空格加入到sb中
            while (i < len && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            //不是最后一个单词的话需要加入空格
            if (i != len) {
                sb.append(" ");
            }
        }
        //转为字符串
        s = sb.toString();
        //以空格进行分割
        String[] str = s.split(" ");
        s = "";//置为空串
        //进行逆置单词
        for (int i = str.length - 1; i >= 0; i--) {
            s += str[i];
            //判断是不是最后一个单词
            if (i != 0) {
                s += " ";
            }
        }
        return s;
    }


    //双指针
    public static String reverseWords(String s) {
        s = s.trim();//去掉首尾空格
        int len = s.length();//长度
        StringBuilder sb = new StringBuilder();
        int left = len - 1;//左指针
        int right = left;//右指针

        while (left >= 0) {
            //统计单词空格前的单词
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            //添加单词和空格到StringBuilder里
            sb.append(s.substring(left + 1, right + 1) + " ");
            //过滤掉字符串下个单词后的空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            //让右指针左移
            right = left;
        }
        //返回String
        return sb.toString().trim();
    }
}
