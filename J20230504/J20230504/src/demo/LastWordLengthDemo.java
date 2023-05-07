package demo;

import java.util.Scanner;

public class LastWordLengthDemo {
    //法一
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //找到最后一个空格的位置，返回其下标
        int end = str.lastIndexOf(' ');
        //获取字符串的长度
        int len = str.length() - 1;
        //两个相减即为最后单词的长度
        System.out.println(len - end);
    }

    //法二
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //转成字符数组
        char[] ch = str.toCharArray();
        int count = 0;//计算遇到空格之前的字符
        int len = ch.length - 1;//长度

        //统计空格之前的字符
        while (len >= 0) {
            if (ch[len] != ' ') {
                count++;
            } else {
                break;
            }
            len--;
        }

        System.out.println(count);
    }
}
