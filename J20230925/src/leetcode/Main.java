package leetcode;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];

            for(int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            } 
            
            int max = 0;

            for(int i = 0; i < n; i++) {
                int sum = 0;
                for(int j = i; j < n; j++) {
                    sum += nums[j];
                }
                if(sum > max) {
                    max = sum;
                }
            }

            System.out.println(max);
        }
    }
}