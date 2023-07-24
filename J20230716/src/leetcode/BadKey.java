package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
 */

public class BadKey {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            badKey(s1,s2);
        }
    }

    /**
     * 输出坏掉的键
     * @param src
     * @param output
     */
    private static void badKey(String src, String output) {
        Set<Character> set = new HashSet<>();

        //把output中的字符全部统计到set中
        for(char ch : output.toUpperCase().toCharArray()) {
            set.add(ch);
        }

        Set<Character> set2 = new HashSet<>();
        //使用src中的字符和set中的字符进行比较，若不包含则是坏掉的键
        for(char ch : src.toUpperCase().toCharArray()) {
            //使用额外的set是防止打印出重复的坏键
            if(!set.contains(ch) && !set2.contains(ch)) {
                System.out.print(ch);//输出坏掉的键
                set2.add(ch);
            }
        }
    }
}