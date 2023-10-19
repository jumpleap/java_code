package demo;

import java.util.Scanner;

/**
 * 完全数计算
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int count = 0;

            for (int i = 1; i <= n; i++) {
                if (judge(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean judge(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}