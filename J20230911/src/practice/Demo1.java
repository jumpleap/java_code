package practice;

import java.util.Scanner;

/**
 * 代码中基本操作的执行次数
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }

        System.out.println(count);
    }
}
