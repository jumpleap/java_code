package demo;

/**
 * 求最后一个单词的长度【最后有空格】
 */
public class LengthOfLastWord {
    //法一：使用Java中的API解决
    public int lengthOfLastWord1(String s) {
        String str = s.trim();//去掉前后空格
        int len = str.length() - 1;//得到新字符串的新长度
        int endWordLen = str.lastIndexOf(' ');//计算最后一个空格的位置
        return len - endWordLen;
    }

    //法二：字符数组
    public int lengthOfLastWord(String s) {
        //转化为字符数组
        char[] ch = s.toCharArray();
        int len = ch.length - 1;//数组的长度
        int count = 0;//计算最后一个单词的长度
        int flag = 0;//标记位，用于判断字符串最后有空格的情况

        for (int i = len; i >= 0; i--) {
            //判断字符串的最后是不是空格
            if (ch[i] == ' ') {
                //是1则说明已经计算完最后单词的长度
                if (flag == 1)
                    break;
                else
                    continue;//字符串的后面有空格
            }
            count++;
            flag = 1;//不是空格后标记为1
        }
        return count;
    }
}