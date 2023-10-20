package practice_day;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，
 * 和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * 1≤n≤1000
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            //获取小写字符串
            String s = in.nextLine().toLowerCase();
            //获取小写字符
            char ch = in.nextLine().toLowerCase().charAt(0);

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                //相等则++
                if (s.charAt(i) == ch) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}